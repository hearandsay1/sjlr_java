package com.future.web.controller;


import com.future.common.api.CommonPage;
import com.future.common.api.CommonResult;
import com.future.common.model.JmsRecord;
import com.future.common.model.UmsMember;
import com.future.web.service.JmsJobService;
import com.future.web.service.JmsRecordService;
import com.future.web.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController")
@Tag(name = "UmsMemberController", description = "会员管理")
@RequestMapping("/member")
public class UmsMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private JmsRecordService recordService;

    @Autowired
    private JmsJobService jobService;

    @ApiOperation("会员注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam(required = false) String telephone,
                                 @RequestParam(required = false) String authCode) {
        memberService.register(username, password, telephone, authCode);
        return CommonResult.success(null,"注册成功");
    }

    @ApiOperation("会员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取会员信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode,"获取验证码成功");
    }


    @ApiOperation("会员修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        memberService.updatePassword(telephone,password,authCode);
        return CommonResult.success(null,"密码修改成功");
    }


    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取报名记录列表")
    @RequestMapping(value = "/record/list/{status}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<JmsRecord>> recordList(Principal principal, @PathVariable(required = false) Integer status,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum){
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        List<JmsRecord> records = recordService.recordList(status,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(records),"成功获取报名记录列表");
    }

    @ApiOperation(value = "报名")
    @RequestMapping(value = "/job/signup/{jid}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult signup(Principal principal, @PathVariable Long jid){
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        int count = recordService.signup(jid);
        if(count>0){
            return CommonResult.success("报名成功");
        }else{
            return CommonResult.failed("报名失败");
        }

    }

    @ApiOperation(value = "点赞")
    @RequestMapping(value = "/job/like/{jid}", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult like(@PathVariable Long jid){
        int count = jobService.like(jid);
        if(count>0){
            return CommonResult.success("点赞成功");
        }else{
            return CommonResult.failed("点赞失败");
        }
    }

    @ApiOperation(value = "收藏或取消收藏")
    @RequestMapping(value = "/job/collect/{jid}", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult collect(Principal principal, @PathVariable Long jid){
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        int count = jobService.collect(jid);
        if(count>0){
            return CommonResult.success("收藏或取消收藏成功");
        }else{
            return CommonResult.failed("收藏或取消收藏失败");
        }
    }


}
