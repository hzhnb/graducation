package com.taiji.site.visitor.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.visitor.SiteVisitorVO;
import com.taiji.site.visitor.bean.SiteVisitorDO;
import com.taiji.site.visitor.dao.SiteVisitorMapper;
import com.taiji.site.visitor.service.SiteVisitorService;
import com.taiji.site.visitor.SiteVisitorDTO;
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
public class SiteVisitorServiceImpl extends BaseServiceImpl  implements SiteVisitorService{

    @Autowired
    private SiteVisitorMapper siteVisitorMapper;

    @Override
    public boolean insert(SiteVisitorDTO dto) throws Exception {
        //DTO转DO
        SiteVisitorDO siteVisitorDO = new SiteVisitorDO();
        BeanUtils.copyProperties(dto, siteVisitorDO, SiteVisitorDO.class);
        return siteVisitorMapper.insert(siteVisitorDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteVisitorDTO> list) throws Exception {
        List<SiteVisitorDO> doList = modelMapper.map(list, new TypeToken<List<SiteVisitorDO>>() {
        }.getType());
        return siteVisitorMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteVisitorDTO dto) throws Exception {
        SiteVisitorDO siteVisitorDO = new SiteVisitorDO();
        BeanUtils.copyProperties(dto, siteVisitorDO, SiteVisitorDO.class);
        return siteVisitorMapper.updateById(siteVisitorDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteVisitorMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteVisitorDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteVisitorMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteVisitorVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteVisitorDO siteVisitorDO = siteVisitorMapper.selectById(primaryKey);
        return Objects.isNull(siteVisitorDO) ? null :modelMapper.map(siteVisitorDO, SiteVisitorVO.class);
    }

    @Override
    public SiteVisitorVO selectOne(SiteVisitorDTO dto) throws Exception {
        List<SiteVisitorDO> list = siteVisitorMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteVisitorVO.class);
    }

    @Override
    public List<SiteVisitorVO> list(SiteVisitorDTO dto) throws Exception {
        return modelMapper.map(siteVisitorMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteVisitorVO>>() {
        }.getType());
    }

    @Override
    public List<SiteVisitorVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteVisitorMapper.selectBatchIds(ids), new TypeToken<List<SiteVisitorVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteVisitorVO> listByPage(SiteVisitorDTO dto) throws Exception {
        PageInfo<SiteVisitorVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteVisitorDO> doPageInfo = new PageInfo<>(siteVisitorMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteVisitorVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteVisitorDTO dto) throws Exception {
        return siteVisitorMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteVisitorDO> queryWrapper(SiteVisitorDTO dto) {
        QueryWrapper<SiteVisitorDO> query = new QueryWrapper<SiteVisitorDO>();
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(StrUtil.isNotBlank(dto.getIdcare()), "idcare", dto.getIdcare());
        query.eq(StrUtil.isNotBlank(dto.getVfrom()), "vfrom", dto.getVfrom());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getPhone()), "phone", dto.getPhone());
        query.eq(ObjectUtil.isNotNull(dto.getTime()), "time", dto.getTime());
        query.eq(StrUtil.isNotBlank(dto.getResidentId()), "resident_id", dto.getResidentId());
        return query;
    }
}