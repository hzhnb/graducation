
package com.taiji.site.visitor.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteVisitorDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_visitor")
public class SiteVisitorDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 姓名
    */
    @TableField(value = "name")
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 身份证号
    */
    @TableField(value = "idcare")
    @ApiModelProperty(value="身份证号")
    private String idcare;

    /**
    * 始发地
    */
    @TableField(value = "vfrom")
    @ApiModelProperty(value="始发地")
    private String vfrom;

    /**
    * 住址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 电话
    */
    @TableField(value = "phone")
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 来访时间
    */
    @TableField(value = "time")
    @ApiModelProperty(value="来访时间")
    private Date time;

    /**
    * 居民的id
    */
    @TableField(value = "resident_id")
    @ApiModelProperty(value="居民的id")
    private String residentId;

}
