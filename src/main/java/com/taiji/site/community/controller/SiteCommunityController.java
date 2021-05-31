package com.taiji.site.community.controller;

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

import com.taiji.site.community.service.SiteCommunityService;
import com.taiji.site.community.SiteCommunityDTO;
import com.taiji.site.community.SiteCommunityVO;

@RestController
@RequestMapping("site-community")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteCommunityController extends BaseRestController{

    @Autowired
    private SiteCommunityService siteCommunityService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteCommunityDTO dto) throws Exception {
        log.info("siteCommunityService.insert param is {}", dto);
        return siteCommunityService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteCommunityDTO> list) throws Exception {
        log.info("siteCommunityService.insertBatch param is {}", list);
        return siteCommunityService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteCommunityDTO dto) throws Exception {
        log.info("siteCommunityService.updateByPrimaryKey param is {}", dto);
        return siteCommunityService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteCommunityService.deleteByPrimaryKey param is {}", primaryKey);
        return siteCommunityService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteCommunityVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteCommunityService.selectByPrimaryKey param is {}", primaryKey);
        return siteCommunityService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteCommunityVO> listByPage(SiteCommunityDTO dto) throws Exception {
        log.info("siteCommunityService.listByPage param is {}", dto);
        return siteCommunityService.listByPage(dto);
    }


}