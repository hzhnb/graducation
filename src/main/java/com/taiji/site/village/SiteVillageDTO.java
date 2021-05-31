
package com.taiji.site.village;

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

@ApiModel(description="业务模型实体类",value = "SiteVillageDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteVillageDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 小区名称
    */
    @NotBlank(message = "小区名称不能为空")
    @Excel(name = "小区名称",width=40)
    @ApiModelProperty(value="小区名称")
    private String name;

    /**
    * 小区地址
    */
    @NotBlank(message = "小区地址不能为空")
    @Excel(name = "小区地址",width=40)
    @ApiModelProperty(value="小区地址")
    private String address;

    /**
    * 小区所在省份
    */
    @NotBlank(message = "小区所在省份不能为空")
    @Excel(name = "小区所在省份",width=40)
    @ApiModelProperty(value="小区所在省份")
    private String province;

    /**
    * 小区所在市
    */
    @NotBlank(message = "小区所在市不能为空")
    @Excel(name = "小区所在市",width=40)
    @ApiModelProperty(value="小区所在市")
    private String market;

    /**
    * 小区所在县
    */
    @NotBlank(message = "小区所在县不能为空")
    @Excel(name = "小区所在县",width=40)
    @ApiModelProperty(value="小区所在县")
    private String county;

    /**
    * 小区经度
    */
    @NotBlank(message = "小区经度不能为空")
    @Excel(name = "小区经度",width=40)
    @ApiModelProperty(value="小区经度")
    private String longitude;

    /**
    * 小区维度
    */
    @NotBlank(message = "小区维度不能为空")
    @Excel(name = "小区维度",width=40)
    @ApiModelProperty(value="小区维度")
    private String latitude;

    /**
    * 物业名称
    */
    @NotBlank(message = "物业名称不能为空")
    @Excel(name = "物业名称",width=40)
    @ApiModelProperty(value="物业名称")
    private String propertyName;

    /**
    * 社区id
    */
    @NotBlank(message = "社区id不能为空")
    @Excel(name = "社区id",width=40)
    @ApiModelProperty(value="社区id")
    private String communityId;

    /**
    * 小区描述
    */
    @NotBlank(message = "小区描述不能为空")
    @Excel(name = "小区描述",width=40)
    @ApiModelProperty(value="小区描述")
    private String villageDescribe;

}
