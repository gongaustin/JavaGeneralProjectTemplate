package com.austin.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 模块管理
 * </p>
 *
 * @author AustinGJ
 * @since 2021-05-14
 */
@TableName("busi_module")
public class Module implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * UUID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 展示优先级
     */
    private Integer priority;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 描述
     */
    private String description;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 预留字段
     */
    private String backup;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    @Override
    public String toString() {
        return "Module{" +
        "id=" + id +
        ", moduleName=" + moduleName +
        ", priority=" + priority +
        ", level=" + level +
        ", description=" + description +
        ", parentId=" + parentId +
        ", backup=" + backup +
        "}";
    }
}
