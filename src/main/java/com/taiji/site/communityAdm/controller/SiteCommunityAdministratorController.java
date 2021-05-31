package com.taiji.site.communityAdm.controller;

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

import com.taiji.site.communityAdm.service.SiteCommunityAdministratorService;
import com.taiji.site.communityAdm.SiteCommunityAdministratorDTO;
import com.taiji.site.communityAdm.SiteCommunityAdministratorVO;

@RestController
@RequestMapping("site-community-administrator")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteCommunityAdministratorController extends BaseRestController{

    @Autowired
    private SiteCommunityAdministratorService siteCommunityAdministratorService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteCommunityAdministratorDTO dto) throws Exception {
        log.info("siteCommunityAdministratorService.insert param is {}", dto);
        return siteCommunityAdministratorService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteCommunityAdministratorDTO> list) throws Exception {
        log.info("siteCommunityAdministratorService.insertBatch param is {}", list);
        return siteCommunityAdministratorService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteCommunityAdministratorDTO dto) throws Exception {
        log.info("siteCommunityAdministratorService.updateByPrimaryKey param is {}", dto);
        return siteCommunityAdministratorService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteCommunityAdministratorService.deleteByPrimaryKey param is {}", primaryKey);
        return siteCommunityAdministratorService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteCommunityAdministratorVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteCommunityAdministratorService.selectByPrimaryKey param is {}", primaryKey);
        return siteCommunityAdministratorService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteCommunityAdministratorVO> listByPage(SiteCommunityAdministratorDTO dto) throws Exception {
        log.info("siteCommunityAdministratorService.listByPage param is {}", dto);
        return siteCommunityAdministratorService.listByPage(dto);
    }


}