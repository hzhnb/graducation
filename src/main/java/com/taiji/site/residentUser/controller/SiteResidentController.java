package com.taiji.site.residentUser.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.eap.web.annotation.DictionaryResponse;
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

import com.taiji.site.residentUser.service.SiteResidentService;
import com.taiji.site.residentUser.SiteResidentDTO;
import com.taiji.site.residentUser.SiteResidentVO;

@RestController
@RequestMapping("site-resident")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteResidentController extends BaseRestController{

    @Autowired
    private SiteResidentService siteResidentService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteResidentDTO dto) throws Exception {
        log.info("siteResidentService.insert param is {}", dto);
        return siteResidentService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteResidentDTO> list) throws Exception {
        log.info("siteResidentService.insertBatch param is {}", list);
        return siteResidentService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteResidentDTO dto) throws Exception {
        log.info("siteResidentService.updateByPrimaryKey param is {}", dto);
        return siteResidentService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteResidentService.deleteByPrimaryKey param is {}", primaryKey);
        return siteResidentService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteResidentVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteResidentService.selectByPrimaryKey param is {}", primaryKey);
        return siteResidentService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteResidentVO> listByPage(SiteResidentDTO dto) throws Exception {
        log.info("siteResidentService.listByPage param is {}", dto);
        return siteResidentService.listByPage(dto);
    }


}