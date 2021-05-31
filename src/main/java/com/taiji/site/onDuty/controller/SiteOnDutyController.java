package com.taiji.site.onDuty.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.web.base.BaseRestController;
import com.taiji.eap.web.base.BaseTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.taiji.site.onDuty.service.SiteOnDutyService;
import com.taiji.site.onDuty.SiteOnDutyDTO;
import com.taiji.site.onDuty.SiteOnDutyVO;

@RestController
@RequestMapping("site-on-duty")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteOnDutyController extends BaseRestController{

    @Autowired
    private SiteOnDutyService siteOnDutyService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteOnDutyDTO dto) throws Exception {
        log.info("siteOnDutyService.insert param is {}", dto);
        return siteOnDutyService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteOnDutyDTO> list) throws Exception {
        log.info("siteOnDutyService.insertBatch param is {}", list);
        return siteOnDutyService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteOnDutyDTO dto) throws Exception {
        log.info("siteOnDutyService.updateByPrimaryKey param is {}", dto);
        return siteOnDutyService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteOnDutyService.deleteByPrimaryKey param is {}", primaryKey);
        return siteOnDutyService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteOnDutyVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteOnDutyService.selectByPrimaryKey param is {}", primaryKey);
        return siteOnDutyService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteOnDutyVO> listByPage(SiteOnDutyDTO dto) throws Exception {
        log.info("siteOnDutyService.listByPage param is {}", dto);
        return siteOnDutyService.listByPage(dto);
    }


}