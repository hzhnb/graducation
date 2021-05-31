package com.taiji.site.system;

import com.taiji.eap.web.base.BaseController;
import com.taiji.site.riskArea.service.SiteRiskAreaService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 跳转页面controller,父类提供了公共的跳转方法
 * Created by shijq on 2020/12/25 12:56
 */
@Controller
@Slf4j
@Api(value = "跳转路径controller", tags = {"跳转路径controller"})
public class ToViewController extends BaseController {
    @Autowired
    private SiteRiskAreaService siteRiskAreaService;

    @GetMapping({""})
    public ModelAndView home() {
        String path = "/site/home";
        return this.toView(path, new HashMap<>());
    }
    @GetMapping({"/toLogin"})
    public ModelAndView login() {
        String path = "/site/login";
        return this.toView(path, new HashMap<>());
    }


}
