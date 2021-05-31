
package com.taiji.site.building;

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

@ApiModel(description="业务模型实体类",value = "SiteBuildingDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteBuildingDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 楼号
    */
    @NotBlank(message = "楼号不能为空")
    @Excel(name = "楼号",width=40)
    @ApiModelProperty(value="楼号")
    private String number;

    /**
    * 楼层数
    */
    @NotBlank(message = "楼层数不能为空")
    @Excel(name = "楼层数",width=40)
    @ApiModelProperty(value="楼层数")
    private String floor;

    /**
    * 户数
    */
    @NotBlank(message = "户数不能为空")
    @Excel(name = "户数",width=40)
    @ApiModelProperty(value="户数")
    private String householdsNumber;

    /**
    * 小区id
    */
    @NotBlank(message = "小区id不能为空")
    @Excel(name = "小区id",width=40)
    @ApiModelProperty(value="小区id")
    private String villageId;

}
