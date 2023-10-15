package com.future.ms.controller;

import com.future.common.api.CommonPage;
import com.future.common.api.CommonResult;
import com.future.common.model.JmsFilter;
import com.future.common.model.JmsJob;
import com.future.common.model.UmsAdmin;
import com.future.ms.dto.JmsFilterParam;
import com.future.ms.dto.UmsAdminParam;
import com.future.ms.service.JmsFilterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "JmsFilterController")
@Tag(name = "JmsFilterController", description = "筛选条件后台管理")
@RequestMapping("/filter")
public class JmsFilterController {

    @Autowired
    private JmsFilterService filterService;

    @ApiOperation("根据名称分页获取筛选条件列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<JmsFilter>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<JmsFilter> filterList = filterService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(filterList));
    }

    @ApiOperation(value = "添加筛选条件")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody JmsFilterParam jmsFilterParam) {
        int count = filterService.create(jmsFilterParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取工作详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<JmsFilterParam> getItem(@PathVariable Long id) {
        JmsFilterParam filter= filterService.getItem(id);
        return CommonResult.success(filter);
    }
}
