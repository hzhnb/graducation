package com.taiji.site.worker.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.web.base.BaseRestController;
import com.taiji.site.worker.bean.SiteWorkerDTO;
import com.taiji.site.worker.bean.SiteWorkerVO;
import com.taiji.site.worker.service.SiteWorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("site-worker")
@Api(value = "工人信息接口", tags = {"工人信息接口"})
@Slf4j
public class SiteWorkerController extends BaseRestController{

    @Autowired
    private SiteWorkerService siteWorkerService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteWorkerDTO dto) throws Exception {
        log.info("siteWorkerService.insert param is {}", dto);
        return siteWorkerService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteWorkerDTO> list) throws Exception {
        log.info("siteWorkerService.insertBatch param is {}", list);
        return siteWorkerService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteWorkerDTO dto) throws Exception {
        log.info("siteWorkerService.updateByPrimaryKey param is {}", dto);
        return siteWorkerService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteWorkerService.deleteByPrimaryKey param is {}", primaryKey);
        return siteWorkerService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteWorkerVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteWorkerService.selectByPrimaryKey param is {}", primaryKey);
        return siteWorkerService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteWorkerVO> listByPage(SiteWorkerDTO dto) throws Exception {
        log.info("siteWorkerService.listByPage param is {}", dto);
        return siteWorkerService.listByPage(dto);
    }


}