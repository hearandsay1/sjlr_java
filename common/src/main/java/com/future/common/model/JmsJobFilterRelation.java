package com.future.common.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class JmsJobFilterRelation implements Serializable {
    private Long id;

    private Long jid;

    @ApiModelProperty(value = "0->单选，1->多选，2->手动输入")
    private Integer type;

    private Long fid;

    private String vals;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJid() {
        return jid;
    }

    public void setJid(Long jid) {
        this.jid = jid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getVals() {
        return vals;
    }

    public void setVals(String vals) {
        this.vals = vals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jid=").append(jid);
        sb.append(", type=").append(type);
        sb.append(", fid=").append(fid);
        sb.append(", vals=").append(vals);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}