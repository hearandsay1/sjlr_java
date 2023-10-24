package com.future.ms.dto;

import com.future.common.model.JmsFilterItem;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
public class JmsJobFilterVo {

    private Long id;

    private String name;

    private Integer type;

    private Boolean checked=false;

    private List<JmsFilterItem> values;
}
