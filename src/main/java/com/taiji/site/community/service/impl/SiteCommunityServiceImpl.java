package com.taiji.site.community.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.community.SiteCommunityVO;
import com.taiji.site.community.bean.SiteCommunityDO;
import com.taiji.site.community.dao.SiteCommunityMapper;
import com.taiji.site.community.service.SiteCommunityService;
import com.taiji.site.community.SiteCommunityDTO;
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
public class SiteCommunityServiceImpl extends BaseServiceImpl  implements SiteCommunityService{

    @Autowired
    private SiteCommunityMapper siteCommunityMapper;

    @Override
    public boolean insert(SiteCommunityDTO dto) throws Exception {
        //DTO转DO
        SiteCommunityDO siteCommunityDO = new SiteCommunityDO();
        BeanUtils.copyProperties(dto, siteCommunityDO, SiteCommunityDO.class);
        return siteCommunityMapper.insert(siteCommunityDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteCommunityDTO> list) throws Exception {
        List<SiteCommunityDO> doList = modelMapper.map(list, new TypeToken<List<SiteCommunityDO>>() {
        }.getType());
        return siteCommunityMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteCommunityDTO dto) throws Exception {
        SiteCommunityDO siteCommunityDO = new SiteCommunityDO();
        BeanUtils.copyProperties(dto, siteCommunityDO, SiteCommunityDO.class);
        return siteCommunityMapper.updateById(siteCommunityDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteCommunityMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteCommunityDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteCommunityMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteCommunityVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteCommunityDO siteCommunityDO = siteCommunityMapper.selectById(primaryKey);
        return Objects.isNull(siteCommunityDO) ? null :modelMapper.map(siteCommunityDO, SiteCommunityVO.class);
    }

    @Override
    public SiteCommunityVO selectOne(SiteCommunityDTO dto) throws Exception {
        List<SiteCommunityDO> list = siteCommunityMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteCommunityVO.class);
    }

    @Override
    public List<SiteCommunityVO> list(SiteCommunityDTO dto) throws Exception {
        return modelMapper.map(siteCommunityMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteCommunityVO>>() {
        }.getType());
    }

    @Override
    public List<SiteCommunityVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteCommunityMapper.selectBatchIds(ids), new TypeToken<List<SiteCommunityVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteCommunityVO> listByPage(SiteCommunityDTO dto) throws Exception {
        PageInfo<SiteCommunityVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteCommunityDO> doPageInfo = new PageInfo<>(siteCommunityMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteCommunityVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteCommunityDTO dto) throws Exception {
        return siteCommunityMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteCommunityDO> queryWrapper(SiteCommunityDTO dto) {
        QueryWrapper<SiteCommunityDO> query = new QueryWrapper<SiteCommunityDO>();
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getProvince()), "province", dto.getProvince());
        query.eq(StrUtil.isNotBlank(dto.getMarket()), "market", dto.getMarket());
        query.eq(StrUtil.isNotBlank(dto.getCounty()), "county", dto.getCounty());
        query.eq(StrUtil.isNotBlank(dto.getLongitude()), "longitude", dto.getLongitude());
        query.eq(StrUtil.isNotBlank(dto.getLatitude()), "latitude", dto.getLatitude());
        return query;
    }
}