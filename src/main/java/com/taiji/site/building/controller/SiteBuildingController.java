package com.taiji.site.building.controller;

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

import com.taiji.site.building.service.SiteBuildingService;
import com.taiji.site.building.SiteBuildingDTO;
import com.taiji.site.building.SiteBuildingVO;

@RestController
@RequestMapping("site-building")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteBuildingController extends BaseRestController{

    @Autowired
    private SiteBuildingService siteBuildingService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteBuildingDTO dto) throws Exception {
        log.info("siteBuildingService.insert param is {}", dto);
        return siteBuildingService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteBuildingDTO> list) throws Exception {
        log.info("siteBuildingService.insertBatch param is {}", list);
        return siteBuildingService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteBuildingDTO dto) throws Exception {
        log.info("siteBuildingService.updateByPrimaryKey param is {}", dto);
        return siteBuildingService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteBuildingService.deleteByPrimaryKey param is {}", primaryKey);
        return siteBuildingService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteBuildingVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteBuildingService.selectByPrimaryKey param is {}", primaryKey);
        return siteBuildingService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteBuildingVO> listByPage(SiteBuildingDTO dto) throws Exception {
        log.info("siteBuildingService.listByPage param is {}", dto);
        return siteBuildingService.listByPage(dto);
    }


}