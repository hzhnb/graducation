package com.taiji.site.onDuty.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.onDuty.SiteOnDutyVO;
import com.taiji.site.onDuty.bean.SiteOnDutyDO;
import com.taiji.site.onDuty.dao.SiteOnDutyMapper;
import com.taiji.site.onDuty.service.SiteOnDutyService;
import com.taiji.site.onDuty.SiteOnDutyDTO;
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
public class SiteOnDutyServiceImpl extends BaseServiceImpl  implements SiteOnDutyService{

    @Autowired
    private SiteOnDutyMapper siteOnDutyMapper;

    @Override
    public boolean insert(SiteOnDutyDTO dto) throws Exception {
        //DTO转DO
        SiteOnDutyDO siteOnDutyDO = new SiteOnDutyDO();
        BeanUtils.copyProperties(dto, siteOnDutyDO, SiteOnDutyDO.class);
        return siteOnDutyMapper.insert(siteOnDutyDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteOnDutyDTO> list) throws Exception {
        List<SiteOnDutyDO> doList = modelMapper.map(list, new TypeToken<List<SiteOnDutyDO>>() {
        }.getType());
        return siteOnDutyMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteOnDutyDTO dto) throws Exception {
        SiteOnDutyDO siteOnDutyDO = new SiteOnDutyDO();
        BeanUtils.copyProperties(dto, siteOnDutyDO, SiteOnDutyDO.class);
        return siteOnDutyMapper.updateById(siteOnDutyDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteOnDutyMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteOnDutyDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteOnDutyMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteOnDutyVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteOnDutyDO siteOnDutyDO = siteOnDutyMapper.selectById(primaryKey);
        return Objects.isNull(siteOnDutyDO) ? null :modelMapper.map(siteOnDutyDO, SiteOnDutyVO.class);
    }

    @Override
    public SiteOnDutyVO selectOne(SiteOnDutyDTO dto) throws Exception {
        List<SiteOnDutyDO> list = siteOnDutyMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteOnDutyVO.class);
    }

    @Override
    public List<SiteOnDutyVO> list(SiteOnDutyDTO dto) throws Exception {
        return modelMapper.map(siteOnDutyMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteOnDutyVO>>() {
        }.getType());
    }

    @Override
    public List<SiteOnDutyVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteOnDutyMapper.selectBatchIds(ids), new TypeToken<List<SiteOnDutyVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteOnDutyVO> listByPage(SiteOnDutyDTO dto) throws Exception {
        PageInfo<SiteOnDutyVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteOnDutyDO> doPageInfo = new PageInfo<>(siteOnDutyMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteOnDutyVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteOnDutyDTO dto) throws Exception {
        return siteOnDutyMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteOnDutyDO> queryWrapper(SiteOnDutyDTO dto) {
        QueryWrapper<SiteOnDutyDO> query = new QueryWrapper<SiteOnDutyDO>();
        query.eq(ObjectUtil.isNotNull(dto.getTime()), "time", dto.getTime());
        query.eq(StrUtil.isNotBlank(dto.getMission()), "mission", dto.getMission());
        query.eq(ObjectUtil.isNotNull(dto.getStartTime()), "start_time", dto.getStartTime());
        query.eq(ObjectUtil.isNotNull(dto.getEndTime()), "end_time", dto.getEndTime());
        query.eq(StrUtil.isNotBlank(dto.getAdministratorId()), "administrator_id", dto.getAdministratorId());
        query.eq(StrUtil.isNotBlank(dto.getVillageId()), "village_id", dto.getVillageId());
        return query;
    }
}