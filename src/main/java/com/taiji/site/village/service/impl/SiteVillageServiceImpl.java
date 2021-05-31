package com.taiji.site.village.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.village.SiteVillageVO;
import com.taiji.site.village.bean.SiteVillageDO;
import com.taiji.site.village.dao.SiteVillageMapper;
import com.taiji.site.village.service.SiteVillageService;
import com.taiji.site.village.SiteVillageDTO;
import com.taiji.eap.web.util.PageUtil;
import com.taiji.eap.web.base.BaseServiceImpl;
import com.taiji.eap.web.base.BaseTree;
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
public class SiteVillageServiceImpl extends BaseServiceImpl  implements SiteVillageService{

    @Autowired
    private SiteVillageMapper siteVillageMapper;

    @Override
    public boolean insert(SiteVillageDTO dto) throws Exception {
        //DTO转DO
        SiteVillageDO siteVillageDO = new SiteVillageDO();
        BeanUtils.copyProperties(dto, siteVillageDO, SiteVillageDO.class);
        return siteVillageMapper.insert(siteVillageDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteVillageDTO> list) throws Exception {
        List<SiteVillageDO> doList = modelMapper.map(list, new TypeToken<List<SiteVillageDO>>() {
        }.getType());
        return siteVillageMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteVillageDTO dto) throws Exception {
        SiteVillageDO siteVillageDO = new SiteVillageDO();
        BeanUtils.copyProperties(dto, siteVillageDO, SiteVillageDO.class);
        return siteVillageMapper.updateById(siteVillageDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteVillageMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteVillageDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteVillageMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteVillageVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteVillageDO siteVillageDO = siteVillageMapper.selectById(primaryKey);
        return Objects.isNull(siteVillageDO) ? null :modelMapper.map(siteVillageDO, SiteVillageVO.class);
    }

    @Override
    public SiteVillageVO selectOne(SiteVillageDTO dto) throws Exception {
        List<SiteVillageDO> list = siteVillageMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteVillageVO.class);
    }

    @Override
    public List<SiteVillageVO> list(SiteVillageDTO dto) throws Exception {
        return modelMapper.map(siteVillageMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteVillageVO>>() {
        }.getType());
    }

    @Override
    public List<SiteVillageVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteVillageMapper.selectBatchIds(ids), new TypeToken<List<SiteVillageVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteVillageVO> listByPage(SiteVillageDTO dto) throws Exception {
        PageInfo<SiteVillageVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteVillageDO> doPageInfo = new PageInfo<>(siteVillageMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteVillageVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteVillageDTO dto) throws Exception {
        return siteVillageMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteVillageDO> queryWrapper(SiteVillageDTO dto) {
        QueryWrapper<SiteVillageDO> query = new QueryWrapper<SiteVillageDO>();
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getProvince()), "province", dto.getProvince());
        query.eq(StrUtil.isNotBlank(dto.getMarket()), "market", dto.getMarket());
        query.eq(StrUtil.isNotBlank(dto.getCounty()), "county", dto.getCounty());
        query.eq(StrUtil.isNotBlank(dto.getLongitude()), "longitude", dto.getLongitude());
        query.eq(StrUtil.isNotBlank(dto.getLatitude()), "latitude", dto.getLatitude());
        query.eq(StrUtil.isNotBlank(dto.getPropertyName()), "property_name", dto.getPropertyName());
        query.eq(StrUtil.isNotBlank(dto.getCommunityId()), "community_id", dto.getCommunityId());
        query.eq(StrUtil.isNotBlank(dto.getVillageDescribe()), "village_describe", dto.getVillageDescribe());
        return query;
    }
}