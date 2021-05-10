
package com.taiji.site.worker.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteWorkerDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_worker")
public class SiteWorkerDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 序号
    */
    @TableField(value = "seq")
    @ApiModelProperty(value="序号")
    private Integer seq;

    /**
    * 施工单位名称
    */
    @TableField(value = "unit_name")
    @ApiModelProperty(value="施工单位名称")
    private String unitName;

    /**
    * 姓名
    */
    @TableField(value = "full_name")
    @ApiModelProperty(value="姓名")
    private String fullName;

    /**
    * 岗位
    */
    @TableField(value = "job")
    @ApiModelProperty(value="岗位")
    private String job;

    /**
    * 进场日期
    */
    @TableField(value = "entry_date")
    @ApiModelProperty(value="进场日期")
    private Date entryDate;

    /**
    * 身份证号码
    */
    @TableField(value = "id_card")
    @ApiModelProperty(value="身份证号码")
    private String idCard;

    /**
    * 住址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 性别
    */
    @TableField(value = "gender")
    @ApiModelProperty(value="性别")
    private String gender;

    /**
    * 出生日期
    */
    @TableField(value = "birthday")
    @ApiModelProperty(value="出生日期")
    private Date birthday;

    /**
    * 血型
    */
    @TableField(value = "blood_type")
    @ApiModelProperty(value="血型")
    private String bloodType;

    /**
    * 体检情况
    */
    @TableField(value = "examine")
    @ApiModelProperty(value="体检情况")
    private String examine;

    /**
    * 持证情况
    */
    @TableField(value = "permit")
    @ApiModelProperty(value="持证情况")
    private String permit;

    /**
    * 培训情况
    */
    @TableField(value = "train")
    @ApiModelProperty(value="培训情况")
    private String train;

    /**
    * 违章时间
    */
    @TableField(value = "violation_date")
    @ApiModelProperty(value="违章时间")
    private Date violationDate;

    /**
    * 违章描述
    */
    @TableField(value = "violation_case")
    @ApiModelProperty(value="违章描述")
    private String violationCase;

}
