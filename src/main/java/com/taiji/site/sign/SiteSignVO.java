
package com.taiji.site.sign;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteSignVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteSignVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 居民体温
    */
    @ApiModelProperty(value="居民体温")
    private String temperature;
    /**
    * 是否去过中高风险地区
    */
    @Dictionary(dataSource = "baseEnumDict",params = "YesNo",fieldName = "isGetDesc")
    @ApiModelProperty(value="是否去过中高风险地区")
    private String isGet;
    private String isGetDesc;
    /**
    * 状态
    */
    @Dictionary(dataSource = "sysDictionary",params = "1393052107770265601",fieldName = "stateDesc")
    @ApiModelProperty(value="状态")
    private String state;
    private String stateDesc;
    /**
    * 是否接触过确证患者
    */
    @Dictionary(dataSource = "baseEnumDict",params = "YesNo",fieldName = "isContactDesc")
    @ApiModelProperty(value="是否接触过确证患者")
    private String isContact;
    private String isContactDesc;
    /**
    * 打卡日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="打卡日期")
    private Date time;

}
