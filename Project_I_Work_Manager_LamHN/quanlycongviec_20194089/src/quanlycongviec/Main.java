/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlycongviec;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STD_DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ListUsers listUsers = new ListUsers();
    
    
    public static void save(){
        try {
            FileOutputStream fos = new FileOutputStream("listusers.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listUsers);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            File file = new File("listusers.dat");
            if(!file.exists()){
                boolean newFile = file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listUsers = (ListUsers) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(listUsers.getListUsers().isEmpty()) {
            List<Plan> list = new ArrayList<>();
            User userad = new User("admin", "pass", "admin", list, true);
            listUsers.addUser(userad);
            save();
        }

        LoginJFrame test = new LoginJFrame(listUsers);
        test.setVisible(true);
        save();
        
    }
}
