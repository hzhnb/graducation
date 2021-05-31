
package com.taiji.site.community;

import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteCommunityVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteCommunityVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 社区名称
    */
    @ApiModelProperty(value="社区名称")
    private String name;
    /**
    * 社区地址
    */
    @ApiModelProperty(value="社区地址")
    private String address;
    /**
    * 社区所在省份
    */
    @Dictionary(dataSource = "sysArea",params = "1",fieldName = "provinceDesc")
    @ApiModelProperty(value="社区所在省份")
    private String province;
    private String provinceDesc;
    /**
    * 社区所在市
    */
    @Dictionary(dataSource = "sysArea",params = "2",fieldName = "marketDesc")
    @ApiModelProperty(value="社区所在市")
    private String market;
    private String marketDesc;
    /**
    * 社区所在县
    */
    @Dictionary(dataSource = "sysArea",params = "3",fieldName = "countyDesc")
    @ApiModelProperty(value="社区所在县")
    private String county;
    private String countyDesc;
    /**
    * 社区经度
    */
    @ApiModelProperty(value="社区经度")
    private String longitude;
    /**
    * 社区纬度
    */
    @ApiModelProperty(value="社区纬度")
    private String latitude;

}
