
package com.taiji.site.village;

import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteVillageVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteVillageVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 小区名称
    */
    @ApiModelProperty(value="小区名称")
    private String name;
    /**
    * 小区地址
    */
    @ApiModelProperty(value="小区地址")
    private String address;
    /**
    * 小区所在省份
    */
    @Dictionary(dataSource = "sysArea",params = "1",fieldName = "provinceDesc")
    @ApiModelProperty(value="小区所在省份")
    private String province;
    private String provinceDesc;
    /**
    * 小区所在市
    */
    @Dictionary(dataSource = "sysArea",params = "2",fieldName = "marketDesc")
    @ApiModelProperty(value="小区所在市")
    private String market;
    private String marketDesc;
    /**
    * 小区所在县
    */
    @Dictionary(dataSource = "sysArea",params = "3",fieldName = "countyDesc")
    @ApiModelProperty(value="小区所在县")
    private String county;
    private String countyDesc;
    /**
    * 小区经度
    */
    @ApiModelProperty(value="小区经度")
    private String longitude;
    /**
    * 小区维度
    */
    @ApiModelProperty(value="小区维度")
    private String latitude;
    /**
    * 物业名称
    */
    @ApiModelProperty(value="物业名称")
    private String propertyName;
    /**
    * 社区id
    */
    @ApiModelProperty(value="社区id")
    private String communityId;
    /**
    * 小区描述
    */
    @ApiModelProperty(value="小区描述")
    private String villageDescribe;

}
