package com.taiji.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.taiji"})
@MapperScan({"com.taiji.**.dao"})
public class SiteApplication {

    public static void main(String[] args) {
        //禁用nacos日志服务
        // 原因：Context has been already given a name nacos，
        // 出处：https://github.com/alibaba/nacos/issues/1959
        System.setProperty("nacos.logging.default.config.enabled", "false");

        SpringApplication.run(SiteApplication.class, args);
    }

}
