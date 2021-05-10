
package com.taiji.site.register.bean;

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

@ApiModel(description="业务模型实体类",value = "SiteRegisterDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRegisterDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 工人ID
    */
    @NotBlank(message = "工人ID不能为空")
    @Excel(name = "工人ID",width=40)
    @ApiModelProperty(value="工人ID")
    private String workerId;

    /**
    * 登记人
    */
    @NotBlank(message = "登记人不能为空")
    @Excel(name = "登记人",width=40)
    @ApiModelProperty(value="登记人")
    private String registrant;

    /**
    * 登记时间
    */
    @NotNull(message = "登记时间不能为空")
    @Excel(name = "登记时间",width=40)
    @ApiModelProperty(value="登记时间")
    private Date registerTime;

    /**
    * 登记类型
    */
    @NotBlank(message = "登记类型不能为空")
    @Excel(name = "登记类型",width=40)
    @ApiModelProperty(value="登记类型")
    private String registerType;

    /**
    * 备注
    */
    @NotBlank(message = "备注不能为空")
    @Excel(name = "备注",width=40)
    @ApiModelProperty(value="备注")
    private String remark;

}
