
package com.taiji.site.village.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteVillageDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_village")
public class SiteVillageDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 小区名称
    */
    @TableField(value = "name")
    @ApiModelProperty(value="小区名称")
    private String name;

    /**
    * 小区地址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="小区地址")
    private String address;

    /**
    * 小区所在省份
    */
    @TableField(value = "province")
    @ApiModelProperty(value="小区所在省份")
    private String province;

    /**
    * 小区所在市
    */
    @TableField(value = "market")
    @ApiModelProperty(value="小区所在市")
    private String market;

    /**
    * 小区所在县
    */
    @TableField(value = "county")
    @ApiModelProperty(value="小区所在县")
    private String county;

    /**
    * 小区经度
    */
    @TableField(value = "longitude")
    @ApiModelProperty(value="小区经度")
    private String longitude;

    /**
    * 小区维度
    */
    @TableField(value = "latitude")
    @ApiModelProperty(value="小区维度")
    private String latitude;

    /**
    * 物业名称
    */
    @TableField(value = "property_name")
    @ApiModelProperty(value="物业名称")
    private String propertyName;

    /**
    * 社区id
    */
    @TableField(value = "community_id")
    @ApiModelProperty(value="社区id")
    private String communityId;

    /**
    * 小区描述
    */
    @TableField(value = "village_describe")
    @ApiModelProperty(value="小区描述")
    private String villageDescribe;

}
