
package com.taiji.site.riskArea;

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

@ApiModel(description="业务模型实体类",value = "SiteRiskAreaDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRiskAreaDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 风险地区等级
    */
    @NotBlank(message = "风险地区等级不能为空")
    @Excel(name = "风险地区等级",width=40)
    @ApiModelProperty(value="风险地区等级")
    private String grade;

    /**
    * 风险地区地址
    */
    @NotBlank(message = "风险地区地址不能为空")
    @Excel(name = "风险地区地址",width=40)
    @ApiModelProperty(value="风险地区地址")
    private String address;

    /**
    * 风险地区经度
    */
    @NotBlank(message = "风险地区经度不能为空")
    @Excel(name = "风险地区经度",width=40)
    @ApiModelProperty(value="风险地区经度")
    private String longitude;

    /**
    * 风险地区纬度
    */
    @NotBlank(message = "风险地区纬度不能为空")
    @Excel(name = "风险地区纬度",width=40)
    @ApiModelProperty(value="风险地区纬度")
    private String latitude;

    /**
    * 风险地区所在省份
    */
    @NotBlank(message = "风险地区所在省份不能为空")
    @Excel(name = "风险地区所在省份",width=40)
    @ApiModelProperty(value="风险地区所在省份")
    private String province;

    /**
    * 风险地区所在市
    */
    @NotBlank(message = "风险地区所在市不能为空")
    @Excel(name = "风险地区所在市",width=40)
    @ApiModelProperty(value="风险地区所在市")
    private String market;

    /**
    * 风险地区所在县
    */
    @NotBlank(message = "风险地区所在县不能为空")
    @Excel(name = "风险地区所在县",width=40)
    @ApiModelProperty(value="风险地区所在县")
    private String county;

    /**
    * 风险地区开始时间
    */
    @NotNull(message = "风险地区开始时间不能为空")
    @Excel(name = "风险地区开始时间",width=40)
    @ApiModelProperty(value="风险地区开始时间")
    private Date startTime;

}
