
package com.taiji.site.register.bean;

import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteRegisterVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteRegisterVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 工人ID
    */
    @ApiModelProperty(value="工人ID")
    private String workerId;
    /**
    * 登记人
    */
    @ApiModelProperty(value="登记人")
    private String registrant;
    /**
    * 登记时间
    */
    @ApiModelProperty(value="登记时间")
    private Date registerTime;
    /**
    * 登记类型
    */
    @ApiModelProperty(value="登记类型")
    private String registerType;
    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

}
