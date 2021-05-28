package com.austin.common.entity.vo;

import com.austin.common.entity.Doctor;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 15:24 2021/5/26
 */
public class DoctorVo extends Doctor {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
