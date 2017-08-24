package com.hndx.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pb_balance", schema = "knight", catalog = "")
public class PbBalanceEntity {
    private int sysNo;
    private BigDecimal bigBag;
    private BigDecimal littleBag;
    private BigDecimal subsidy;
    private Integer workMeal;

    @Id
    @Column(name = "sys_no", nullable = false)
    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    @Basic
    @Column(name = "big_bag", nullable = true, precision = 4)
    public BigDecimal getBigBag() {
        return bigBag;
    }

    public void setBigBag(BigDecimal bigBag) {
        this.bigBag = bigBag;
    }

    @Basic
    @Column(name = "little_bag", nullable = true, precision = 4)
    public BigDecimal getLittleBag() {
        return littleBag;
    }

    public void setLittleBag(BigDecimal littleBag) {
        this.littleBag = littleBag;
    }

    @Basic
    @Column(name = "subsidy", nullable = true, precision = 4)
    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    @Basic
    @Column(name = "work_meal", nullable = true)
    public Integer getWorkMeal() {
        return workMeal;
    }

    public void setWorkMeal(Integer workMeal) {
        this.workMeal = workMeal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PbBalanceEntity that = (PbBalanceEntity) o;

        if (sysNo != that.sysNo) return false;
        if (bigBag != null ? !bigBag.equals(that.bigBag) : that.bigBag != null) return false;
        if (littleBag != null ? !littleBag.equals(that.littleBag) : that.littleBag != null) return false;
        if (subsidy != null ? !subsidy.equals(that.subsidy) : that.subsidy != null) return false;
        if (workMeal != null ? !workMeal.equals(that.workMeal) : that.workMeal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sysNo;
        result = 31 * result + (bigBag != null ? bigBag.hashCode() : 0);
        result = 31 * result + (littleBag != null ? littleBag.hashCode() : 0);
        result = 31 * result + (subsidy != null ? subsidy.hashCode() : 0);
        result = 31 * result + (workMeal != null ? workMeal.hashCode() : 0);
        return result;
    }
}
