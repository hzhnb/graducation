
package com.taiji.site.building.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteBuildingDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_building")
public class SiteBuildingDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 楼号
    */
    @TableField(value = "number")
    @ApiModelProperty(value="楼号")
    private String number;

    /**
    * 楼层数
    */
    @TableField(value = "floor")
    @ApiModelProperty(value="楼层数")
    private String floor;

    /**
    * 户数
    */
    @TableField(value = "households_number")
    @ApiModelProperty(value="户数")
    private String householdsNumber;

    /**
    * 小区id
    */
    @TableField(value = "village_id")
    @ApiModelProperty(value="小区id")
    private String villageId;

}
