
package com.taiji.site.visitor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteVisitorVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteVisitorVO extends BaseVO{



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
    * 身份证号
    */
    @ApiModelProperty(value="身份证号")
    private String idcare;
    /**
    * 始发地
    */
    @ApiModelProperty(value="始发地")
    private String vfrom;
    /**
    * 住址
    */
    @ApiModelProperty(value="住址")
    private String address;
    /**
    * 电话
    */
    @ApiModelProperty(value="电话")
    private String phone;
    /**
    * 来访时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用s
    @ApiModelProperty(value="来访时间")
    private Date time;
    /**
    * 居民的id
    */
    @ApiModelProperty(value="居民的id")
    private String residentId;

}
