/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package N165;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DAO {
    static Flag f = new Flag();
    private Connection conn;
    static DefaultTableModel dtm;
    public static ArrayList<Student> list;
    DES des = new DES();

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=LTM;"
                    + "username=sa;password=123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void testConnection(String server, int port, String user, String pass) {

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(pass);
        ds.setDatabaseName("LTM");
        ds.setServerName(server);
        ds.setPortNumber(port);
        try ( Connection cnn = ds.getConnection()) {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Kết nối thành công SQL");
            System.out.println(cnn.getCatalog());
            String mess = "SERVER ĐÃ NHẬN DỮ LIỆU KẾT NỐI";
            System.out.println(mess);
            f.flagCSDL = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            String mess = "Lỗi kết nối CSDL Server";
            System.out.println(mess);
            f.flagCSDL = false;
        }
        //dos.writeUTF(mess);

    }

    public boolean addStudent(Student s, String server, int port, String user, String pass) {
        String sql = "INSERT INTO LTM(MaSV, HoTenSV, DiemToan, DiemVan, DiemTA, AVG) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser(user);
            ds.setPassword(pass);
            ds.setDatabaseName("LTM");
            ds.setServerName(server);
            ds.setPortNumber(port);
            Connection conn = ds.getConnection();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSV());
            ps.setString(2, s.getHoTen());
            ps.setString(3, s.getToan());
            ps.setString(4, s.getVan());
            ps.setString(5, s.getAnh());
            ps.setString(6, s.getAvg());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            new ServerView().showMessage("KẾT NỐI CSDL THẤT BẠI, THỬ LẠI!");
            System.out.println("KẾT NỐI CSDL THẤT BẠI, THỬ LẠI!");
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM LTM";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setMaSV(rs.getString("MaSV"));
                s.setHoTen(rs.getString("HoTenSV"));
                s.setToan(rs.getString("DiemToan"));
                s.setVan(rs.getString("DiemVan"));
                s.setAnh(rs.getString("DiemTA"));
                s.setAvg(rs.getString("AVG"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public void showTable() {
        clientFrm f = new clientFrm();
        list = new DAO().getListStudent();
        dtm = (DefaultTableModel) f.tableSV.getModel();
        dtm.setColumnIdentifiers(new Object[]{
            "Mã SV", "Họ tên", "Điểm Toán", "Điểm Văn", "Điểm Anh", "AVG"
        });

        for (Student st : list) {
            try {
                dtm.addRow(new Object[]{
                    des.des_Decrypt(st.getMaSV()), des.des_Decrypt(st.getHoTen()), des.des_Decrypt(st.getToan()),
                    des.des_Decrypt(st.getVan()), des.des_Decrypt(st.getAnh()), des.des_Decrypt(st.getAvg())
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<Student> getStringStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM LTM";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setMaSV(des.des_Decrypt(rs.getString("MaSV")));
                s.setHoTen(des.des_Decrypt(rs.getString("HoTenSV")));
                s.setToan(des.des_Decrypt(rs.getString("DiemToan")));
                s.setVan(des.des_Decrypt(rs.getString("DiemVan")));
                s.setAnh(des.des_Decrypt(rs.getString("DiemTA")));
                s.setAvg(des.des_Decrypt(rs.getString("AVG")));
                s.toString();
                list.add(s);
                //System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
         new DAO().testConnection("DESKTOP-UT3VJ3N", 1433, "sa",  "123");
         System.out.println(f.flagCSDL);
    }
}
