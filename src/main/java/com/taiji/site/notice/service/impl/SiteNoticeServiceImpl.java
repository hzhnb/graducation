package com.taiji.site.notice.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.notice.SiteNoticeVO;
import com.taiji.site.notice.bean.SiteNoticeDO;
import com.taiji.site.notice.dao.SiteNoticeMapper;
import com.taiji.site.notice.service.SiteNoticeService;
import com.taiji.site.notice.SiteNoticeDTO;
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
public class SiteNoticeServiceImpl extends BaseServiceImpl  implements SiteNoticeService{

    @Autowired
    private SiteNoticeMapper siteNoticeMapper;

    @Override
    public boolean insert(SiteNoticeDTO dto) throws Exception {
        //DTO转DO
        SiteNoticeDO siteNoticeDO = new SiteNoticeDO();
        BeanUtils.copyProperties(dto, siteNoticeDO, SiteNoticeDO.class);
        return siteNoticeMapper.insert(siteNoticeDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteNoticeDTO> list) throws Exception {
        List<SiteNoticeDO> doList = modelMapper.map(list, new TypeToken<List<SiteNoticeDO>>() {
        }.getType());
        return siteNoticeMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteNoticeDTO dto) throws Exception {
        SiteNoticeDO siteNoticeDO = new SiteNoticeDO();
        BeanUtils.copyProperties(dto, siteNoticeDO, SiteNoticeDO.class);
        return siteNoticeMapper.updateById(siteNoticeDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteNoticeMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteNoticeDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteNoticeMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteNoticeVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteNoticeDO siteNoticeDO = siteNoticeMapper.selectById(primaryKey);
        return Objects.isNull(siteNoticeDO) ? null :modelMapper.map(siteNoticeDO, SiteNoticeVO.class);
    }

    @Override
    public SiteNoticeVO selectOne(SiteNoticeDTO dto) throws Exception {
        List<SiteNoticeDO> list = siteNoticeMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteNoticeVO.class);
    }

    @Override
    public List<SiteNoticeVO> list(SiteNoticeDTO dto) throws Exception {
        return modelMapper.map(siteNoticeMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteNoticeVO>>() {
        }.getType());
    }

    @Override
    public List<SiteNoticeVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteNoticeMapper.selectBatchIds(ids), new TypeToken<List<SiteNoticeVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteNoticeVO> listByPage(SiteNoticeDTO dto) throws Exception {
        PageInfo<SiteNoticeVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteNoticeDO> doPageInfo = new PageInfo<>(siteNoticeMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteNoticeVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteNoticeDTO dto) throws Exception {
        return siteNoticeMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteNoticeDO> queryWrapper(SiteNoticeDTO dto) {
        QueryWrapper<SiteNoticeDO> query = new QueryWrapper<SiteNoticeDO>();
        query.eq(StrUtil.isNotBlank(dto.getType()), "type", dto.getType());
        query.eq(StrUtil.isNotBlank(dto.getContent()), "content", dto.getContent());
        query.eq(ObjectUtil.isNotNull(dto.getTime()), "time", dto.getTime());
        query.eq(StrUtil.isNotBlank(dto.getTitle()), "title", dto.getTitle());
        query.eq(StrUtil.isNotBlank(dto.getFileId()), "file_id", dto.getFileId());
        return query;
    }
}