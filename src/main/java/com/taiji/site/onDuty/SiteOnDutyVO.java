
package com.taiji.site.onDuty;

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

@ApiModel(description="表现层实体类",value = "SiteOnDutyVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteOnDutyVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="时间")
    private Date time;
    /**
    * 任务
    */
    @ApiModelProperty(value="任务")
    private String mission;
    /**
    * 开始时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")//存日期时使用
    @ApiModelProperty(value="开始时间")
    private Date startTime;
    /**
    * 结束时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")//存日期时使用
    @ApiModelProperty(value="结束时间")
    private Date endTime;
    /**
    * 社区管理员id
    */
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;
    /**
    * 小区id
    */
    @ApiModelProperty(value="小区id")
    private String villageId;

}
