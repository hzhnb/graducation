
package com.taiji.site.community;

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

@ApiModel(description="业务模型实体类",value = "SiteCommunityDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteCommunityDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 社区名称
    */
    @NotBlank(message = "社区名称不能为空")
    @Excel(name = "社区名称",width=40)
    @ApiModelProperty(value="社区名称")
    private String name;

    /**
    * 社区地址
    */
    @NotBlank(message = "社区地址不能为空")
    @Excel(name = "社区地址",width=40)
    @ApiModelProperty(value="社区地址")
    private String address;

    /**
    * 社区所在省份
    */
    @NotBlank(message = "社区所在省份不能为空")
    @Excel(name = "社区所在省份",width=40)
    @ApiModelProperty(value="社区所在省份")
    private String province;

    /**
    * 社区所在市
    */
    @NotBlank(message = "社区所在市不能为空")
    @Excel(name = "社区所在市",width=40)
    @ApiModelProperty(value="社区所在市")
    private String market;

    /**
    * 社区所在县
    */
    @NotBlank(message = "社区所在县不能为空")
    @Excel(name = "社区所在县",width=40)
    @ApiModelProperty(value="社区所在县")
    private String county;

    /**
    * 社区经度
    */
    @NotBlank(message = "社区经度不能为空")
    @Excel(name = "社区经度",width=40)
    @ApiModelProperty(value="社区经度")
    private String longitude;

    /**
    * 社区纬度
    */
    @NotBlank(message = "社区纬度不能为空")
    @Excel(name = "社区纬度",width=40)
    @ApiModelProperty(value="社区纬度")
    private String latitude;

}
