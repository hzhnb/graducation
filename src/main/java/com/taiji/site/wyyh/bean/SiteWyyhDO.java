
package com.taiji.site.wyyh.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteWyyhDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_wyyh")
public class SiteWyyhDO extends BaseDO{

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
    * 性别
    */
    @TableField(value = "sex")
    @ApiModelProperty(value="性别")
    private String sex;

    /**
    * 年龄
    */
    @TableField(value = "age")
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
    * 职业
    */
    @TableField(value = "profession")
    @ApiModelProperty(value="职业")
    private String profession;

}
