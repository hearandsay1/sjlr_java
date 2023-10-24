package com.future.common.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class JmsComment implements Serializable {
    private Long id;

    @ApiModelProperty(value = "父级id")
    private Long pid;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Long mid;

    @ApiModelProperty(value = "工作的id")
    private Long jid;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "启用或显示状态")
    private Boolean status;

    @ApiModelProperty(value = "用户头像（冗余作用）")
    private String menberAvatar;

    @ApiModelProperty(value = "用户昵称（冗余作用）")
    private String memberName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMenberAvatar() {
        return menberAvatar;
    }

    public void setMenberAvatar(String menberAvatar) {
        this.menberAvatar = menberAvatar;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", content=").append(content);
        sb.append(", mid=").append(mid);
        sb.append(", jid=").append(jid);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", menberAvatar=").append(menberAvatar);
        sb.append(", memberName=").append(memberName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}