package com.taiji.site.noticeRecord.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.noticeRecord.SiteNoticeRecordVO;
import com.taiji.site.noticeRecord.bean.SiteNoticeRecordDO;
import com.taiji.site.noticeRecord.dao.SiteNoticeRecordMapper;
import com.taiji.site.noticeRecord.service.SiteNoticeRecordService;
import com.taiji.site.noticeRecord.SiteNoticeRecordDTO;
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
public class SiteNoticeRecordServiceImpl extends BaseServiceImpl  implements SiteNoticeRecordService{

    @Autowired
    private SiteNoticeRecordMapper siteNoticeRecordMapper;

    @Override
    public boolean insert(SiteNoticeRecordDTO dto) throws Exception {
        //DTO转DO
        SiteNoticeRecordDO siteNoticeRecordDO = new SiteNoticeRecordDO();
        BeanUtils.copyProperties(dto, siteNoticeRecordDO, SiteNoticeRecordDO.class);
        return siteNoticeRecordMapper.insert(siteNoticeRecordDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteNoticeRecordDTO> list) throws Exception {
        List<SiteNoticeRecordDO> doList = modelMapper.map(list, new TypeToken<List<SiteNoticeRecordDO>>() {
        }.getType());
        return siteNoticeRecordMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteNoticeRecordDTO dto) throws Exception {
        SiteNoticeRecordDO siteNoticeRecordDO = new SiteNoticeRecordDO();
        BeanUtils.copyProperties(dto, siteNoticeRecordDO, SiteNoticeRecordDO.class);
        return siteNoticeRecordMapper.updateById(siteNoticeRecordDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteNoticeRecordMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteNoticeRecordDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteNoticeRecordMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteNoticeRecordVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteNoticeRecordDO siteNoticeRecordDO = siteNoticeRecordMapper.selectById(primaryKey);
        return Objects.isNull(siteNoticeRecordDO) ? null :modelMapper.map(siteNoticeRecordDO, SiteNoticeRecordVO.class);
    }

    @Override
    public SiteNoticeRecordVO selectOne(SiteNoticeRecordDTO dto) throws Exception {
        List<SiteNoticeRecordDO> list = siteNoticeRecordMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteNoticeRecordVO.class);
    }

    @Override
    public List<SiteNoticeRecordVO> list(SiteNoticeRecordDTO dto) throws Exception {
        return modelMapper.map(siteNoticeRecordMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteNoticeRecordVO>>() {
        }.getType());
    }

    @Override
    public List<SiteNoticeRecordVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteNoticeRecordMapper.selectBatchIds(ids), new TypeToken<List<SiteNoticeRecordVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteNoticeRecordVO> listByPage(SiteNoticeRecordDTO dto) throws Exception {
        PageInfo<SiteNoticeRecordVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteNoticeRecordDO> doPageInfo = new PageInfo<>(siteNoticeRecordMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteNoticeRecordVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteNoticeRecordDTO dto) throws Exception {
        return siteNoticeRecordMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteNoticeRecordDO> queryWrapper(SiteNoticeRecordDTO dto) {
        QueryWrapper<SiteNoticeRecordDO> query = new QueryWrapper<SiteNoticeRecordDO>();
        query.eq(StrUtil.isNotBlank(dto.getIsRead()), "is_read", dto.getIsRead());
        query.eq(StrUtil.isNotBlank(dto.getNoticeId()), "notice_id", dto.getNoticeId());
        query.eq(StrUtil.isNotBlank(dto.getAdministratorId()), "administrator_id", dto.getAdministratorId());
        return query;
    }
}