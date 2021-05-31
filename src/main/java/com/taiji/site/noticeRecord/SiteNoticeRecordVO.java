
package com.taiji.site.noticeRecord;

import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteNoticeRecordVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteNoticeRecordVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 是否已读
    */
    @Dictionary(dataSource = "baseEnumDict",params = "YesNo",fieldName = "isReadDesc")
    @ApiModelProperty(value="是否已读")
    private String isRead;
    private String isReadDesc;
    /**
    * 通知信息id
    */
    @ApiModelProperty(value="通知信息id")
    private String noticeId;
    /**
    * 社区管理员id
    */
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;

}
