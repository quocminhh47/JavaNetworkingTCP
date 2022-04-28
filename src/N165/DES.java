/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package N165;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DES {

    public String des(String original) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String SECRET_KEY = "12345678";
        SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] byteEncrypted = cipher.doFinal(original.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);

//        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//        byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
//        String decrypted = new String(byteDecrypted);
        //System.out.println("original  text: " + original);
        //System.out.println("encrypted text: " + encrypted);
        //System.out.println("decrypted text: " + decrypted);
        return encrypted;
    }

    public String des_Decrypt(String encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
       // String encryptText = textAreaEncrypted.getText();
        String key = "12345678";
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        //textAreaDycrypted.setText(new String(decrypted));
        //System.out.println(new String(decrypted));
        return (new String(decrypted));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        new DES().des_Decrypt("1yAlKUyABXA=");
    }
}
