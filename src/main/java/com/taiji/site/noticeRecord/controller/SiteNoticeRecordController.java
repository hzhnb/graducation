package com.taiji.site.noticeRecord.controller;

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

import com.taiji.site.noticeRecord.service.SiteNoticeRecordService;
import com.taiji.site.noticeRecord.SiteNoticeRecordDTO;
import com.taiji.site.noticeRecord.SiteNoticeRecordVO;

@RestController
@RequestMapping("site-notice-record")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteNoticeRecordController extends BaseRestController{

    @Autowired
    private SiteNoticeRecordService siteNoticeRecordService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteNoticeRecordDTO dto) throws Exception {
        log.info("siteNoticeRecordService.insert param is {}", dto);
        return siteNoticeRecordService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteNoticeRecordDTO> list) throws Exception {
        log.info("siteNoticeRecordService.insertBatch param is {}", list);
        return siteNoticeRecordService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteNoticeRecordDTO dto) throws Exception {
        log.info("siteNoticeRecordService.updateByPrimaryKey param is {}", dto);
        return siteNoticeRecordService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteNoticeRecordService.deleteByPrimaryKey param is {}", primaryKey);
        return siteNoticeRecordService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteNoticeRecordVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteNoticeRecordService.selectByPrimaryKey param is {}", primaryKey);
        return siteNoticeRecordService.selectByPrimaryKey(primaryKey);
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteNoticeRecordVO> listByPage(SiteNoticeRecordDTO dto) throws Exception {
        log.info("siteNoticeRecordService.listByPage param is {}", dto);
        return siteNoticeRecordService.listByPage(dto);
    }


}