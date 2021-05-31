
package com.taiji.site.onDuty;

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

@ApiModel(description="业务模型实体类",value = "SiteOnDutyDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteOnDutyDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 时间
    */
    @NotNull(message = "时间不能为空")
    @Excel(name = "时间",width=40)
    @ApiModelProperty(value="时间")
    private Date time;

    /**
    * 任务
    */
    @NotBlank(message = "任务不能为空")
    @Excel(name = "任务",width=40)
    @ApiModelProperty(value="任务")
    private String mission;

    /**
    * 开始时间
    */
    @NotNull(message = "开始时间不能为空")
    @Excel(name = "开始时间",width=40)
    @ApiModelProperty(value="开始时间")
    private Date startTime;

    /**
    * 结束时间
    */
    @NotNull(message = "结束时间不能为空")
    @Excel(name = "结束时间",width=40)
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    /**
    * 社区管理员id
    */
    @NotBlank(message = "社区管理员id不能为空")
    @Excel(name = "社区管理员id",width=40)
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;

    /**
    * 小区id
    */
    @NotBlank(message = "小区id不能为空")
    @Excel(name = "小区id",width=40)
    @ApiModelProperty(value="小区id")
    private String villageId;

}
