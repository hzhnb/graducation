package com.taiji.site.sign.controller;

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

import com.taiji.site.sign.service.SiteSignService;
import com.taiji.site.sign.SiteSignDTO;
import com.taiji.site.sign.SiteSignVO;

@RestController
@RequestMapping("site-sign")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteSignController extends BaseRestController{

    @Autowired
    private SiteSignService siteSignService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteSignDTO dto) throws Exception {
        log.info("siteSignService.insert param is {}", dto);
        return siteSignService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteSignDTO> list) throws Exception {
        log.info("siteSignService.insertBatch param is {}", list);
        return siteSignService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteSignDTO dto) throws Exception {
        log.info("siteSignService.updateByPrimaryKey param is {}", dto);
        return siteSignService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteSignService.deleteByPrimaryKey param is {}", primaryKey);
        return siteSignService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteSignVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteSignService.selectByPrimaryKey param is {}", primaryKey);
        return siteSignService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteSignVO> listByPage(SiteSignDTO dto) throws Exception {
        log.info("siteSignService.listByPage param is {}", dto);
        return siteSignService.listByPage(dto);
    }


}