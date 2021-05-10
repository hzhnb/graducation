
package com.taiji.site.wyyh;

import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteWyyhVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteWyyhVO extends BaseVO{



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
    * 性别
    */
    @ApiModelProperty(value="性别")
    private String sex;
    /**
    * 年龄
    */
    @ApiModelProperty(value="年龄")
    private Integer age;
    /**
    * 职业
    */
    @ApiModelProperty(value="职业")
    private String profession;

}
