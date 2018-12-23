package com.test.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
    public Date planDate;
    public String detail;
    public String people = "";

    public static Date getDatefromString(String date){
        Date dt = null;
        try{
            dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return dt;
    }

    public PlanItem(String date, String detail){
        this.planDate = getDatefromString(date);
        this.detail = detail;
    }

    public Date getPlanDate(){
        return planDate;
    }

    public void addPeople(String name){
        people += name + ", ";
    }

}
