/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycongviec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author STD_DELL
 */
public class ListUsers implements Serializable{
    private List<User> listUsers = new ArrayList<>();

    public ListUsers() {
    }

    public ListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
    
    public boolean addUser(User user){
        String username = user.getUser();
        System.out.println(username);
        if(listUsers.isEmpty()){
            listUsers.add(user);
            return true;
        }
        
        if(username.compareTo(listUsers.get(0).getUser()) < 0){
            listUsers.add(0, user);
            return true;
        }
        
        if(username.compareTo(listUsers.get(listUsers.size()-1).getUser()) > 0){
            listUsers.add(user);
            return true;
        }
        
        int l = 0;                          
        int r = listUsers.size() - 2;  
        
        while(l <= r){
            int mid = l + (r - l)/2;        //Tranh tran so
            if(username.equals(listUsers.get(mid).getUser())){
                return false;
            }
            if(username.compareTo(listUsers.get(mid).getUser()) > 0 
                    && username.compareTo(listUsers.get(mid+1).getUser()) < 0){
                listUsers.add(mid + 1, user);
                return true;
            }
            if(username.compareTo(listUsers.get(mid).getUser()) > 0 ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return false;    
    }
    
    public void deleteUser(int i){
        listUsers.remove(i);
    }
    
    public User loginUser(String user, String password){
        if(listUsers == null){
            JOptionPane.showMessageDialog(null, 
                    "Hệ thống chưa có tài khoản nào !");
            return null;
        }
        
        int l = 0;
        int r = listUsers.size()-1;
        
        while(l <= r){
            int mid = l + (r - l)/2;        //Tranh tran so
            if(user.equals(listUsers.get(mid).getUser())){
                if(password.equals(listUsers.get(mid).getPassword())){
                    return listUsers.get(mid);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu !");
                    return null;
                }
            }
            if(user.compareTo(listUsers.get(mid).getUser()) > 0 ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        JOptionPane.showMessageDialog(null, "Không tồn tại tài khoản này !");
        return null;
    }
}
