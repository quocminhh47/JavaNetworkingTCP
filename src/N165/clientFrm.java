package N165;

import java.awt.Component;
import java.awt.Container;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Admin
 */
public class clientFrm extends javax.swing.JFrame {

    DefaultTableModel dtm;
    Flag fl = new Flag();
    String host;
    int port;
    private ArrayList<Student> list;
    DES des = new DES();
    Socket client = null;

    public clientFrm() {

        initComponents();

    }

    public Socket connectServer(String host, int port) throws IOException {
        client = new Socket(host, port);
        return client;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn2 = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtAnh = new javax.swing.JTextField();
        txtVan = new javax.swing.JTextField();
        txtToan = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        btn3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSV = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("K???T N???I T???I SERVER");

        panel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Server Host:");

        jLabel2.setText("Port: ");

        txtPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPortKeyReleased(evt);
            }
        });

        btn1.setText("Connect");
        btn1.setEnabled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn1)
                    .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtPort))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("T??n Server:");

        jLabel5.setText("C???ng :");

        jLabel6.setText("User:");

        jLabel7.setText("Pass:");

        btn2.setText("SEND");
        btn2.setEnabled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        btn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn2KeyReleased(evt);
            }
        });

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtServer, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtUser)
                    .addComponent(txtCong)
                    .addComponent(txtPass))
                .addGap(18, 18, 18)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("K???T N???I T???I CSDL");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("NH???P LI???U ??I???M SINH VI??N:");

        jLabel10.setText("M?? SV");

        jLabel11.setText("H??? T??N");

        jLabel12.setText("TO??N");

        jLabel13.setText("V??N");

        jLabel14.setText("ANH");

        txtAnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnhKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnhKeyReleased(evt);
            }
        });

        btn3.setText("SAVE");
        btn3.setEnabled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHoTen)
                                        .addComponent(txtToan)
                                        .addComponent(txtVan)
                                        .addComponent(txtAnh))))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btn3))
        );

        tableSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? SV", "H??? T??n", "To??n", "V??n", "Anh", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tableSV);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("DANH S??CH SINH VI??N");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        host = txtHost.getText().replaceAll(" ", "");
        port = Integer.parseInt(txtPort.getText().replaceAll(" ", ""));
        //Socket client = null;
        System.out.println(host + "  " + port);
        ClientCtr ctr = new ClientCtr();
        ctr.openSocket(host, port);

        if (!fl.flag == false) {
            ctr.sign("1");
            JOptionPane.showMessageDialog(rootPane, "K???T N???I TH??NH C??NG");
            ctr.closeConnection();
        } else {
            JOptionPane.showMessageDialog(rootPane, "L???I,TH??? L???I!");
        }


    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        if (fl.flag == true) {
            System.out.println("???? v??o form 2");
            System.out.println("host: " + host + "port " + port);
            String server = txtServer.getText();
            String cong = txtCong.getText();
            String user = txtUser.getText();
            String pass = txtPass.getText();
            ClientCtr ctr = new ClientCtr();
            ctr.openSocket(host, port);

            if (!fl.flag2 == false) {
                ctr.sign("2");
//                    DataInputStream dis = new DataInputStream(client.getInputStream());
//                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//                    //  gui len server:
//                    dos.writeUTF(server);
//                    dos.writeUTF(cong);
//                    dos.writeUTF(user);
//                    dos.writeUTF(pass);
                ctr.sendCSDL(server, cong, user, pass);
                String res = ctr.getResult();
                 if (res.equals("ok")) {
                    JOptionPane.showMessageDialog(rootPane, "K???T N???I CSDL TH??NH C??NG");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "K???T N???I CSDL TH???T B???I!");
                }

                System.out.println("Flag csdl: " + fl.flagCSDL);
                System.out.println("flag2: " + fl.flag2);
                // nhan list student tu server
            }
            ctr.closeConnection();
//finally {
//                System.out.println("Flag 2: " + fl.flag2);
//                System.out.println("Client: " + client);
//                if (fl.flag2 == true) {
//                    btn2.setEnabled(true);
//                }
//
//            }

        }

    }//GEN-LAST:event_btn2ActionPerformed

    private void btn2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn2KeyReleased
        // TODO add your handling code here:
        if (fl.flag == true) {
            btn2.setEnabled(true);
        }

    }//GEN-LAST:event_btn2KeyReleased

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
        // TODO add your handling code here:
        if (txtPass.getText().length() > 0)
            btn2.setEnabled(true);
    }//GEN-LAST:event_txtPassKeyReleased

    private void txtPortKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPortKeyReleased
        // TODO add your handling code here:
        btn1.setEnabled(true);
    }//GEN-LAST:event_txtPortKeyReleased

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        if(fl.flag2 == true){
            
      
        String maSV = txtMaSV.getText();
        String hoTen = txtHoTen.getText();
        float toan = Float.parseFloat(txtToan.getText());
        float van = Float.parseFloat(txtVan.getText());
        float anh = Float.parseFloat(txtAnh.getText());

        try {
            if (maSV.length() != 0 || hoTen.length() != 0 || txtToan.getText().length() != 0
                    || txtVan.getText().length() != 0 || txtAnh.getText().length() != 0 || toan>10 || toan <0
                    || van > 10 || van < 0 || anh >10 || anh < 0) {
                Student s = new Student();
                s.setMaSV(maSV);
                s.setHoTen(hoTen);
                s.setToan(String.valueOf(toan));
                s.setVan(String.valueOf(van));
                s.setAnh(String.valueOf(anh));
                s.setAvg(String.valueOf((toan + van + anh) / 3));
                ClientCtr ctr = new ClientCtr();
                ctr.openSocket(host, port);
                fl.flag3 = true;
                ctr.sign("3");
                ctr.sendStudent(s);
                String res = ctr.getResult();
                if (res.equals("ok")) {
                    JOptionPane.showMessageDialog(rootPane, "Success!");
                    // nhan list student tu server
                    list = ctr.getStudent();
                     
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Failed!");
                }
                ctr.closeConnection();
            } else {
                JOptionPane.showMessageDialog(rootPane, "KI???M TRA L???I TH??NG TIN");

            }

        } catch (Exception e) {
            e.printStackTrace();;
            JOptionPane.showMessageDialog(rootPane, "Failed!");
            fl.flag3 = false;
        } finally {

        }
        dtm = (DefaultTableModel) tableSV.getModel();
        dtm.setRowCount(0);
        dtm.setColumnIdentifiers(new Object[]{
            "M?? SV", "H??? t??n", "??i???m To??n", "??i???m V??n", "??i???m Anh", "AVG"
        });

        for (Student s : list) {
            try {
                dtm.addRow(new Object[]{
                    des.des_Decrypt(s.getMaSV()), des.des_Decrypt(s.getHoTen()), des.des_Decrypt(s.getToan()),
                    des.des_Decrypt(s.getVan()), des.des_Decrypt(s.getAnh()), des.des_Decrypt(s.getAvg())
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
          }
    }//GEN-LAST:event_btn3ActionPerformed

    private void txtAnhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnhKeyReleased
        // TODO add your handling code here:
         if (txtAnh.getText().length() > 0)
            btn3.setEnabled(true);
    }//GEN-LAST:event_txtAnhKeyReleased

    private void txtAnhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnhKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtAnhKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // disableComponents(panel2);
                new clientFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    public static javax.swing.JTable tableSV;
    private javax.swing.JTextField txtAnh;
    public javax.swing.JTextField txtCong;
    private javax.swing.JTextField txtHoTen;
    public javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtMaSV;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtPort;
    public javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtToan;
    public javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtVan;
    // End of variables declaration//GEN-END:variables
}
