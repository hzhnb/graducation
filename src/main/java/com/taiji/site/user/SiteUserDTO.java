
package com.taiji.site.user;

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

@ApiModel(description="业务模型实体类",value = "SiteUserDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUserDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 姓名
    */
    @NotBlank(message = "姓名不能为空")
    @Excel(name = "姓名",width=40)
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 创建时间
    */
    @Excel(name = "创建时间",width=40)
    @ApiModelProperty(value="创建时间")
    private Date createdTime;

    /**
    * 创建者
    */
    @NotBlank(message = "创建者不能为空")
    @Excel(name = "创建者",width=40)
    @ApiModelProperty(value="创建者")
    private String createdBy;

    /**
    * 更新时间
    */
    @NotNull(message = "更新时间不能为空")
    @Excel(name = "更新时间",width=40)
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;

    /**
    * 更新者
    */
    @NotBlank(message = "更新者不能为空")
    @Excel(name = "更新者",width=40)
    @ApiModelProperty(value="更新者")
    private String updatedBy;

}
