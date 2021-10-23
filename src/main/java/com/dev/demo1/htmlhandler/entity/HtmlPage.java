package com.dev.demo1.htmlhandler.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * html_page
 * @author 
 */
@Data
public class HtmlPage implements Serializable {
    private Integer id;

    private Integer organizationId;

    private Integer userId;

    private Integer documentNo;

    private Integer pageNo;

    private Integer order;

    private String title;

    private String html;

    private String htmlNoTag;

    private Integer stakeHolderId;

    private Integer yesr;

    private Boolean active;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Date deleteTime;

    private String deleteBy;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HtmlPage other = (HtmlPage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrganizationId() == null ? other.getOrganizationId() == null : this.getOrganizationId().equals(other.getOrganizationId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDocumentNo() == null ? other.getDocumentNo() == null : this.getDocumentNo().equals(other.getDocumentNo()))
            && (this.getPageNo() == null ? other.getPageNo() == null : this.getPageNo().equals(other.getPageNo()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getHtml() == null ? other.getHtml() == null : this.getHtml().equals(other.getHtml()))
            && (this.getHtmlNoTag() == null ? other.getHtmlNoTag() == null : this.getHtmlNoTag().equals(other.getHtmlNoTag()))
            && (this.getStakeHolderId() == null ? other.getStakeHolderId() == null : this.getStakeHolderId().equals(other.getStakeHolderId()))
            && (this.getYesr() == null ? other.getYesr() == null : this.getYesr().equals(other.getYesr()))
            && (this.getActive() == null ? other.getActive() == null : this.getActive().equals(other.getActive()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getDeleteBy() == null ? other.getDeleteBy() == null : this.getDeleteBy().equals(other.getDeleteBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrganizationId() == null) ? 0 : getOrganizationId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDocumentNo() == null) ? 0 : getDocumentNo().hashCode());
        result = prime * result + ((getPageNo() == null) ? 0 : getPageNo().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getHtml() == null) ? 0 : getHtml().hashCode());
        result = prime * result + ((getHtmlNoTag() == null) ? 0 : getHtmlNoTag().hashCode());
        result = prime * result + ((getStakeHolderId() == null) ? 0 : getStakeHolderId().hashCode());
        result = prime * result + ((getYesr() == null) ? 0 : getYesr().hashCode());
        result = prime * result + ((getActive() == null) ? 0 : getActive().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getDeleteBy() == null) ? 0 : getDeleteBy().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", userId=").append(userId);
        sb.append(", documentNo=").append(documentNo);
        sb.append(", pageNo=").append(pageNo);
        sb.append(", order=").append(order);
        sb.append(", title=").append(title);
        sb.append(", html=").append(html);
        sb.append(", htmlNoTag=").append(htmlNoTag);
        sb.append(", stakeHolderId=").append(stakeHolderId);
        sb.append(", yesr=").append(yesr);
        sb.append(", active=").append(active);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteBy=").append(deleteBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}