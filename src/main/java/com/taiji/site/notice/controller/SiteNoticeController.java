package com.taiji.site.notice.controller;

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

import com.taiji.site.notice.service.SiteNoticeService;
import com.taiji.site.notice.SiteNoticeDTO;
import com.taiji.site.notice.SiteNoticeVO;

@RestController
@RequestMapping("site-notice")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteNoticeController extends BaseRestController{

    @Autowired
    private SiteNoticeService siteNoticeService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteNoticeDTO dto) throws Exception {
        log.info("siteNoticeService.insert param is {}", dto);
        return siteNoticeService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteNoticeDTO> list) throws Exception {
        log.info("siteNoticeService.insertBatch param is {}", list);
        return siteNoticeService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteNoticeDTO dto) throws Exception {
        log.info("siteNoticeService.updateByPrimaryKey param is {}", dto);
        return siteNoticeService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteNoticeService.deleteByPrimaryKey param is {}", primaryKey);
        return siteNoticeService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteNoticeVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteNoticeService.selectByPrimaryKey param is {}", primaryKey);
        return siteNoticeService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteNoticeVO> listByPage(SiteNoticeDTO dto) throws Exception {
        log.info("siteNoticeService.listByPage param is {}", dto);
        return siteNoticeService.listByPage(dto);
    }


}