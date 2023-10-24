package com.future.common.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class JmsRecord implements Serializable {
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long mid;

    @ApiModelProperty(value = "工作id")
    private Long jid;

    @ApiModelProperty(value = "0->已报名(未查看)1->已报名(已查看)2->已录用(待工作)3->已到岗(待结算)4->已结算(完成)5->已取消")
    private Integer status;

    private Date createTime;

    @ApiModelProperty(value = "工作标题(冗余)")
    private String title;

    @ApiModelProperty(value = "地区(冗余)")
    private String area;

    @ApiModelProperty(value = "薪水(冗余)")
    private String salary;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getJid() {
        return jid;
    }

    public void setJid(Long jid) {
        this.jid = jid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mid=").append(mid);
        sb.append(", jid=").append(jid);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", area=").append(area);
        sb.append(", salary=").append(salary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}