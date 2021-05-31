
package com.taiji.site.residentUser.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteResidentDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_resident")
public class SiteResidentDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 居民邮箱
    */
    @TableField(value = "email")
    @ApiModelProperty(value="居民邮箱")
    private String email;

    /**
    * 居民住址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="居民住址")
    private String address;

    /**
    * 居民性别
    */
    @TableField(value = "gender")
    @ApiModelProperty(value="居民性别")
    private String gender;

    /**
    * 居民身份证号码
    */
    @TableField(value = "idcare")
    @ApiModelProperty(value="居民身份证号码")
    private String idcare;

    /**
    * 电话
    */
    @TableField(value = "phone")
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 出生日期
    */
    @TableField(value = "birth")
    @ApiModelProperty(value="出生日期")
    private Date birth;

    /**
    * user表的id
    */
    @TableField(value = "user_id")
    @ApiModelProperty(value="user表的id")
    private String userId;

    /**
    * 社区的id
    */
    @TableField(value = "community_id")
    @ApiModelProperty(value="社区的id")
    private String communityId;

    /**
    * 小区的id
    */
    @TableField(value = "village_id")
    @ApiModelProperty(value="小区的id")
    private String villageId;

    /**
    * 楼宇的id
    */
    @TableField(value = "building_id")
    @ApiModelProperty(value="楼宇的id")
    private String buildingId;

    /**
    * 房间号
    */
    @TableField(value = "room_number")
    @ApiModelProperty(value="房间号")
    private String roomNumber;

}
