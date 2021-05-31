
package com.taiji.site.residentUser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteResidentVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteResidentVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 居民邮箱
    */
    @ApiModelProperty(value="居民邮箱")
    private String email;
    /**
    * 居民住址
    */
    @ApiModelProperty(value="居民住址")
    private String address;
    /**
    * 居民性别
    */
    @Dictionary(dataSource = "baseEnumDict",params = "SexType",fieldName = "genderDesc")
    @ApiModelProperty(value="居民性别")
    private String gender;
    private String genderDesc;
    /**
    * 居民身份证号码
    */
    @ApiModelProperty(value="居民身份证号码")
    private String idcare;
    /**
    * 电话
    */
    @ApiModelProperty(value="电话")
    private String phone;
    /**
    * 出生日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="出生日期")
    private Date birth;
    /**
    * user表的id
    */
    @ApiModelProperty(value="user表的id")
    private String userId;
    /**
    * 社区的id
    */
    @ApiModelProperty(value="社区的id")
    private String communityId;
    /**
    * 小区的id
    */
    @ApiModelProperty(value="小区的id")
    private String villageId;
    /**
    * 楼宇的id
    */
    @ApiModelProperty(value="楼宇的id")
    private String buildingId;
    /**
    * 房间号
    */
    @ApiModelProperty(value="房间号")
    private String roomNumber;

}
