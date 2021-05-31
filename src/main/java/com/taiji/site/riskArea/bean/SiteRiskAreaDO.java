
package com.taiji.site.riskArea.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.taiji.eap.orm.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="持久化层实体类",value = "SiteRiskAreaDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_risk_area")
public class SiteRiskAreaDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 风险地区等级
    */
    @TableField(value = "grade")
    @ApiModelProperty(value="风险地区等级")
    private String grade;

    /**
    * 风险地区地址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="风险地区地址")
    private String address;

    /**
    * 风险地区经度
    */
    @TableField(value = "longitude")
    @ApiModelProperty(value="风险地区经度")
    private String longitude;

    /**
    * 风险地区纬度
    */
    @TableField(value = "latitude")
    @ApiModelProperty(value="风险地区纬度")
    private String latitude;

    /**
    * 风险地区所在省份
    */
    @TableField(value = "province")
    @ApiModelProperty(value="风险地区所在省份")
    private String province;

    /**
    * 风险地区所在市
    */
    @TableField(value = "market")
    @ApiModelProperty(value="风险地区所在市")
    private String market;

    /**
    * 风险地区所在县
    */
    @TableField(value = "county")
    @ApiModelProperty(value="风险地区所在县")
    private String county;

    /**
    * 风险地区开始时间
    */
    @TableField(value = "start_time")
    @ApiModelProperty(value="风险地区开始时间")
    private Date startTime;

}
