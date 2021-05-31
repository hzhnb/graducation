
package com.taiji.site.user;

import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteUserVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUserVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    private String name;
    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createdTime;
    /**
    * 创建者
    */
    @ApiModelProperty(value="创建者")
    private String createdBy;
    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;
    /**
    * 更新者
    */
    @ApiModelProperty(value="更新者")
    private String updatedBy;

}
