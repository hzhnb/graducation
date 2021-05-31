
package com.taiji.site.community.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteCommunityDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_community")
public class SiteCommunityDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 社区名称
    */
    @TableField(value = "name")
    @ApiModelProperty(value="社区名称")
    private String name;

    /**
    * 社区地址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="社区地址")
    private String address;

    /**
    * 社区所在省份
    */
    @TableField(value = "province")
    @ApiModelProperty(value="社区所在省份")
    private String province;

    /**
    * 社区所在市
    */
    @TableField(value = "market")
    @ApiModelProperty(value="社区所在市")
    private String market;

    /**
    * 社区所在县
    */
    @TableField(value = "county")
    @ApiModelProperty(value="社区所在县")
    private String county;

    /**
    * 社区经度
    */
    @TableField(value = "longitude")
    @ApiModelProperty(value="社区经度")
    private String longitude;

    /**
    * 社区纬度
    */
    @TableField(value = "latitude")
    @ApiModelProperty(value="社区纬度")
    private String latitude;

}
