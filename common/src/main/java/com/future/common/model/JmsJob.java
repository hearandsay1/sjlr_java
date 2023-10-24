package com.future.common.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class JmsJob implements Serializable {
    private Long id;

    @ApiModelProperty(value = "工作的标题")
    private String title;

    @ApiModelProperty(value = "工作的标签：json格式保存")
    private String tag;

    @ApiModelProperty(value = "雇佣的企业名称")
    private String company;

    @ApiModelProperty(value = "工作的区域")
    private String area;

    @ApiModelProperty(value = "工作的详细地点")
    private String addr;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "发布时间")
    private Date pubTime;

    @ApiModelProperty(value = "工作发布状态：0->未发布；1->发布中;2->已结束")
    private Integer status;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;

    @ApiModelProperty(value = "评论数")
    private Integer commentNum;

    @ApiModelProperty(value = "收藏数")
    private Integer collectNum;

    @ApiModelProperty(value = "薪水数值")
    private BigDecimal salary;

    @ApiModelProperty(value = "薪水时间单位：0->每小时，1->每天，2->每周，3->每月，4->每年")
    private Integer salaryUnit;

    @ApiModelProperty(value = "软删除：0->未删除，1->已删除")
    private Integer del;

    @ApiModelProperty(value = "工作日期")
    private String workDate;

    @ApiModelProperty(value = "职位详情")
    private String detail;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getSalaryUnit() {
        return salaryUnit;
    }

    public void setSalaryUnit(Integer salaryUnit) {
        this.salaryUnit = salaryUnit;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", tag=").append(tag);
        sb.append(", company=").append(company);
        sb.append(", area=").append(area);
        sb.append(", addr=").append(addr);
        sb.append(", createTime=").append(createTime);
        sb.append(", pubTime=").append(pubTime);
        sb.append(", status=").append(status);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", collectNum=").append(collectNum);
        sb.append(", salary=").append(salary);
        sb.append(", salaryUnit=").append(salaryUnit);
        sb.append(", del=").append(del);
        sb.append(", workDate=").append(workDate);
        sb.append(", detail=").append(detail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}