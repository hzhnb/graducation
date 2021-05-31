package com.taiji.site.village.controller;

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

import com.taiji.site.village.service.SiteVillageService;
import com.taiji.site.village.SiteVillageDTO;
import com.taiji.site.village.SiteVillageVO;

@RestController
@RequestMapping("site-village")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteVillageController extends BaseRestController{

    @Autowired
    private SiteVillageService siteVillageService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteVillageDTO dto) throws Exception {
        log.info("siteVillageService.insert param is {}", dto);
        return siteVillageService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteVillageDTO> list) throws Exception {
        log.info("siteVillageService.insertBatch param is {}", list);
        return siteVillageService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteVillageDTO dto) throws Exception {
        log.info("siteVillageService.updateByPrimaryKey param is {}", dto);
        return siteVillageService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteVillageService.deleteByPrimaryKey param is {}", primaryKey);
        return siteVillageService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteVillageVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteVillageService.selectByPrimaryKey param is {}", primaryKey);
        return siteVillageService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteVillageVO> listByPage(SiteVillageDTO dto) throws Exception {
        log.info("siteVillageService.listByPage param is {}", dto);
        return siteVillageService.listByPage(dto);
    }


}