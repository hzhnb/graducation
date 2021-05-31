
package com.taiji.site.onDuty.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteOnDutyDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_on_duty")
public class SiteOnDutyDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 时间
    */
    @TableField(value = "time")
    @ApiModelProperty(value="时间")
    private Date time;

    /**
    * 任务
    */
    @TableField(value = "mission")
    @ApiModelProperty(value="任务")
    private String mission;

    /**
    * 开始时间
    */
    @TableField(value = "start_time")
    @ApiModelProperty(value="开始时间")
    private Date startTime;

    /**
    * 结束时间
    */
    @TableField(value = "end_time")
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    /**
    * 社区管理员id
    */
    @TableField(value = "administrator_id")
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;

    /**
    * 小区id
    */
    @TableField(value = "village_id")
    @ApiModelProperty(value="小区id")
    private String villageId;

}
