package com.taiji.site.building.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.building.SiteBuildingVO;
import com.taiji.site.building.bean.SiteBuildingDO;
import com.taiji.site.building.dao.SiteBuildingMapper;
import com.taiji.site.building.service.SiteBuildingService;
import com.taiji.site.building.SiteBuildingDTO;
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
public class SiteBuildingServiceImpl extends BaseServiceImpl  implements SiteBuildingService{

    @Autowired
    private SiteBuildingMapper siteBuildingMapper;

    @Override
    public boolean insert(SiteBuildingDTO dto) throws Exception {
        //DTO转DO
        SiteBuildingDO siteBuildingDO = new SiteBuildingDO();
        BeanUtils.copyProperties(dto, siteBuildingDO, SiteBuildingDO.class);
        return siteBuildingMapper.insert(siteBuildingDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteBuildingDTO> list) throws Exception {
        List<SiteBuildingDO> doList = modelMapper.map(list, new TypeToken<List<SiteBuildingDO>>() {
        }.getType());
        return siteBuildingMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteBuildingDTO dto) throws Exception {
        SiteBuildingDO siteBuildingDO = new SiteBuildingDO();
        BeanUtils.copyProperties(dto, siteBuildingDO, SiteBuildingDO.class);
        return siteBuildingMapper.updateById(siteBuildingDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteBuildingMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteBuildingDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteBuildingMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteBuildingVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteBuildingDO siteBuildingDO = siteBuildingMapper.selectById(primaryKey);
        return Objects.isNull(siteBuildingDO) ? null :modelMapper.map(siteBuildingDO, SiteBuildingVO.class);
    }

    @Override
    public SiteBuildingVO selectOne(SiteBuildingDTO dto) throws Exception {
        List<SiteBuildingDO> list = siteBuildingMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteBuildingVO.class);
    }

    @Override
    public List<SiteBuildingVO> list(SiteBuildingDTO dto) throws Exception {
        return modelMapper.map(siteBuildingMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteBuildingVO>>() {
        }.getType());
    }

    @Override
    public List<SiteBuildingVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteBuildingMapper.selectBatchIds(ids), new TypeToken<List<SiteBuildingVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteBuildingVO> listByPage(SiteBuildingDTO dto) throws Exception {
        PageInfo<SiteBuildingVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteBuildingDO> doPageInfo = new PageInfo<>(siteBuildingMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteBuildingVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteBuildingDTO dto) throws Exception {
        return siteBuildingMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteBuildingDO> queryWrapper(SiteBuildingDTO dto) {
        QueryWrapper<SiteBuildingDO> query = new QueryWrapper<SiteBuildingDO>();
        query.eq(StrUtil.isNotBlank(dto.getNumber()), "number", dto.getNumber());
        query.eq(StrUtil.isNotBlank(dto.getFloor()), "floor", dto.getFloor());
        query.eq(StrUtil.isNotBlank(dto.getHouseholdsNumber()), "households_number", dto.getHouseholdsNumber());
        query.eq(StrUtil.isNotBlank(dto.getVillageId()), "village_id", dto.getVillageId());
        return query;
    }
}