
package com.taiji.site.notice;

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

@ApiModel(description="业务模型实体类",value = "SiteNoticeDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteNoticeDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 类别
    */
    @NotBlank(message = "类别不能为空")
    @Excel(name = "类别",width=40)
    @ApiModelProperty(value="类别")
    private String type;

    /**
    * 内容
    */
    @NotBlank(message = "内容不能为空")
    @Excel(name = "内容",width=40)
    @ApiModelProperty(value="内容")
    private String content;

    /**
    * 时间
    */
    @NotNull(message = "时间不能为空")
    @Excel(name = "时间",width=40)
    @ApiModelProperty(value="时间")
    private Date time;

    /**
    * 标题
    */
    @NotBlank(message = "标题不能为空")
    @Excel(name = "标题",width=40)
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 文件id
    */
    @NotBlank(message = "文件id不能为空")
    @Excel(name = "文件id",width=40)
    @ApiModelProperty(value="文件id")
    private String fileId;

}
