package com.future.web.dto;

import com.future.common.model.JmsFilter;
import com.future.common.model.JmsFilterItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class JmsJobFilterVo extends JmsFilter {
    private List<JmsFilterItem> filterItems;

}
