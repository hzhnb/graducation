package com.taiji.site.worker.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.worker.bean.SiteWorkerVO;
import com.taiji.site.worker.bean.SiteWorkerDO;
import com.taiji.site.worker.dao.SiteWorkerMapper;
import com.taiji.site.worker.service.SiteWorkerService;
import com.taiji.site.worker.bean.SiteWorkerDTO;
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
public class SiteWorkerServiceImpl extends BaseServiceImpl  implements SiteWorkerService {

    @Autowired
    private SiteWorkerMapper siteWorkerMapper;

    @Override
    public boolean insert(SiteWorkerDTO dto) throws Exception {
        //DTO转DO
        SiteWorkerDO siteWorkerDO = new SiteWorkerDO();
        BeanUtils.copyProperties(dto, siteWorkerDO, SiteWorkerDO.class);
        return siteWorkerMapper.insert(siteWorkerDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteWorkerDTO> list) throws Exception {
        List<SiteWorkerDO> doList = modelMapper.map(list, new TypeToken<List<SiteWorkerDO>>() {
        }.getType());
        return siteWorkerMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteWorkerDTO dto) throws Exception {
        SiteWorkerDO siteWorkerDO = new SiteWorkerDO();
        BeanUtils.copyProperties(dto, siteWorkerDO, SiteWorkerDO.class);
        return siteWorkerMapper.updateById(siteWorkerDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteWorkerMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteWorkerDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteWorkerMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteWorkerVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteWorkerDO siteWorkerDO = siteWorkerMapper.selectById(primaryKey);
        return Objects.isNull(siteWorkerDO) ? null :modelMapper.map(siteWorkerDO, SiteWorkerVO.class);
    }

    @Override
    public SiteWorkerVO selectOne(SiteWorkerDTO dto) throws Exception {
        List<SiteWorkerDO> list = siteWorkerMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteWorkerVO.class);
    }

    @Override
    public List<SiteWorkerVO> list(SiteWorkerDTO dto) throws Exception {
        return modelMapper.map(siteWorkerMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteWorkerVO>>() {
        }.getType());
    }

    @Override
    public List<SiteWorkerVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteWorkerMapper.selectBatchIds(ids), new TypeToken<List<SiteWorkerVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteWorkerVO> listByPage(SiteWorkerDTO dto) throws Exception {
        PageInfo<SiteWorkerVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteWorkerDO> doPageInfo = new PageInfo<>(siteWorkerMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteWorkerVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteWorkerDTO dto) throws Exception {
        return siteWorkerMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteWorkerDO> queryWrapper(SiteWorkerDTO dto) {
        QueryWrapper<SiteWorkerDO> query = new QueryWrapper<SiteWorkerDO>();
        query.eq(ObjectUtil.isNotNull(dto.getSeq()), "seq", dto.getSeq());
        query.eq(StrUtil.isNotBlank(dto.getUnitName()), "unit_name", dto.getUnitName());
        query.eq(StrUtil.isNotBlank(dto.getFullName()), "full_name", dto.getFullName());
        query.eq(StrUtil.isNotBlank(dto.getJob()), "job", dto.getJob());
        query.eq(ObjectUtil.isNotNull(dto.getEntryDate()), "entry_date", dto.getEntryDate());
        query.eq(StrUtil.isNotBlank(dto.getIdCard()), "id_card", dto.getIdCard());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getGender()), "gender", dto.getGender());
        query.eq(ObjectUtil.isNotNull(dto.getBirthday()), "birthday", dto.getBirthday());
        query.eq(StrUtil.isNotBlank(dto.getBloodType()), "blood_type", dto.getBloodType());
        query.eq(StrUtil.isNotBlank(dto.getExamine()), "examine", dto.getExamine());
        query.eq(StrUtil.isNotBlank(dto.getPermit()), "permit", dto.getPermit());
        query.eq(StrUtil.isNotBlank(dto.getTrain()), "train", dto.getTrain());
        query.eq(ObjectUtil.isNotNull(dto.getViolationDate()), "violation_date", dto.getViolationDate());
        query.eq(StrUtil.isNotBlank(dto.getViolationCase()), "violation_case", dto.getViolationCase());
        return query;
    }
}