
package com.taiji.site.sign;

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

@ApiModel(description="业务模型实体类",value = "SiteSignDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteSignDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 居民体温
    */
    @NotBlank(message = "居民体温不能为空")
    @Excel(name = "居民体温",width=40)
    @ApiModelProperty(value="居民体温")
    private String temperature;

    /**
    * 是否去过中高风险地区
    */
    @NotBlank(message = "是否去过中高风险地区不能为空")
    @Excel(name = "是否去过中高风险地区",width=40)
    @ApiModelProperty(value="是否去过中高风险地区")
    private String isGet;

    /**
    * 状态
    */
    @NotBlank(message = "状态不能为空")
    @Excel(name = "状态",width=40)
    @ApiModelProperty(value="状态")
    private String state;

    /**
    * 是否接触过确证患者
    */
    @NotBlank(message = "是否接触过确证患者不能为空")
    @Excel(name = "是否接触过确证患者",width=40)
    @ApiModelProperty(value="是否接触过确证患者")
    private String isContact;

    /**
    * 打卡日期
    */
    @NotNull(message = "打卡日期不能为空")
    @Excel(name = "打卡日期",width=40)
    @ApiModelProperty(value="打卡日期")
    private Date time;

}
