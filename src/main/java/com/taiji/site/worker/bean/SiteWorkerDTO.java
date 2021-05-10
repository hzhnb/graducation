
package com.taiji.site.worker.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.taiji.eap.web.base.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(description="业务模型实体类",value = "SiteWorkerDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteWorkerDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 序号
    */
    @NotNull(message = "序号不能为空")
    @Excel(name = "序号",width=40)
    @ApiModelProperty(value="序号")
    private Integer seq;

    /**
    * 施工单位名称
    */
    @NotBlank(message = "施工单位名称不能为空")
    @Excel(name = "施工单位名称",width=40)
    @ApiModelProperty(value="施工单位名称")
    private String unitName;

    /**
    * 姓名
    */
    @NotBlank(message = "姓名不能为空")
    @Excel(name = "姓名",width=40)
    @ApiModelProperty(value="姓名")
    private String fullName;

    /**
    * 岗位
    */
    @NotBlank(message = "岗位不能为空")
    @Excel(name = "岗位",width=40)
    @ApiModelProperty(value="岗位")
    private String job;

    /**
    * 进场日期
    */
    @NotNull(message = "进场日期不能为空")
    @Excel(name = "进场日期",width=40)
    @ApiModelProperty(value="进场日期")
    private Date entryDate;

    /**
    * 身份证号码
    */
    @NotBlank(message = "身份证号码不能为空")
    @Excel(name = "身份证号码",width=40)
    @ApiModelProperty(value="身份证号码")
    private String idCard;

    /**
    * 住址
    */
    @NotBlank(message = "住址不能为空")
    @Excel(name = "住址",width=40)
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 性别
    */
    @NotBlank(message = "性别不能为空")
    @Excel(name = "性别",width=40)
    @ApiModelProperty(value="性别")
    private String gender;

    /**
    * 出生日期
    */
    @NotNull(message = "出生日期不能为空")
    @Excel(name = "出生日期",width=40)
    @ApiModelProperty(value="出生日期")
    private Date birthday;

    /**
    * 血型
    */
    @NotBlank(message = "血型不能为空")
    @Excel(name = "血型",width=40)
    @ApiModelProperty(value="血型")
    private String bloodType;

    /**
    * 体检情况
    */
    @NotBlank(message = "体检情况不能为空")
    @Excel(name = "体检情况",width=40)
    @ApiModelProperty(value="体检情况")
    private String examine;

    /**
    * 持证情况
    */
    @NotBlank(message = "持证情况不能为空")
    @Excel(name = "持证情况",width=40)
    @ApiModelProperty(value="持证情况")
    private String permit;

    /**
    * 培训情况
    */
    @NotBlank(message = "培训情况不能为空")
    @Excel(name = "培训情况",width=40)
    @ApiModelProperty(value="培训情况")
    private String train;

    /**
    * 违章时间
    */
    @NotNull(message = "违章时间不能为空")
    @Excel(name = "违章时间",width=40)
    @ApiModelProperty(value="违章时间")
    private Date violationDate;

    /**
    * 违章描述
    */
    @NotBlank(message = "违章描述不能为空")
    @Excel(name = "违章描述",width=40)
    @ApiModelProperty(value="违章描述")
    private String violationCase;

}
