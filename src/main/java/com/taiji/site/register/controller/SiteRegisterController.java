package com.taiji.site.register.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.web.base.BaseRestController;
import com.taiji.site.register.bean.SiteRegisterDTO;
import com.taiji.site.register.bean.SiteRegisterVO;
import com.taiji.site.register.service.SiteRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("site-register")
@Api(value = "出入登记信息接口", tags = {"出入登记信息接口"})
@Slf4j
public class SiteRegisterController extends BaseRestController{

    @Autowired
    private SiteRegisterService siteRegisterService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteRegisterDTO dto) throws Exception {
        log.info("siteRegisterService.insert param is {}", dto);
        return siteRegisterService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteRegisterDTO> list) throws Exception {
        log.info("siteRegisterService.insertBatch param is {}", list);
        return siteRegisterService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteRegisterDTO dto) throws Exception {
        log.info("siteRegisterService.updateByPrimaryKey param is {}", dto);
        return siteRegisterService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteRegisterService.deleteByPrimaryKey param is {}", primaryKey);
        return siteRegisterService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteRegisterVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteRegisterService.selectByPrimaryKey param is {}", primaryKey);
        return siteRegisterService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteRegisterVO> listByPage(SiteRegisterDTO dto) throws Exception {
        log.info("siteRegisterService.listByPage param is {}", dto);
        return siteRegisterService.listByPage(dto);
    }


}