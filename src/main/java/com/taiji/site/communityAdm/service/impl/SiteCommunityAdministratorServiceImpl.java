package com.taiji.site.communityAdm.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiji.site.communityAdm.SiteCommunityAdministratorVO;
import com.taiji.site.communityAdm.bean.SiteCommunityAdministratorDO;
import com.taiji.site.communityAdm.dao.SiteCommunityAdministratorMapper;
import com.taiji.site.communityAdm.service.SiteCommunityAdministratorService;
import com.taiji.site.communityAdm.SiteCommunityAdministratorDTO;
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
public class SiteCommunityAdministratorServiceImpl extends BaseServiceImpl  implements SiteCommunityAdministratorService{

    @Autowired
    private SiteCommunityAdministratorMapper siteCommunityAdministratorMapper;

    @Override
    public boolean insert(SiteCommunityAdministratorDTO dto) throws Exception {
        //DTO转DO
        SiteCommunityAdministratorDO siteCommunityAdministratorDO = new SiteCommunityAdministratorDO();
        BeanUtils.copyProperties(dto, siteCommunityAdministratorDO, SiteCommunityAdministratorDO.class);
        return siteCommunityAdministratorMapper.insert(siteCommunityAdministratorDO) > 0 ;
    }

    @Override
    public boolean insertBatch(List<SiteCommunityAdministratorDTO> list) throws Exception {
        List<SiteCommunityAdministratorDO> doList = modelMapper.map(list, new TypeToken<List<SiteCommunityAdministratorDO>>() {
        }.getType());
        return siteCommunityAdministratorMapper.insertBatch(doList) > 0 ;
    }

    @Override
    public boolean updateByPrimaryKey(SiteCommunityAdministratorDTO dto) throws Exception {
        SiteCommunityAdministratorDO siteCommunityAdministratorDO = new SiteCommunityAdministratorDO();
        BeanUtils.copyProperties(dto, siteCommunityAdministratorDO, SiteCommunityAdministratorDO.class);
        return siteCommunityAdministratorMapper.updateById(siteCommunityAdministratorDO) > 0 ;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) throws Exception {
        return siteCommunityAdministratorMapper.deleteById(primaryKey) > 0 ;
    }

    @Override
    public boolean deleteSelective(SiteCommunityAdministratorDTO dto) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //自行设置参数,map的key为数据库字段名,value为dto的属性值


        return siteCommunityAdministratorMapper.deleteByMap(checkMapValue(map)) > 0 ;
    }

    @Override
    public SiteCommunityAdministratorVO selectByPrimaryKey(String primaryKey) throws Exception {
        SiteCommunityAdministratorDO siteCommunityAdministratorDO = siteCommunityAdministratorMapper.selectById(primaryKey);
        return Objects.isNull(siteCommunityAdministratorDO) ? null :modelMapper.map(siteCommunityAdministratorDO, SiteCommunityAdministratorVO.class);
    }

    @Override
    public SiteCommunityAdministratorVO selectOne(SiteCommunityAdministratorDTO dto) throws Exception {
        List<SiteCommunityAdministratorDO> list = siteCommunityAdministratorMapper.selectList(this.queryWrapper(dto));
        if (list.size() > 1) {
            log.error("selectOne 查出{}数据, param is {}", list.size(), dto);
        }
        return list.size() <= 0 ? null : modelMapper.map(list.get(0), SiteCommunityAdministratorVO.class);
    }

    @Override
    public List<SiteCommunityAdministratorVO> list(SiteCommunityAdministratorDTO dto) throws Exception {
        return modelMapper.map(siteCommunityAdministratorMapper.selectList(this.queryWrapper(dto)), new TypeToken<List<SiteCommunityAdministratorVO>>() {
        }.getType());
    }

    @Override
    public List<SiteCommunityAdministratorVO> listByIds(List<String> ids) throws Exception {
        return modelMapper.map(siteCommunityAdministratorMapper.selectBatchIds(ids), new TypeToken<List<SiteCommunityAdministratorVO>>() {
        }.getType());
    }

    @Override
    public PageInfo<SiteCommunityAdministratorVO> listByPage(SiteCommunityAdministratorDTO dto) throws Exception {
        PageInfo<SiteCommunityAdministratorVO> pageInfo = new PageInfo<>();
        //分页+排序
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize(), dto.getOrders());
        PageInfo<SiteCommunityAdministratorDO> doPageInfo = new PageInfo<>(siteCommunityAdministratorMapper.selectList(this.queryWrapper(dto)));
        PageUtil.copyProperties(doPageInfo,pageInfo);
        pageInfo.setList(modelMapper.map(doPageInfo.getList(), new TypeToken<List<SiteCommunityAdministratorVO>>() {
        }.getType()));
        return pageInfo;
    }

    @Override
    public int count(SiteCommunityAdministratorDTO dto) throws Exception {
        return siteCommunityAdministratorMapper.selectCount(this.queryWrapper(dto));
    }

    //===============================查询条件构造器============================

    private QueryWrapper<SiteCommunityAdministratorDO> queryWrapper(SiteCommunityAdministratorDTO dto) {
        QueryWrapper<SiteCommunityAdministratorDO> query = new QueryWrapper<SiteCommunityAdministratorDO>();
        query.eq(StrUtil.isNotBlank(dto.getGender()), "gender", dto.getGender());
        query.eq(ObjectUtil.isNotNull(dto.getBirth()), "birth", dto.getBirth());
        query.eq(StrUtil.isNotBlank(dto.getPhone()), "phone", dto.getPhone());
        query.eq(StrUtil.isNotBlank(dto.getEmail()), "email", dto.getEmail());
        query.eq(StrUtil.isNotBlank(dto.getAddress()), "address", dto.getAddress());
        query.eq(StrUtil.isNotBlank(dto.getName()), "name", dto.getName());
        query.eq(StrUtil.isNotBlank(dto.getPosition()), "position", dto.getPosition());
        query.eq(StrUtil.isNotBlank(dto.getUserId()), "user_id", dto.getUserId());
        query.eq(StrUtil.isNotBlank(dto.getCommunityId()), "community_id", dto.getCommunityId());
        return query;
    }
}