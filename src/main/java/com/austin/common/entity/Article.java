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
 * 新闻资讯列表
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@TableName("busi_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 所属模块ID
     */
    private String moduleId;

    /**
     * 作者
     */
    private String author;

    /**
     * 内容
     */
    private String content;

    /**
     * 发表时间
     */
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    /**
     * 附件UUID（只能上传一个附件，多个附件请打包）
     */
    private String articleAttachmentId;

    /**
     * 逻辑删除（1为删除状态，0为未删除状态）
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getArticleAttachmentId() {
        return articleAttachmentId;
    }

    public void setArticleAttachmentId(String articleAttachmentId) {
        this.articleAttachmentId = articleAttachmentId;
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
        return "Article{" + "id=" + id + ", title=" + title + ", moduleId=" + moduleId + ", author=" + author + ", content=" + content + ", ctime=" + ctime + ", articleAttachmentId=" + articleAttachmentId + ", isDelete=" + isDelete + ", backup=" + backup + "}";
    }
}
