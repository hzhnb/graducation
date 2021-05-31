
package com.taiji.site.noticeRecord.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.taiji.eap.orm.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@ApiModel(description="持久化层实体类",value = "SiteNoticeRecordDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_notice_record")
public class SiteNoticeRecordDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 是否已读
    */
    @TableField(value = "is_read")
    @ApiModelProperty(value="是否已读")
    private String isRead;

    /**
    * 通知信息id
    */
    @TableField(value = "notice_id")
    @ApiModelProperty(value="通知信息id")
    private String noticeId;

    /**
    * 社区管理员id
    */
    @TableField(value = "administrator_id")
    @ApiModelProperty(value="社区管理员id")
    private String administratorId;

}
