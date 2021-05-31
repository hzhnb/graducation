package com.taiji.site.sign.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.sign.SiteSignVO;
import com.taiji.site.sign.bean.SiteSignDO;
import com.taiji.site.sign.dao.SiteSignMapper;
import com.taiji.site.sign.service.SiteSignService;
import com.taiji.site.sign.SiteSignDTO;
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
public class SiteSignServiceImpl extends BaseServiceImpl  implements SiteSignService{

    @Autowired
    private SiteSignMapper siteSignMapper;

    @Override
    public boolean insert(SiteSignDTO dto) throws Exception {
        //DTO转DO
        SiteSignDO siteSignDO = new SiteSignDO();
        BeanUtils.copyProperties(dto, siteSignDO, SiteSignDO.class);
        return siteSignMapper.insert(siteSignDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteSignDTO> list) throws Exception {
        List<SiteSignDO> doList = modelMapper.map(list, new TypeToken<List<SiteSignDO>>() {
        }.getType());
        return siteSignMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteSignDTO dto) throws Exception {
        SiteSignDO siteSignDO = new SiteSignDO();
        BeanUtils.copyProperties(dto, siteSignDO, SiteSignDO.class);
        return siteSignMapper.updateById(siteSignDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteSignMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteSignDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteSignMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteSignVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteSignDO siteSignDO = siteSignMapper.selectById(primaryKey);
        return Objects.isNull(siteSignDO) ? null :modelMapper.map(siteSignDO, SiteSignVO.class);
    }

    @Override
    public SiteSignVO selectOne(SiteSignDTO dto) throws Exception {
        List<SiteSignDO> list = siteSignMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteSignVO.class);
    }

    @Override
    public List<SiteSignVO> list(SiteSignDTO dto) throws Exception {
        return modelMapper.map(siteSignMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteSignVO>>() {
        }.getType());
    }

    @Override
    public List<SiteSignVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteSignMapper.selectBatchIds(ids), new TypeToken<List<SiteSignVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteSignVO> listByPage(SiteSignDTO dto) throws Exception {
        PageInfo<SiteSignVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteSignDO> doPageInfo = new PageInfo<>(siteSignMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteSignVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteSignDTO dto) throws Exception {
        return siteSignMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteSignDO> queryWrapper(SiteSignDTO dto) {
        QueryWrapper<SiteSignDO> query = new QueryWrapper<SiteSignDO>();
        query.eq(StrUtil.isNotBlank(dto.getTemperature()), "temperature", dto.getTemperature());
        query.eq(StrUtil.isNotBlank(dto.getIsGet()), "is_get", dto.getIsGet());
        query.eq(StrUtil.isNotBlank(dto.getState()), "state", dto.getState());
        query.eq(StrUtil.isNotBlank(dto.getIsContact()), "is_contact", dto.getIsContact());
        query.eq(ObjectUtil.isNotNull(dto.getTime()), "time", dto.getTime());
        return query;
    }
}