package com.future.web.controller;

import com.future.common.api.CommonPage;
import com.future.common.api.CommonResult;
import com.future.common.model.JmsFilter;
import com.future.common.model.JmsJob;
import com.future.web.dto.*;
import com.future.web.service.JmsCommentService;
import com.future.web.service.JmsJobFilterService;
import com.future.web.service.JmsJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@Api(tags = "JmsJobController")
@Tag(name = "JmsJobController", description = "工作管理")
@RequestMapping("/job")
public class JmsJobController {

    @Autowired
    private JmsJobService jobService;

    @Autowired
    private JmsCommentService commentService;

    @Autowired
    private JmsJobFilterService jobFilterService;


    @ApiOperation("获取工作列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<JmsJobItemVo>> list(@RequestBody(required = false) JmsJobListConditionParams conditionParams,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<JmsJobItemVo> jobVoList = jobService.list(conditionParams,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(jobVoList),"获取工作列表成功");
    }

    @ApiOperation("获取工作详细信息")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<JmsJob> detail(@PathVariable Long id) {
        JmsJob job = jobService.detail(id);
        return CommonResult.success(job,"获取工作详情成功");
    }

    @ApiOperation("进行评论")
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult comment(@RequestBody JmsCommentParam commentParam, Principal principal){
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        int count = commentService.comment(commentParam);
        if(count>0){
            return CommonResult.success("评论成功");
        }else{
            return CommonResult.failed("评论失败");
        }
    }


    @ApiOperation("根据工作的id获取评论列表")
    @RequestMapping(value = "/comment/listByJob/{jid}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<JmsCommentVo>> commentsByJid(@PathVariable Long jid,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<JmsCommentVo> commentVoList = commentService.listByJid(jid,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(commentVoList),"根据工作id获取评论列表成功");
    }

    @ApiOperation("获取工作筛选条件")
    @RequestMapping(value = "/filters/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult filtersList(){
        List<JmsJobFilterVo> jobFilterVos = jobFilterService.list();
        return CommonResult.success(jobFilterVos);
    }





}
