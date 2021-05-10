package com.taiji.site.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.taiji.oauth.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

//mp的自动填充实现类
@Slf4j
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    // 插入时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("orgId", UserUtil.getUserInfo().getOrgId(), metaObject);
        this.setFieldValByName("createBy", UserUtil.getUserInfo().getUserId(), metaObject);
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("orgId", UserUtil.getUserInfo().getOrgId(), metaObject);
        this.setFieldValByName("updateBy", UserUtil.getUserInfo().getUserId(), metaObject);
    }
}