package com.taiji.site.register.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.register.bean.SiteRegisterVO;
import com.taiji.site.register.bean.SiteRegisterDO;
import com.taiji.site.register.dao.SiteRegisterMapper;
import com.taiji.site.register.service.SiteRegisterService;
import com.taiji.site.register.bean.SiteRegisterDTO;
import com.taiji.eap.web.util.PageUtil;
import com.taiji.eap.web.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SiteRegisterServiceImpl extends BaseServiceImpl  implements SiteRegisterService{

    @Autowired
    private SiteRegisterMapper siteRegisterMapper;

    @Override
    public boolean insert(SiteRegisterDTO dto) throws Exception {
        //DTO转DO
        SiteRegisterDO siteRegisterDO = new SiteRegisterDO();
        BeanUtils.copyProperties(dto, siteRegisterDO, SiteRegisterDO.class);
        return siteRegisterMapper.insert(siteRegisterDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteRegisterDTO> list) throws Exception {
        List<SiteRegisterDO> doList = modelMapper.map(list, new TypeToken<List<SiteRegisterDO>>() {
        }.getType());
        return siteRegisterMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteRegisterDTO dto) throws Exception {
        SiteRegisterDO siteRegisterDO = new SiteRegisterDO();
        BeanUtils.copyProperties(dto, siteRegisterDO, SiteRegisterDO.class);
        return siteRegisterMapper.updateById(siteRegisterDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteRegisterMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteRegisterDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteRegisterMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteRegisterVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteRegisterDO siteRegisterDO = siteRegisterMapper.selectById(primaryKey);
        return Objects.isNull(siteRegisterDO) ? null :modelMapper.map(siteRegisterDO, SiteRegisterVO.class);
    }

    @Override
    public SiteRegisterVO selectOne(SiteRegisterDTO dto) throws Exception {
        List<SiteRegisterDO> list = siteRegisterMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteRegisterVO.class);
    }

    @Override
    public List<SiteRegisterVO> list(SiteRegisterDTO dto) throws Exception {
        return modelMapper.map(siteRegisterMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteRegisterVO>>() {
        }.getType());
    }

    @Override
    public List<SiteRegisterVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteRegisterMapper.selectBatchIds(ids), new TypeToken<List<SiteRegisterVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteRegisterVO> listByPage(SiteRegisterDTO dto) throws Exception {
        PageInfo<SiteRegisterVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteRegisterDO> doPageInfo = new PageInfo<>(siteRegisterMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteRegisterVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteRegisterDTO dto) throws Exception {
        return siteRegisterMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteRegisterDO> queryWrapper(SiteRegisterDTO dto) {
        QueryWrapper<SiteRegisterDO> query = new QueryWrapper<SiteRegisterDO>();
        query.eq(StrUtil.isNotBlank(dto.getWorkerId()), "worker_id", dto.getWorkerId());
        query.eq(StrUtil.isNotBlank(dto.getRegistrant()), "registrant", dto.getRegistrant());
        query.eq(ObjectUtil.isNotNull(dto.getRegisterTime()), "register_time", dto.getRegisterTime());
        query.eq(StrUtil.isNotBlank(dto.getRegisterType()), "register_type", dto.getRegisterType());
        query.eq(StrUtil.isNotBlank(dto.getRemark()), "remark", dto.getRemark());
        return query;
    }
}