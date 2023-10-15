package com.future.ms.controller;

import com.future.common.api.CommonPage;
import com.future.common.api.CommonResult;
import com.future.common.model.JmsJob;
import com.future.common.model.UmsMenu;
import com.future.ms.service.JmsJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "JmsJobController")
@Tag(name = "JmsJobController", description = "工作后台管理")
@RequestMapping("/job")
public class JmsJobController {

    @Autowired
    private JmsJobService jobService;

    @ApiOperation("根据工作名称分页获取工作列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<JmsJob>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<JmsJob> jobList = jobService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(jobList));
    }

    @ApiOperation("添加工作信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody JmsJob jmsJob) {
        int count = jobService.create(jmsJob);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取工作详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<JmsJob> getItem(@PathVariable Long id) {
        JmsJob jmsJob= jobService.getItem(id);
        return CommonResult.success(jmsJob);
    }
}
