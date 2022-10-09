/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycongviec;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author STD_DELL
 */
public class Plan implements Serializable{
    private String plan;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String place;
    private Boolean finish;

    public Plan() {
    }

    public Plan(String plan, LocalDateTime beginTime, LocalDateTime endTime,
            String place, Boolean finish) {
        this.plan = plan;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
        this.finish = finish;
    }
    
    public String getPlan() {
        return plan;
    }

    public LocalDateTime getBeginDate() {
        return beginTime;
    }

    public LocalDateTime getEndDate() {
        return endTime;
    }

    public String getPlace() {
        return place;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setBeginDate(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndDate(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }
       
    public boolean checkAfterTime(Plan plan){
        if(this.beginTime.isAfter(plan.endTime)) 
            return true;
        else
            return false;
    }
    
    public boolean checkBeforeTime(Plan plan){
        if(this.endTime.isBefore(plan.beginTime))
            return true;
        else
            return false;
    }
}
