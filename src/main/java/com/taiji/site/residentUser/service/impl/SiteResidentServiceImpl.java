package com.taiji.site.residentUser.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.residentUser.SiteResidentVO;
import com.taiji.site.residentUser.bean.SiteResidentDO;
import com.taiji.site.residentUser.dao.SiteResidentMapper;
import com.taiji.site.residentUser.service.SiteResidentService;
import com.taiji.site.residentUser.SiteResidentDTO;
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
public class SiteResidentServiceImpl extends BaseServiceImpl  implements SiteResidentService{

    @Autowired
    private SiteResidentMapper siteResidentMapper;

    @Override
    public boolean insert(SiteResidentDTO dto) throws Exception {
        //DTO转DO
        SiteResidentDO siteResidentDO = new SiteResidentDO();
        BeanUtils.copyProperties(dto, siteResidentDO, SiteResidentDO.class);
        return siteResidentMapper.insert(siteResidentDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteResidentDTO> list) throws Exception {
        List<SiteResidentDO> doList = modelMapper.map(list, new TypeToken<List<SiteResidentDO>>() {
        }.getType());
        return siteResidentMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteResidentDTO dto) throws Exception {
        SiteResidentDO siteResidentDO = new SiteResidentDO();
        BeanUtils.copyProperties(dto, siteResidentDO, SiteResidentDO.class);
        return siteResidentMapper.updateById(siteResidentDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteResidentMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteResidentDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteResidentMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteResidentVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteResidentDO siteResidentDO = siteResidentMapper.selectById(primaryKey);
        return Objects.isNull(siteResidentDO) ? null :modelMapper.map(siteResidentDO, SiteResidentVO.class);
    }

    @Override
    public SiteResidentVO selectOne(SiteResidentDTO dto) throws Exception {
        List<SiteResidentDO> list = siteResidentMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteResidentVO.class);
    }

    @Override
    public List<SiteResidentVO> list(SiteResidentDTO dto) throws Exception {
        return modelMapper.map(siteResidentMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteResidentVO>>() {
        }.getType());
    }

    @Override
    public List<SiteResidentVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteResidentMapper.selectBatchIds(ids), new TypeToken<List<SiteResidentVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteResidentVO> listByPage(SiteResidentDTO dto) throws Exception {
        PageInfo<SiteResidentVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteResidentDO> doPageInfo = new PageInfo<>(siteResidentMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteResidentVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteResidentDTO dto) throws Exception {
        return siteResidentMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteResidentDO> queryWrapper(SiteResidentDTO dto) {
        QueryWrapper<SiteResidentDO> query = new QueryWrapper<SiteResidentDO>();
        query.eq(StrUtil.isNotBlank(dto.getEmail()), "email", dto.getEmail());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getGender()), "gender", dto.getGender());
        query.eq(StrUtil.isNotBlank(dto.getIdcare()), "idcare", dto.getIdcare());
        query.eq(StrUtil.isNotBlank(dto.getPhone()), "phone", dto.getPhone());
        query.eq(ObjectUtil.isNotNull(dto.getBirth()), "birth", dto.getBirth());
        query.eq(StrUtil.isNotBlank(dto.getUserId()), "user_id", dto.getUserId());
        query.eq(StrUtil.isNotBlank(dto.getCommunityId()), "community_id", dto.getCommunityId());
        query.eq(StrUtil.isNotBlank(dto.getVillageId()), "village_id", dto.getVillageId());
        query.eq(StrUtil.isNotBlank(dto.getBuildingId()), "building_id", dto.getBuildingId());
        query.eq(StrUtil.isNotBlank(dto.getRoomNumber()), "room_number", dto.getRoomNumber());
        return query;
    }
}