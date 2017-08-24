package com.hndx.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "pb_icanteen", schema = "knight", catalog = "")
public class PbIcanteenEntity {
    private int id;
    private Integer sysNo;
    private String employeeId;
    private String employeeName;
    private Integer departId;
    private String departName;
    private Integer operationType;
    private Integer mealType;
    private Integer walletType;
    private BigDecimal dealMoney;
    private BigDecimal balance;
    private Integer deviceSysId;
    private Timestamp dealDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sys_no", nullable = true)
    public Integer getSysNo() {
        return sysNo;
    }

    public void setSysNo(Integer sysNo) {
        this.sysNo = sysNo;
    }

    @Basic
    @Column(name = "employee_id", nullable = true, length = 20)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_name", nullable = true, length = 50)
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "depart_id", nullable = true)
    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    @Basic
    @Column(name = "depart_name", nullable = true, length = 50)
    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Basic
    @Column(name = "operation_type", nullable = true)
    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    @Basic
    @Column(name = "meal_type", nullable = true)
    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    @Basic
    @Column(name = "wallet_type", nullable = true)
    public Integer getWalletType() {
        return walletType;
    }

    public void setWalletType(Integer walletType) {
        this.walletType = walletType;
    }

    @Basic
    @Column(name = "deal_money", nullable = true, precision = 4)
    public BigDecimal getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(BigDecimal dealMoney) {
        this.dealMoney = dealMoney;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 4)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "device_sys_id", nullable = true)
    public Integer getDeviceSysId() {
        return deviceSysId;
    }

    public void setDeviceSysId(Integer deviceSysId) {
        this.deviceSysId = deviceSysId;
    }

    @Basic
    @Column(name = "deal_date", nullable = true)
    public Timestamp getDealDate() {
        return dealDate;
    }

    public void setDealDate(Timestamp dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PbIcanteenEntity that = (PbIcanteenEntity) o;

        if (id != that.id) return false;
        if (sysNo != null ? !sysNo.equals(that.sysNo) : that.sysNo != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (departId != null ? !departId.equals(that.departId) : that.departId != null) return false;
        if (departName != null ? !departName.equals(that.departName) : that.departName != null) return false;
        if (operationType != null ? !operationType.equals(that.operationType) : that.operationType != null)
            return false;
        if (mealType != null ? !mealType.equals(that.mealType) : that.mealType != null) return false;
        if (walletType != null ? !walletType.equals(that.walletType) : that.walletType != null) return false;
        if (dealMoney != null ? !dealMoney.equals(that.dealMoney) : that.dealMoney != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (deviceSysId != null ? !deviceSysId.equals(that.deviceSysId) : that.deviceSysId != null) return false;
        if (dealDate != null ? !dealDate.equals(that.dealDate) : that.dealDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sysNo != null ? sysNo.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (departId != null ? departId.hashCode() : 0);
        result = 31 * result + (departName != null ? departName.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (mealType != null ? mealType.hashCode() : 0);
        result = 31 * result + (walletType != null ? walletType.hashCode() : 0);
        result = 31 * result + (dealMoney != null ? dealMoney.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (deviceSysId != null ? deviceSysId.hashCode() : 0);
        result = 31 * result + (dealDate != null ? dealDate.hashCode() : 0);
        return result;
    }
}
