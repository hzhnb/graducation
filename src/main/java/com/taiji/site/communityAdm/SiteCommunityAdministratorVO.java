
package com.taiji.site.communityAdm;

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

@ApiModel(description="表现层实体类",value = "SiteCommunityAdministratorVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteCommunityAdministratorVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 性别
    */
    @Dictionary(dataSource = "baseEnumDict",params = "SexType",fieldName = "genderDesc")
    @ApiModelProperty(value="性别")
    private String gender;
    private String genderDesc;
    /**
    * 出生日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="出生日期")
    private Date birth;
    /**
    * 电话
    */
    @ApiModelProperty(value="电话")
    private String phone;
    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;
    /**
    * 住址
    */
    @ApiModelProperty(value="住址")
    private String address;
    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    private String name;
    /**
    * 职位
    */
    @Dictionary(dataSource = "sysDictionary",params = "1392425857821290498",fieldName = "positionDesc")
    @ApiModelProperty(value="职位")
    private String position;
    private String positionDesc;
    /**
    * user表的id
    */
    @ApiModelProperty(value="user表的id")
    private String userId;
    /**
    * 社区表的id
    */
    @ApiModelProperty(value="社区表的id")
    private String communityId;

}
