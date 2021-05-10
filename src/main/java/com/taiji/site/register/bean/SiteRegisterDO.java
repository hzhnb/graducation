
package com.taiji.site.register.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteRegisterDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_register")
public class SiteRegisterDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 工人ID
    */
    @TableField(value = "worker_id")
    @ApiModelProperty(value="工人ID")
    private String workerId;

    /**
    * 登记人
    */
    @TableField(value = "registrant")
    @ApiModelProperty(value="登记人")
    private String registrant;

    /**
    * 登记时间
    */
    @TableField(value = "register_time")
    @ApiModelProperty(value="登记时间")
    private Date registerTime;

    /**
    * 登记类型
    */
    @TableField(value = "register_type")
    @ApiModelProperty(value="登记类型")
    private String registerType;

    /**
    * 备注
    */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

}
