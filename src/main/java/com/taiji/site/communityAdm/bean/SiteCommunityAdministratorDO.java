
package com.taiji.site.communityAdm.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteCommunityAdministratorDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_community_administrator")
public class SiteCommunityAdministratorDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 性别
    */
    @TableField(value = "gender")
    @ApiModelProperty(value="性别")
    private String gender;

    /**
    * 出生日期
    */
    @TableField(value = "birth")
    @ApiModelProperty(value="出生日期")
    private Date birth;

    /**
    * 电话
    */
    @TableField(value = "phone")
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 邮箱
    */
    @TableField(value = "email")
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 住址
    */
    @TableField(value = "address")
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 姓名
    */
    @TableField(value = "name")
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 职位
    */
    @TableField(value = "position")
    @ApiModelProperty(value="职位")
    private String position;

    /**
    * user表的id
    */
    @TableField(value = "user_id")
    @ApiModelProperty(value="user表的id")
    private String userId;

    /**
    * 社区表的id
    */
    @TableField(value = "community_id")
    @ApiModelProperty(value="社区表的id")
    private String communityId;

}
