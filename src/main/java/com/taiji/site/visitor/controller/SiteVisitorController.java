package com.taiji.site.visitor.controller;

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

import com.taiji.site.visitor.service.SiteVisitorService;
import com.taiji.site.visitor.SiteVisitorDTO;
import com.taiji.site.visitor.SiteVisitorVO;

@RestController
@RequestMapping("site-visitor")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteVisitorController extends BaseRestController{

    @Autowired
    private SiteVisitorService siteVisitorService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteVisitorDTO dto) throws Exception {
        log.info("siteVisitorService.insert param is {}", dto);
        return siteVisitorService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteVisitorDTO> list) throws Exception {
        log.info("siteVisitorService.insertBatch param is {}", list);
        return siteVisitorService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteVisitorDTO dto) throws Exception {
        log.info("siteVisitorService.updateByPrimaryKey param is {}", dto);
        return siteVisitorService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteVisitorService.deleteByPrimaryKey param is {}", primaryKey);
        return siteVisitorService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteVisitorVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteVisitorService.selectByPrimaryKey param is {}", primaryKey);
        return siteVisitorService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteVisitorVO> listByPage(SiteVisitorDTO dto) throws Exception {
        log.info("siteVisitorService.listByPage param is {}", dto);
        return siteVisitorService.listByPage(dto);
    }


}