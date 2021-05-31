package com.taiji.site.riskArea.service;

import com.taiji.eap.web.base.BaseService;
import com.taiji.site.riskArea.SiteRiskAreaVO;
import com.taiji.site.riskArea.SiteRiskAreaDTO;

import java.util.List;
import java.util.Map;

public interface SiteRiskAreaService extends BaseService<SiteRiskAreaDTO,SiteRiskAreaVO>{
    List<Map<String,Integer>> grade();
}