package com.hndx.model;

import java.sql.Timestamp;
import java.util.List;

public class ResultDaily {

    //是否新增列表：学员列表、各餐次列表、各上课段列表
    private int clDDID;
    private Integer deptId;
    private String deptName;
    private Timestamp ctTime;
    private Integer peoCT;
    private double ctBFast;
    private double ctLunch;
    private double ctDinner;
    private double ctMorning;
    private double ctAfternoon;
    private Double ctNight;
    private List peoInDpt;
    private List peoBFast;
    private List peoLunch;
    private List peoDinner;
    private List peoMorning;
    private List peoAfternoon;
    private List peoNight;
     //考勤结果为0，则定为“当日不考勤”
     public  ResultDaily (Integer deptId) {
          this.deptId = deptId;
          //this.ctTime = ctTime;
          //读取数据库，生成相关统计记录
         //人员总数、人员列表、早中晚餐人数、上下午人数（注意打卡时间认定）

     }

    public void setClDDID(int clDDID) {
        this.clDDID = clDDID;
    }
    public int getClDDID() {
        return clDDID;
    }

    public Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getPeoCT() {
        return peoCT;
    }
    public void setPeoCT(Integer peoCT) {
        this.peoCT = peoCT;
    }

    public Timestamp getCtTime() {
        return ctTime;
    }
    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }

    public double getCtBFast() {
        return ctBFast;
    }
    public void setCtBFast(double ctBFast) {
        this.ctBFast = ctBFast;
    }

    public double getCtLunch() {
        return ctLunch;
    }
    public void setCtLunch(double ctLunch) {
        this.ctLunch = ctLunch;
    }

    public double getCtDinner() {
        return ctDinner;
    }
    public void setCtDinner(double ctDinner) {
        this.ctDinner = ctDinner;
    }

    public List getPeoDinner() {
        return peoDinner;
    }
    public void setPeoDinner(List peoDinner) {
        this.peoDinner = peoDinner;
    }

    public List getPeoMorning() {
        return peoMorning;
    }
    public void setPeoMorning(List peoMorning) {
        this.peoMorning = peoMorning;
    }

    public void setPeoAfternoon(List peoAfternoon) {
        this.peoAfternoon = peoAfternoon;
    }
    public List getPeoAfternoon() {
        return peoAfternoon;
    }

    public List getPeoLunch() {
        return peoLunch;
    }
    public void setPeoLunch(List peoLunch) {
        this.peoLunch = peoLunch;
    }

    public List getPeoBFast() {
        return peoBFast;
    }
    public void setPeoBFast(List peoBFast) {
        this.peoBFast = peoBFast;
    }

    public List getPeoInDpt() {
        return peoInDpt;
    }
    public void setPeoInDpt(List peoInDpt) {
        this.peoInDpt = peoInDpt;
    }



    public double getCtMorning() {
        return ctMorning;
    }
    public void setCtMorning(double ctMorning) {
        this.ctMorning = ctMorning;
    }

    public double getCtAfternoon() {
        return ctAfternoon;
    }
    public void setCtAfternoon(double ctAfternoon) {
        this.ctAfternoon = ctAfternoon;
    }

    public void setCtNight(Double ctNight) {
        this.ctNight = ctNight;
    }

    public Double getCtNight() {
        return ctNight;
    }

    public void setPeoNight(List peoNight) {
        this.peoNight = peoNight;
    }

    public List getPeoNight() {
        return peoNight;
    }
}
