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
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClientCtr {

    // private int port;
    //private String host;
    Flag f = new Flag();
    private Socket mySocket;

    public Socket getMySocket() {
        return mySocket;
    }

    public void setMySocket(Socket mySocket) {
        this.mySocket = mySocket;
    }

    public ClientCtr() {

        //  host = "localhost";
        //  port = 6789;
    }

    public void openSocket(String host, int port) {
        try {
            mySocket = new Socket(host, port);
            f.flag = true;
            f.flag2 = true;
            f.flag3 = true;
        } catch (Exception e) {
            System.out.println("Lỗi kết nối server");
            f.flag = false;
            f.flag2 = false;
            f.flag3 = false;
            e.printStackTrace();
        }
    }

    public void sendStudent(Student s) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(s);//gui student sang ben server
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            mySocket.close();
        } catch (Exception e) {
        }
    }

    public String getResult() {
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String) ois.readObject(); // nhan ve thong diep
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public void sign(String sign) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(sign);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendCSDL(String server, String cong, String user, String pass)  {
        try {
            DataInputStream dis = new DataInputStream(mySocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(mySocket.getOutputStream());
            dos.writeUTF(server);
            dos.writeUTF(cong);
            dos.writeUTF(user);
            dos.writeUTF(pass);
        } catch (Exception e) {
            f.flag2 = false;
            System.out.println("Lỗi nhận thông tin csdl");
            e.printStackTrace();
        }      
            }
    public ArrayList<Student>  getStudent() throws IOException, ClassNotFoundException{
            ArrayList<Student> list = new ArrayList<>();
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            list = (ArrayList<Student>) ois.readObject();
            return list;            
        }
}
