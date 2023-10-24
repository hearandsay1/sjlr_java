package com.future.web.controller;

import com.future.common.api.CommonPage;
import com.future.common.api.CommonResult;
import com.future.web.dto.SmsAdvertiseVo;
import com.future.web.service.SmsAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "SmsHomeController")
@Tag(name = "SmsHomeController", description = "首页管理")
@RequestMapping("/home")
public class SmsHomeController
{

    @Autowired
    private SmsAdvertiseService advertiseService;

    @ApiOperation("分页获取广告列表")
    @RequestMapping(value = "/advertise/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsAdvertiseVo>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<SmsAdvertiseVo> advertiseVoList =  advertiseService.list(pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(advertiseVoList));
    }
}
