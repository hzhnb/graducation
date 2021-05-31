package com.taiji.site.riskArea.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.riskArea.SiteRiskAreaVO;
import com.taiji.site.riskArea.bean.SiteRiskAreaDO;
import com.taiji.site.riskArea.dao.SiteRiskAreaMapper;
import com.taiji.site.riskArea.service.SiteRiskAreaService;
import com.taiji.site.riskArea.SiteRiskAreaDTO;
import com.taiji.eap.web.util.PageUtil;
import com.taiji.eap.web.base.BaseServiceImpl;
import com.taiji.eap.web.base.BaseTree;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SiteRiskAreaServiceImpl extends BaseServiceImpl  implements SiteRiskAreaService{

    @Autowired
    private SiteRiskAreaMapper siteRiskAreaMapper;

    @Override
    public boolean insert(SiteRiskAreaDTO dto) throws Exception {
        //DTO转DO
        SiteRiskAreaDO siteRiskAreaDO = new SiteRiskAreaDO();
        BeanUtils.copyProperties(dto, siteRiskAreaDO, SiteRiskAreaDO.class);
        return siteRiskAreaMapper.insert(siteRiskAreaDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteRiskAreaDTO> list) throws Exception {
        List<SiteRiskAreaDO> doList = modelMapper.map(list, new TypeToken<List<SiteRiskAreaDO>>() {
        }.getType());
        return siteRiskAreaMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteRiskAreaDTO dto) throws Exception {
        SiteRiskAreaDO siteRiskAreaDO = new SiteRiskAreaDO();
        BeanUtils.copyProperties(dto, siteRiskAreaDO, SiteRiskAreaDO.class);
        return siteRiskAreaMapper.updateById(siteRiskAreaDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteRiskAreaMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteRiskAreaDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteRiskAreaMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteRiskAreaVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteRiskAreaDO siteRiskAreaDO = siteRiskAreaMapper.selectById(primaryKey);
        return Objects.isNull(siteRiskAreaDO) ? null :modelMapper.map(siteRiskAreaDO, SiteRiskAreaVO.class);
    }

    @Override
    public SiteRiskAreaVO selectOne(SiteRiskAreaDTO dto) throws Exception {
        List<SiteRiskAreaDO> list = siteRiskAreaMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteRiskAreaVO.class);
    }

    @Override
    public List<SiteRiskAreaVO> list(SiteRiskAreaDTO dto) throws Exception {
        return modelMapper.map(siteRiskAreaMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteRiskAreaVO>>() {
        }.getType());
    }

    @Override
    public List<SiteRiskAreaVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteRiskAreaMapper.selectBatchIds(ids), new TypeToken<List<SiteRiskAreaVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteRiskAreaVO> listByPage(SiteRiskAreaDTO dto) throws Exception {
        PageInfo<SiteRiskAreaVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteRiskAreaDO> doPageInfo = new PageInfo<>(siteRiskAreaMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteRiskAreaVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteRiskAreaDTO dto) throws Exception {
        return siteRiskAreaMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteRiskAreaDO> queryWrapper(SiteRiskAreaDTO dto) {
        QueryWrapper<SiteRiskAreaDO> query = new QueryWrapper<SiteRiskAreaDO>();
        query.eq(StrUtil.isNotBlank(dto.getGrade()), "grade", dto.getGrade());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getLongitude()), "longitude", dto.getLongitude());
        query.eq(StrUtil.isNotBlank(dto.getLatitude()), "latitude", dto.getLatitude());
        query.eq(StrUtil.isNotBlank(dto.getProvince()), "province", dto.getProvince());
        query.eq(StrUtil.isNotBlank(dto.getMarket()), "market", dto.getMarket());
        query.eq(StrUtil.isNotBlank(dto.getCounty()), "county", dto.getCounty());
        query.eq(ObjectUtil.isNotNull(dto.getStartTime()), "start_time", dto.getStartTime());
        return query;
    }


    @Override
    public List<Map<String, Integer>> grade(){
        return siteRiskAreaMapper.grade();
    }
}