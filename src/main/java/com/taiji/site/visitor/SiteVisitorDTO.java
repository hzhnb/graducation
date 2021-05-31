
package com.taiji.site.visitor;

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

@ApiModel(description="业务模型实体类",value = "SiteVisitorDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteVisitorDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 姓名
    */
    @NotBlank(message = "姓名不能为空")
    @Excel(name = "姓名",width=40)
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 身份证号
    */
    @NotBlank(message = "身份证号不能为空")
    @Excel(name = "身份证号",width=40)
    @ApiModelProperty(value="身份证号")
    private String idcare;

    /**
    * 始发地
    */
    @NotBlank(message = "始发地不能为空")
    @Excel(name = "始发地",width=40)
    @ApiModelProperty(value="始发地")
    private String vfrom;

    /**
    * 住址
    */
    @NotBlank(message = "住址不能为空")
    @Excel(name = "住址",width=40)
    @ApiModelProperty(value="住址")
    private String address;

    /**
    * 电话
    */
    @NotBlank(message = "电话不能为空")
    @Excel(name = "电话",width=40)
    @ApiModelProperty(value="电话")
    private String phone;

    /**
    * 来访时间
    */
    @NotNull(message = "来访时间不能为空")
    @Excel(name = "来访时间",width=40)
    @ApiModelProperty(value="来访时间")
    private Date time;

    /**
    * 居民的id
    */
    @NotBlank(message = "居民的id不能为空")
    @Excel(name = "居民的id",width=40)
    @ApiModelProperty(value="居民的id")
    private String residentId;

}
