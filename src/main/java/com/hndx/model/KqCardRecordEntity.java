package com.hndx.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "kq_card_record", schema = "knight", catalog = "")
public class KqCardRecordEntity {
    private int recordId;
    private Integer sysNo;
    private String employeeId;
    private Timestamp cardTime;
    private Integer deviceSysId;
    private Integer doorId;
    private String empName;
    private String deptName;
    private String operatorName;
    private Timestamp updateTime;
    private Integer deptId;

    @Id
    @Column(name = "record_id", nullable = false)
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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
    @Column(name = "card_time", nullable = true)
    public Timestamp getCardTime() {
        return cardTime;
    }

    public void setCardTime(Timestamp cardTime) {
        this.cardTime = cardTime;
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
    @Column(name = "door_id", nullable = true)
    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    @Basic
    @Column(name = "emp_name", nullable = true, length = 40)
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "dept_name", nullable = true, length = 40)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "operator_name", nullable = true, length = 40)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "dept_id", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KqCardRecordEntity that = (KqCardRecordEntity) o;

        if (recordId != that.recordId) return false;
        if (sysNo != null ? !sysNo.equals(that.sysNo) : that.sysNo != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (cardTime != null ? !cardTime.equals(that.cardTime) : that.cardTime != null) return false;
        if (deviceSysId != null ? !deviceSysId.equals(that.deviceSysId) : that.deviceSysId != null) return false;
        if (doorId != null ? !doorId.equals(that.doorId) : that.doorId != null) return false;
        if (empName != null ? !empName.equals(that.empName) : that.empName != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId;
        result = 31 * result + (sysNo != null ? sysNo.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (cardTime != null ? cardTime.hashCode() : 0);
        result = 31 * result + (deviceSysId != null ? deviceSysId.hashCode() : 0);
        result = 31 * result + (doorId != null ? doorId.hashCode() : 0);
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        return result;
    }
}
