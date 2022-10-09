/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycongviec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STD_DELL
 */
public class User implements Serializable{
    private String user;
    private String password;
    private String fullName;
    private List<Plan> listPlans = new ArrayList<>();
    private boolean checkAdmin;

    public User() {

    }

    public User(String user, String password, String fullName, List<Plan> listPlan, boolean checkAdmin) {
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.listPlans = listPlan;
        this.checkAdmin = checkAdmin;
    }

    public User(String user, String password, String fullName, boolean checkAdmin) {
        this.user = user;
        this.password = password;
        this.fullName = fullName;
        this.checkAdmin = checkAdmin;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isCheckAdmin() {
        return checkAdmin;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCheckAdmin(boolean checkAdmin) {
        this.checkAdmin = checkAdmin;
    }

    public List<Plan> getListPlans() {
        return listPlans;
    }

    public void setListPlans(List<Plan> listPlans) {
        this.listPlans = listPlans;
    }
    
    public boolean addPlan(Plan plan){
        if(listPlans.isEmpty()) {
            listPlans.add(plan);
            return true;
        }
        if(plan.checkBeforeTime(listPlans.get(0))){
            listPlans.add(0, plan);
            return true;
        }
        for(int i = 1; i < listPlans.size() ; i++){
            if(plan.checkAfterTime(listPlans.get(i-1))){
                if(plan.checkBeforeTime(listPlans.get(i))){
                    listPlans.add(i, plan);
                    return true;
                }
            }            
        }
        if(plan.checkAfterTime(listPlans.get(listPlans.size()-1))){
            listPlans.add(plan);
            return true;
        }
        return false;
    }
    
    public void deletePlan(int i){
        listPlans.remove(i);
    }
}
