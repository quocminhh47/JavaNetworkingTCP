/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package N165;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServerCtr {

    private String sign;
    private int port;
    private String host;
    private DAO dao;
    private ServerSocket myServer;
    private ArrayList<Socket> list;
    private ArrayList<Student> std;
    public String server, cong, user, pass;
    Flag f = new Flag();
    public ServerCtr() {
        port = 6789;
        host = "localhost";
        dao = new DAO();
        list = new ArrayList<>();
        openSocket();
        while (true) {
            try {
                Socket s = myServer.accept();
                list.add(s);
                execute(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openSocket() {
        try {
            myServer = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute(Socket s) throws ClassNotFoundException, IOException {
        switch (getSign(s)) {
            case "1":
                System.out.println("Kết nối 1 thành công");
                break;
            case "2":
                System.out.println("Kết nối 2 thành công");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                server = dis.readUTF();
                cong = dis.readUTF();
                user = dis.readUTF();
                pass = dis.readUTF();
                System.out.println(server + cong + user + pass);
                dao.testConnection(server, Integer.parseInt(cong), user, pass);
                
                if(f.flagCSDL == true){
                    sendResult("ok");
                    new ServerView().showMessage("Kết nối CSDL thành công");
                    
                }
                if(f.flagCSDL == false) {
                    sendResult("failed");
                    new ServerView().showMessage("Kết nối CSDL thất bại");
                }
                
                break;
            case "3":
                try {
                    int cong2 = Integer.parseInt(cong);
                    Student ss = receiveStudent(s);
                if (dao.addStudent(ss, server, cong2, user, pass )) {
                    sendResult("ok");
                    new ServerView().showMessage("Success!");
                } else {
                    sendResult("failed");
                    new ServerView().showMessage("Failed!");
                }
            } catch (Exception e) {
                sendResult("ok");
                new ServerView().showMessage("Success!");
                e.printStackTrace();
            }
                // get list student tu csdl
                std = dao.getListStudent();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()) ;
                oos.writeObject(std);
        }

    }

    public Student receiveStudent(Socket s) {
        Student ss = null;
        DES des = new DES();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ss = (Student) ois.readObject();
            ss.setMaSV(des.des(ss.getMaSV()) );
            ss.setHoTen(des.des(ss.getHoTen()) );
            ss.setToan(des.des(ss.getToan()) );
            ss.setVan(des.des(ss.getVan()) );
            ss.setAnh(des.des(ss.getAnh()) );
            ss.setAvg(des.des(ss.getAvg()) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ss;
    }

    public void sendResult(String res) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(list.get(list.size() - 1).getOutputStream());
            oos.writeObject(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSign(Socket s) throws ClassNotFoundException {
        String i = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            i = (String) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

}
