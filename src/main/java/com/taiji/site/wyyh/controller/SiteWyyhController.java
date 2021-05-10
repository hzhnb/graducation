package com.taiji.site.wyyh.controller;

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

import com.taiji.site.wyyh.service.SiteWyyhService;
import com.taiji.site.wyyh.SiteWyyhDTO;
import com.taiji.site.wyyh.SiteWyyhVO;

@RestController
@RequestMapping("site-wyyh")
@Api(value = "物业用户信息表接口", tags = {"物业用户信息表接口"})
@Slf4j
public class SiteWyyhController extends BaseRestController{

    @Autowired
    private SiteWyyhService siteWyyhService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteWyyhDTO dto) throws Exception {
        log.info("siteWyyhService.insert param is {}", dto);
        return siteWyyhService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteWyyhDTO> list) throws Exception {
        log.info("siteWyyhService.insertBatch param is {}", list);
        return siteWyyhService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteWyyhDTO dto) throws Exception {
        log.info("siteWyyhService.updateByPrimaryKey param is {}", dto);
        return siteWyyhService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteWyyhService.deleteByPrimaryKey param is {}", primaryKey);
        return siteWyyhService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteWyyhVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteWyyhService.selectByPrimaryKey param is {}", primaryKey);
        return siteWyyhService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteWyyhVO> listByPage(SiteWyyhDTO dto) throws Exception {
        log.info("siteWyyhService.listByPage param is {}", dto);
        return siteWyyhService.listByPage(dto);
    }


}