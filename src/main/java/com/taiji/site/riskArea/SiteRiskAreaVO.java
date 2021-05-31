
package com.taiji.site.riskArea;

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

@ApiModel(description="表现层实体类",value = "SiteRiskAreaVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRiskAreaVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 风险地区等级
    */
    @Dictionary(dataSource = "sysDictionary",params = "1393035866053550081",fieldName = "gradeDesc")
    @ApiModelProperty(value="风险地区等级")
    private String grade;
    private String gradeDesc;
    /**
    * 风险地区地址
    */
    @ApiModelProperty(value="风险地区地址")
    private String address;
    /**
    * 风险地区经度
    */
    @ApiModelProperty(value="风险地区经度")
    private String longitude;
    /**
    * 风险地区纬度
    */
    @ApiModelProperty(value="风险地区纬度")
    private String latitude;
    /**
    * 风险地区所在省份
    */
    @Dictionary(dataSource = "sysArea",params = "1",fieldName = "provinceDesc")
    @ApiModelProperty(value="风险地区所在省份")
    private String province;
    private String provinceDesc;
    /**
    * 风险地区所在市
    */
    @Dictionary(dataSource = "sysArea",params = "2",fieldName = "marketDesc")
    @ApiModelProperty(value="风险地区所在市")
    private String market;
    private String marketDesc;
    /**
    * 风险地区所在县
    */
    @Dictionary(dataSource = "sysArea",params = "3",fieldName = "countyDesc")
    @ApiModelProperty(value="风险地区所在县")
    private String county;
    private String countyDesc;
    /**
    * 风险地区开始时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="风险地区开始时间")
    private Date startTime;

}
