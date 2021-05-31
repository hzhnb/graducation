
package com.taiji.site.noticeRecord;

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

@ApiModel(description="业务模型实体类",value = "SiteNoticeRecordDTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteNoticeRecordDTO extends BaseDTO{

    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 是否已读
    */
    @NotBlank(message = "是否已读不能为空")
    @Excel(name = "是否已读",width=40)
    @ApiModelProperty(value="是否已读")
    private String isRead;

    /**
    * 通知信息id
    */
    @NotBlank(message = "通知信息id不能为空")
    @Excel(name = "通知信息id",width=40)
    @ApiModelProperty(value="通知信息id")
    private String noticeId;

    /**
    * 社区管理员id
    */
    @NotBlank(message = "社区管理员id不能为空")
    @Excel(name = "社区管理员id",width=40)
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;

}
