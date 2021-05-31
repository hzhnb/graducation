
package com.taiji.site.communityAdm;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.taiji.eap.web.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(description="业务模型实体类",value = "SiteCommunityAdministratorDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteCommunityAdministratorDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 性别
    */
    @NotBlank(message = "性别不能为空")
    @Excel(name = "性别",width=40)
    @ApiModelProperty(value="性别")
    private String gender;

    /**
    * 出生日期
    */
    @NotNull(message = "出生日期不能为空")
    @Excel(name = "出生日期",width=40)
    @ApiModelProperty(value="出生日期")
    private Date birth;

    /**
    * 电话
    */
    @NotBlank(message = "电话不能为空")
    @Excel(name = "电话",width=40)
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 邮箱
    */
    @NotBlank(message = "邮箱不能为空")
    @Excel(name = "邮箱",width=40)
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 住址
    */
    @NotBlank(message = "住址不能为空")
    @Excel(name = "住址",width=40)
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 姓名
    */
    @NotBlank(message = "姓名不能为空")
    @Excel(name = "姓名",width=40)
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 职位
    */
    @NotBlank(message = "职位不能为空")
    @Excel(name = "职位",width=40)
    @ApiModelProperty(value="职位")
    private String position;

    /**
    * user表的id
    */
    @NotBlank(message = "user表的id不能为空")
    @Excel(name = "user表的id",width=40)
    @ApiModelProperty(value="user表的id")
    private String userId;

    /**
    * 社区表的id
    */
    @NotBlank(message = "社区表的id不能为空")
    @Excel(name = "社区表的id",width=40)
    @ApiModelProperty(value="社区表的id")
    private String communityId;

}
