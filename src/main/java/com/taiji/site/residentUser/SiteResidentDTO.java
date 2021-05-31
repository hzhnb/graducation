
package com.taiji.site.residentUser;

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

@ApiModel(description="业务模型实体类",value = "SiteResidentDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteResidentDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 居民邮箱
    */
    @NotBlank(message = "居民邮箱不能为空")
    @Excel(name = "居民邮箱",width=40)
    @ApiModelProperty(value="居民邮箱")
    private String email;

    /**
    * 居民住址
    */
    @NotBlank(message = "居民住址不能为空")
    @Excel(name = "居民住址",width=40)
    @ApiModelProperty(value="居民住址")
    private String address;

    /**
    * 居民性别
    */
    @NotBlank(message = "居民性别不能为空")
    @Excel(name = "居民性别",width=40)
    @ApiModelProperty(value="居民性别")
    private String gender;

    /**
    * 居民身份证号码
    */
    @NotBlank(message = "居民身份证号码不能为空")
    @Excel(name = "居民身份证号码",width=40)
    @ApiModelProperty(value="居民身份证号码")
    private String idcare;

    /**
    * 电话
    */
    @NotBlank(message = "电话不能为空")
    @Excel(name = "电话",width=40)
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 出生日期
    */
    @NotNull(message = "出生日期不能为空")
    @Excel(name = "出生日期",width=40)
    @ApiModelProperty(value="出生日期")
    private Date birth;

    /**
    * user表的id
    */
    @NotBlank(message = "user表的id不能为空")
    @Excel(name = "user表的id",width=40)
    @ApiModelProperty(value="user表的id")
    private String userId;

    /**
    * 社区的id
    */
    @NotBlank(message = "社区的id不能为空")
    @Excel(name = "社区的id",width=40)
    @ApiModelProperty(value="社区的id")
    private String communityId;

    /**
    * 小区的id
    */
    @NotBlank(message = "小区的id不能为空")
    @Excel(name = "小区的id",width=40)
    @ApiModelProperty(value="小区的id")
    private String villageId;

    /**
    * 楼宇的id
    */
    @NotBlank(message = "楼宇的id不能为空")
    @Excel(name = "楼宇的id",width=40)
    @ApiModelProperty(value="楼宇的id")
    private String buildingId;

    /**
    * 房间号
    */
    @NotBlank(message = "房间号不能为空")
    @Excel(name = "房间号",width=40)
    @ApiModelProperty(value="房间号")
    private String roomNumber;

}
