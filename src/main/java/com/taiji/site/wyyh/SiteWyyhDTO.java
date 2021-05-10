
package com.taiji.site.wyyh;

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

@ApiModel(description="业务模型实体类",value = "SiteWyyhDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteWyyhDTO extends BaseDTO{

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
    * 性别
    */
    @NotBlank(message = "性别不能为空")
    @Excel(name = "性别",width=40)
    @ApiModelProperty(value="性别")
    private String sex;

    /**
    * 年龄
    */
    @NotNull(message = "年龄不能为空")
    @Excel(name = "年龄",width=40)
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
    * 职业
    */
    @NotBlank(message = "职业不能为空")
    @Excel(name = "职业",width=40)
    @ApiModelProperty(value="职业")
    private String profession;

}
