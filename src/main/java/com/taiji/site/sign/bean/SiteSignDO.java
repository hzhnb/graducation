
package com.taiji.site.sign.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteSignDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_sign")
public class SiteSignDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 居民体温
    */
    @TableField(value = "temperature")
    @ApiModelProperty(value="居民体温")
    private String temperature;

    /**
    * 是否去过中高风险地区
    */
    @TableField(value = "is_get")
    @ApiModelProperty(value="是否去过中高风险地区")
    private String isGet;

    /**
    * 状态
    */
    @TableField(value = "state")
    @ApiModelProperty(value="状态")
    private String state;

    /**
    * 是否接触过确证患者
    */
    @TableField(value = "is_contact")
    @ApiModelProperty(value="是否接触过确证患者")
    private String isContact;

    /**
    * 打卡日期
    */
    @TableField(value = "time")
    @ApiModelProperty(value="打卡日期")
    private Date time;

}
