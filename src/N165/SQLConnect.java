///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package N165;
//
//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import java.sql.Connection;
//
///**
// *
// * @author Admin
// */
//public class SQLConnect {
//    public static void sqlConnect(String user, String pass, String server, int port) {
//        try {
//            SQLServerDataSource ds = new SQLServerDataSource();
//            //ds.setHostNameInCertificate("localhost");
//            ds.setUser(user);
//            ds.setPassword(pass);
//            ds.setDatabaseName("LTM");
//            ds.setServerName(server);
//            ds.setPortNumber(port);
//            try ( Connection cnn = ds.getConnection()) {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                System.out.println("Kết nối thành công SQL");
//                System.out.println(cnn.getCatalog());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void main(String[] args) {
//        new SQLConnect().sqlConnect("sa", "123", "ADMIN", 1433);
//    }
//            
//}
