package com.taiji.site.user.controller;

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

import com.taiji.site.user.service.SiteUserService;
import com.taiji.site.user.SiteUserDTO;
import com.taiji.site.user.SiteUserVO;

@RestController
@RequestMapping("site-user")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteUserController extends BaseRestController{

    @Autowired
    private SiteUserService siteUserService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteUserDTO dto) throws Exception {
        log.info("siteUserService.insert param is {}", dto);
        return siteUserService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteUserDTO> list) throws Exception {
        log.info("siteUserService.insertBatch param is {}", list);
        return siteUserService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteUserDTO dto) throws Exception {
        log.info("siteUserService.updateByPrimaryKey param is {}", dto);
        return siteUserService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteUserService.deleteByPrimaryKey param is {}", primaryKey);
        return siteUserService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteUserVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteUserService.selectByPrimaryKey param is {}", primaryKey);
        return siteUserService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteUserVO> listByPage(SiteUserDTO dto) throws Exception {
        log.info("siteUserService.listByPage param is {}", dto);
        return siteUserService.listByPage(dto);
    }


}