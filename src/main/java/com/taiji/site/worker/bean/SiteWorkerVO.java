
package com.taiji.site.worker.bean;

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

@ApiModel(description="表现层实体类",value = "SiteWorkerVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteWorkerVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 序号
    */
    @ApiModelProperty(value="序号")
    private Integer seq;
    /**
    * 施工单位名称
    */
    @ApiModelProperty(value="施工单位名称")
    private String unitName;
    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    private String fullName;
    /**
    * 岗位
    */
    @ApiModelProperty(value="岗位")
    private String job;
    /**
    * 进场日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="进场日期")
    private Date entryDate;
    /**
    * 身份证号码
    */
    @ApiModelProperty(value="身份证号码")
    private String idCard;
    /**
    * 住址
    */
    @ApiModelProperty(value="住址")
    private String address;
    /**
    * 性别
    */
    @ApiModelProperty(value="性别")
    private String gender;
    /**
    * 出生日期
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="出生日期")
    private Date birthday;
    /**
    * 血型
    */
    @ApiModelProperty(value="血型")
    private String bloodType;
    /**
    * 体检情况
    */
    @ApiModelProperty(value="体检情况")
    private String examine;
    /**
    * 持证情况
    */
    @ApiModelProperty(value="持证情况")
    private String permit;
    /**
    * 培训情况
    */
    @ApiModelProperty(value="培训情况")
    private String train;
    /**
    * 违章时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="违章时间")
    private Date violationDate;
    /**
    * 违章描述
    */
    @ApiModelProperty(value="违章描述")
    private String violationCase;

}
