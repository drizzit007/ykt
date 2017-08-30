package com.hndx.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dx_record", schema = "knight", catalog = "")
public class DxRecordEntity {
    private int clDdid;
    private Integer deptId;
    private String deptName;
    private Timestamp ctTime;
    private Integer peoCt;
    private Double ctBFast;
    private Double ctLunch;
    private Double ctDinner;
    private Double ctMorning;
    private Double ctAfternoon;
    private Double ctNight;
    private String peoInDpt;
    private String peoBFast;
    private String peoLunch;
    private String peoDinner;
    private String peoMorning;
    private String peoAfternoon;
    private String peoNight;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "clDDID", nullable = false)
    public int getClDdid() {
        return clDdid;
    }

    public void setClDdid(int clDdid) {
        this.clDdid = clDdid;
    }

    @Basic
    @Column(name = "deptId", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "deptName", nullable = true, length = 255)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "ctTime", nullable = true)
    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }

    @Basic
    @Column(name = "peoCT", nullable = true)
    public Integer getPeoCt() {
        return peoCt;
    }

    public void setPeoCt(Integer peoCt) {
        this.peoCt = peoCt;
    }

    @Basic
    @Column(name = "ctBFast", nullable = true, precision = 0)
    public Double getCtBFast() {
        return ctBFast;
    }

    public void setCtBFast(Double ctBFast) {
        this.ctBFast = ctBFast;
    }

    @Basic
    @Column(name = "ctLunch", nullable = true, precision = 0)
    public Double getCtLunch() {
        return ctLunch;
    }

    public void setCtLunch(Double ctLunch) {
        this.ctLunch = ctLunch;
    }

    @Basic
    @Column(name = "ctDinner", nullable = true, precision = 0)
    public Double getCtDinner() {
        return ctDinner;
    }

    public void setCtDinner(Double ctDinner) {
        this.ctDinner = ctDinner;
    }

    @Basic
    @Column(name = "ctMorning", nullable = true, precision = 0)
    public Double getCtMorning() {
        return ctMorning;
    }

    public void setCtMorning(Double ctMorning) {
        this.ctMorning = ctMorning;
    }

    @Basic
    @Column(name = "ctAfternoon", nullable = true, precision = 0)
    public Double getCtAfternoon() {
        return ctAfternoon;
    }

    public void setCtAfternoon(Double ctAfternoon) {
        this.ctAfternoon = ctAfternoon;
    }

    @Basic
    @Column(name = "ctNight", nullable = true, precision = 0)
    public Double getCtNight (){
        return ctNight;
    }

    public void setCtNight(Double ctNight) {
        this.ctNight = ctNight;
    }

    @Basic
    @Column(name = "peoInDpt", nullable = true, length = 255)
    public String getPeoInDpt() {
        return peoInDpt;
    }

    public void setPeoInDpt(String peoInDpt) {
        this.peoInDpt = peoInDpt;
    }

    @Basic
    @Column(name = "peoBFast", nullable = true, length = 255)
    public String getPeoBFast() {
        return peoBFast;
    }

    public void setPeoBFast(String peoBFast) {
        this.peoBFast = peoBFast;
    }

    @Basic
    @Column(name = "peoLunch", nullable = true, length = 255)
    public String getPeoLunch() {
        return peoLunch;
    }

    public void setPeoLunch(String peoLunch) {
        this.peoLunch = peoLunch;
    }

    @Basic
    @Column(name = "peoDinner", nullable = true, length = 255)
    public String getPeoDinner() {
        return peoDinner;
    }

    public void setPeoDinner(String peoDinner) {
        this.peoDinner = peoDinner;
    }

    @Basic
    @Column(name = "peoMorning", nullable = true, length = 255)
    public String getPeoMorning() {
        return peoMorning;
    }

    public void setPeoMorning(String peoMorning) {
        this.peoMorning = peoMorning;
    }

    @Basic
    @Column(name = "peoAfternoon", nullable = true, length = 255)
    public String getPeoAfternoon() {
        return peoAfternoon;
    }

    public void setPeoAfternoon(String peoAfternoon) {
        this.peoAfternoon = peoAfternoon;
    }

    @Basic
    @Column(name = "peoNight", nullable = true, length = 255)
    public String getPeoNight() {
        return peoNight;
    }

    public void setPeoNight(String peoNight) {
        this.peoNight = peoNight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DxRecordEntity that = (DxRecordEntity) o;

        if (clDdid != that.clDdid) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (ctTime != null ? !ctTime.equals(that.ctTime) : that.ctTime != null) return false;
        if (peoCt != null ? !peoCt.equals(that.peoCt) : that.peoCt != null) return false;
        if (ctBFast != null ? !ctBFast.equals(that.ctBFast) : that.ctBFast != null) return false;
        if (ctLunch != null ? !ctLunch.equals(that.ctLunch) : that.ctLunch != null) return false;
        if (ctDinner != null ? !ctDinner.equals(that.ctDinner) : that.ctDinner != null) return false;
        if (ctMorning != null ? !ctMorning.equals(that.ctMorning) : that.ctMorning != null) return false;
        if (ctAfternoon != null ? !ctAfternoon.equals(that.ctAfternoon) : that.ctAfternoon != null) return false;
        if (peoInDpt != null ? !peoInDpt.equals(that.peoInDpt) : that.peoInDpt != null) return false;
        if (peoBFast != null ? !peoBFast.equals(that.peoBFast) : that.peoBFast != null) return false;
        if (peoLunch != null ? !peoLunch.equals(that.peoLunch) : that.peoLunch != null) return false;
        if (peoDinner != null ? !peoDinner.equals(that.peoDinner) : that.peoDinner != null) return false;
        if (peoMorning != null ? !peoMorning.equals(that.peoMorning) : that.peoMorning != null) return false;
        if (peoAfternoon != null ? !peoAfternoon.equals(that.peoAfternoon) : that.peoAfternoon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clDdid;
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (ctTime != null ? ctTime.hashCode() : 0);
        result = 31 * result + (peoCt != null ? peoCt.hashCode() : 0);
        result = 31 * result + (ctBFast != null ? ctBFast.hashCode() : 0);
        result = 31 * result + (ctLunch != null ? ctLunch.hashCode() : 0);
        result = 31 * result + (ctDinner != null ? ctDinner.hashCode() : 0);
        result = 31 * result + (ctMorning != null ? ctMorning.hashCode() : 0);
        result = 31 * result + (ctAfternoon != null ? ctAfternoon.hashCode() : 0);
        result = 31 * result + (peoInDpt != null ? peoInDpt.hashCode() : 0);
        result = 31 * result + (peoBFast != null ? peoBFast.hashCode() : 0);
        result = 31 * result + (peoLunch != null ? peoLunch.hashCode() : 0);
        result = 31 * result + (peoDinner != null ? peoDinner.hashCode() : 0);
        result = 31 * result + (peoMorning != null ? peoMorning.hashCode() : 0);
        result = 31 * result + (peoAfternoon != null ? peoAfternoon.hashCode() : 0);
        return result;
    }
}
