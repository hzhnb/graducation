package com.taiji.site.wyyh.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.wyyh.SiteWyyhVO;
import com.taiji.site.wyyh.bean.SiteWyyhDO;
import com.taiji.site.wyyh.dao.SiteWyyhMapper;
import com.taiji.site.wyyh.service.SiteWyyhService;
import com.taiji.site.wyyh.SiteWyyhDTO;
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
public class SiteWyyhServiceImpl extends BaseServiceImpl  implements SiteWyyhService{

    @Autowired
    private SiteWyyhMapper siteWyyhMapper;

    @Override
    public boolean insert(SiteWyyhDTO dto) throws Exception {
        //DTO转DO
        SiteWyyhDO siteWyyhDO = new SiteWyyhDO();
        BeanUtils.copyProperties(dto, siteWyyhDO, SiteWyyhDO.class);
        return siteWyyhMapper.insert(siteWyyhDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteWyyhDTO> list) throws Exception {
        List<SiteWyyhDO> doList = modelMapper.map(list, new TypeToken<List<SiteWyyhDO>>() {
        }.getType());
        return siteWyyhMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteWyyhDTO dto) throws Exception {
        SiteWyyhDO siteWyyhDO = new SiteWyyhDO();
        BeanUtils.copyProperties(dto, siteWyyhDO, SiteWyyhDO.class);
        return siteWyyhMapper.updateById(siteWyyhDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteWyyhMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteWyyhDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteWyyhMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteWyyhVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteWyyhDO siteWyyhDO = siteWyyhMapper.selectById(primaryKey);
        return Objects.isNull(siteWyyhDO) ? null :modelMapper.map(siteWyyhDO, SiteWyyhVO.class);
    }

    @Override
    public SiteWyyhVO selectOne(SiteWyyhDTO dto) throws Exception {
        List<SiteWyyhDO> list = siteWyyhMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteWyyhVO.class);
    }

    @Override
    public List<SiteWyyhVO> list(SiteWyyhDTO dto) throws Exception {
        return modelMapper.map(siteWyyhMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteWyyhVO>>() {
        }.getType());
    }

    @Override
    public List<SiteWyyhVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteWyyhMapper.selectBatchIds(ids), new TypeToken<List<SiteWyyhVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteWyyhVO> listByPage(SiteWyyhDTO dto) throws Exception {
        PageInfo<SiteWyyhVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteWyyhDO> doPageInfo = new PageInfo<>(siteWyyhMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteWyyhVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteWyyhDTO dto) throws Exception {
        return siteWyyhMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteWyyhDO> queryWrapper(SiteWyyhDTO dto) {
        QueryWrapper<SiteWyyhDO> query = new QueryWrapper<SiteWyyhDO>();
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(StrUtil.isNotBlank(dto.getSex()), "sex", dto.getSex());
        query.eq(ObjectUtil.isNotNull(dto.getAge()), "age", dto.getAge());
        query.eq(StrUtil.isNotBlank(dto.getProfession()), "profession", dto.getProfession());
        return query;
    }
}