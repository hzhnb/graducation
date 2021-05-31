package com.taiji.site.riskArea.dao;

import com.taiji.eap.orm.base.BaseMapper;
import com.taiji.site.riskArea.bean.SiteRiskAreaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface SiteRiskAreaMapper extends BaseMapper<SiteRiskAreaDO>{
    List<Map<String,Integer>> grade();


}