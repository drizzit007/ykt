package com.hndx.model;

import javax.persistence.*;

@Entity
@Table(name = "pb_emply", schema = "knight", catalog = "")
public class PbEmplyEntity {
    private int sysNo;
    private int departId;
    private String employeeId;
    private String employeeName;
    private Integer isDelete;
    private String phone;

    @Id
    @Column(name = "sys_no", nullable = false)
    public int getSysNo() {
        return sysNo;
    }

    public void setSysNo(int sysNo) {
        this.sysNo = sysNo;
    }

    @Basic
    @Column(name = "depart_id", nullable = false)
    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    @Basic
    @Column(name = "employee_id", nullable = false, length = 18)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_name", nullable = false, length = 40)
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "is_delete", nullable = false)
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PbEmplyEntity that = (PbEmplyEntity) o;

        if (sysNo != that.sysNo) return false;
        if (departId != that.departId) return false;
        if (isDelete != that.isDelete) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sysNo;
        result = 31 * result + departId;
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (int) isDelete;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
