package com.taiji.site.riskArea.controller;

import com.github.pagehelper.PageInfo;
import com.taiji.eap.web.annotation.DictionaryResponse;
import com.taiji.eap.web.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.taiji.site.riskArea.service.SiteRiskAreaService;
import com.taiji.site.riskArea.SiteRiskAreaDTO;
import com.taiji.site.riskArea.SiteRiskAreaVO;
import com.alibaba.fastjson.*;

@RestController
@RequestMapping("site-risk-area")
@Api(value = "接口", tags = {"接口"})
@Slf4j
public class SiteRiskAreaController extends BaseRestController{

    @Autowired
    private SiteRiskAreaService siteRiskAreaService;

    @PostMapping("")
    @ApiOperation(value = "新增", notes = "")
    public boolean insert(@Validated @RequestBody SiteRiskAreaDTO dto) throws Exception {
        log.info("siteRiskAreaService.insert param is {}", dto);
        return siteRiskAreaService.insert(dto);
    }

    @PostMapping("/batch")
    @ApiOperation(value = "批量新增", notes = "")
    public boolean insertBatch(@Validated @RequestBody List<SiteRiskAreaDTO> list) throws Exception {
        log.info("siteRiskAreaService.insertBatch param is {}", list);
        return siteRiskAreaService.insertBatch(list);
    }

    @PutMapping("")
    @ApiOperation(value = "按主键修改", notes = "")
    public boolean update(@Validated @RequestBody  SiteRiskAreaDTO dto) throws Exception {
        log.info("siteRiskAreaService.updateByPrimaryKey param is {}", dto);
        return siteRiskAreaService.updateByPrimaryKey(dto);
    }

    @DeleteMapping("/{primaryKey}")
    @ApiOperation(value = "按主键删除", notes = "参数说明:【必填参数】primaryKey 不能为空")
    public boolean deleteByPrimaryKey(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteRiskAreaService.deleteByPrimaryKey param is {}", primaryKey);
        return siteRiskAreaService.deleteByPrimaryKey(primaryKey);
    }


    @GetMapping("/{primaryKey}")
    @ApiOperation(value = "按主键查询", notes = "参数说明:【必填参数】: 主键不能为空 等等")
    public SiteRiskAreaVO select(@PathVariable("primaryKey") String primaryKey) throws Exception {
        log.info("siteRiskAreaService.selectByPrimaryKey param is {}", primaryKey);
        return siteRiskAreaService.selectByPrimaryKey(primaryKey);
    }

    @GetMapping("/grade")
    @ApiOperation(value = "分组查询", notes = "")
    public JSONObject grade(){
        Map<String,Integer> baseMap = new HashMap<>();
        List<Map<String,Integer>> baseList = siteRiskAreaService.grade();
        for (Map<String,Integer> map:baseList){
            String base = null;
            Integer fare = null;
            for (Map.Entry<String,Integer> entry:map.entrySet()){
                if ("grade".equals(entry.getKey())){
                    base = "grade" + String.valueOf(entry.getValue());
                }else if ("sun".equals(entry.getKey())){
                    fare = Integer.parseInt(String.valueOf(entry.getValue()));
                }
                baseMap.put(base,fare);
            }
        }
        String param = JSON.toJSONString(baseMap);
        JSONObject jsonObject = JSONObject.parseObject(param);
        System.out.println(jsonObject);
        return jsonObject;
    }

    @DictionaryResponse
    @GetMapping("")
    @ApiOperation(value = "分页查询list", notes = "")
    public PageInfo<SiteRiskAreaVO> listByPage(SiteRiskAreaDTO dto) throws Exception {
        log.info("siteRiskAreaService.listByPage param is {}", dto);
        return siteRiskAreaService.listByPage(dto);
    }


}