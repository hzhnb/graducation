package com.taiji.site.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.user.SiteUserVO;
import com.taiji.site.user.bean.SiteUserDO;
import com.taiji.site.user.dao.SiteUserMapper;
import com.taiji.site.user.service.SiteUserService;
import com.taiji.site.user.SiteUserDTO;
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
public class SiteUserServiceImpl extends BaseServiceImpl  implements SiteUserService{

    @Autowired
    private SiteUserMapper siteUserMapper;

    @Override
    public boolean insert(SiteUserDTO dto) throws Exception {
        //DTO转DO
        SiteUserDO siteUserDO = new SiteUserDO();
        BeanUtils.copyProperties(dto, siteUserDO, SiteUserDO.class);
        return siteUserMapper.insert(siteUserDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteUserDTO> list) throws Exception {
        List<SiteUserDO> doList = modelMapper.map(list, new TypeToken<List<SiteUserDO>>() {
        }.getType());
        return siteUserMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteUserDTO dto) throws Exception {
        SiteUserDO siteUserDO = new SiteUserDO();
        BeanUtils.copyProperties(dto, siteUserDO, SiteUserDO.class);
        return siteUserMapper.updateById(siteUserDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteUserMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteUserDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteUserMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteUserVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteUserDO siteUserDO = siteUserMapper.selectById(primaryKey);
        return Objects.isNull(siteUserDO) ? null :modelMapper.map(siteUserDO, SiteUserVO.class);
    }

    @Override
    public SiteUserVO selectOne(SiteUserDTO dto) throws Exception {
        List<SiteUserDO> list = siteUserMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteUserVO.class);
    }

    @Override
    public List<SiteUserVO> list(SiteUserDTO dto) throws Exception {
        return modelMapper.map(siteUserMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteUserVO>>() {
        }.getType());
    }

    @Override
    public List<SiteUserVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteUserMapper.selectBatchIds(ids), new TypeToken<List<SiteUserVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteUserVO> listByPage(SiteUserDTO dto) throws Exception {
        PageInfo<SiteUserVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteUserDO> doPageInfo = new PageInfo<>(siteUserMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteUserVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteUserDTO dto) throws Exception {
        return siteUserMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteUserDO> queryWrapper(SiteUserDTO dto) {
        QueryWrapper<SiteUserDO> query = new QueryWrapper<SiteUserDO>();
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(ObjectUtil.isNotNull(dto.getCreatedTime()), "created_time", dto.getCreatedTime());
        query.eq(StrUtil.isNotBlank(dto.getCreatedBy()), "created_by", dto.getCreatedBy());
        query.eq(ObjectUtil.isNotNull(dto.getUpdatedTime()), "updated_time", dto.getUpdatedTime());
        query.eq(StrUtil.isNotBlank(dto.getUpdatedBy()), "updated_by", dto.getUpdatedBy());
        return query;
    }
}