package com.future.common.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class JmsFilterItem implements Serializable {
    private Long id;

    @ApiModelProperty(value = "筛选条件名称关联id")
    private Long fid;

    @ApiModelProperty(value = "筛选条件选项名称")
    private String name;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fid=").append(fid);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}