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
 *
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@TableName("busi_doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 医生性别
     */
    private String sex;

    /**
     * 医生照片(附件表)
     */
    private String avatarAttachmentId;

    /**
     * 科室ID
     */
    private String deptId;

    /**
     * 职称
     */
    private String competent;

    /**
     * 职务
     */
    private String title;

    /**
     * 专长
     */
    private String specialTalent;

    /**
     * 出诊时间
     */
    private String visitTime;

    /**
     * 联系方式(手机、办公室电话)
     */
    private String contact;

    /**
     * 简介
     */
    private String description;

    /**
     * 是否为专家（0：不是、1：是）
     */
    private Integer isSpecialist;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    /**
     * 逻辑删除标识符（）
     */
    private Integer isDelete;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatarAttachmentId() {
        return avatarAttachmentId;
    }

    public void setAvatarAttachmentId(String avatarAttachmentId) {
        this.avatarAttachmentId = avatarAttachmentId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCompetent() {
        return competent;
    }

    public void setCompetent(String competent) {
        this.competent = competent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
        this.specialTalent = specialTalent;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsSpecialist() {
        return isSpecialist;
    }

    public void setIsSpecialist(Integer isSpecialist) {
        this.isSpecialist = isSpecialist;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", avatarAttachmentId=" + avatarAttachmentId + ", deptId=" + deptId + ", competent=" + competent + ", title=" + title + ", specialTalent=" + specialTalent + ", visitTime=" + visitTime + ", contact=" + contact + ", description=" + description + ", isSpecialist=" + isSpecialist + ", ctime=" + ctime + ", isDelete=" + isDelete + "}";
    }
}
