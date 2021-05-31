
package com.taiji.site.building;

import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteBuildingVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteBuildingVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 楼号
    */
    @ApiModelProperty(value="楼号")
    private String number;
    /**
    * 楼层数
    */
    @ApiModelProperty(value="楼层数")
    private String floor;
    /**
    * 户数
    */
    @ApiModelProperty(value="户数")
    private String householdsNumber;
    /**
    * 小区id
    */
    @ApiModelProperty(value="小区id")
    private String villageId;

}
