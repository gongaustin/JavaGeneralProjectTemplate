package com.austin.common.entity;

import com.austin.common.core.constant.TimeConstant;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 科室
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@TableName("upms_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 科室编号
     */
    private String deptNo;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 科室负责人ID
     */
    private String leaderDoctorId;

    /**
     * 科室描述
     */
    private String description;

    /**
     * 联系电话
     */
    private String contact;

    /**
     * 科室位置
     */
    private String addr;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    /**
     * 科室照片(附件ID)
     */
    private String photoAttachmentId;

    /**
     * 科室类型（临床/五大中心/医技科etc）
     */
    private Integer type;

    /**
     * 是否重点科室（0：不是；1：是）
     */
    private Integer isImportant;

    /**
     * 逻辑删除标识符
     */
    private Integer isDelete;

    /**
     * 备用字段
     */
    private String backup;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLeaderDoctorId() {
        return leaderDoctorId;
    }

    public void setLeaderDoctorId(String leaderDoctorId) {
        this.leaderDoctorId = leaderDoctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getPhotoAttachmentId() {
        return photoAttachmentId;
    }

    public void setPhotoAttachmentId(String photoAttachmentId) {
        this.photoAttachmentId = photoAttachmentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Integer isImportant) {
        this.isImportant = isImportant;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    @Override
    public String toString() {
        return "Dept{" + "id=" + id + ", deptNo=" + deptNo + ", deptName=" + deptName + ", leaderDoctorId=" + leaderDoctorId + ", description=" + description + ", contact=" + contact + ", addr=" + addr + ", ctime=" + ctime + ", photoAttachmentId=" + photoAttachmentId + ", type=" + type + ", isImportant=" + isImportant + ", isDelete=" + isDelete + ", backup=" + backup + "}";
    }
}
