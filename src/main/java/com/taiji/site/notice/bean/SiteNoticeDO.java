
package com.taiji.site.notice.bean;

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

@ApiModel(description="持久化层实体类",value = "SiteNoticeDO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_site_notice")
public class SiteNoticeDO extends BaseDO{

    /**
    * 主键id
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键id")
    private String id;

    /**
    * 类别
    */
    @TableField(value = "type")
    @ApiModelProperty(value="类别")
    private String type;

    /**
    * 内容
    */
    @TableField(value = "content")
    @ApiModelProperty(value="内容")
    private String content;

    /**
    * 时间
    */
    @TableField(value = "time")
    @ApiModelProperty(value="时间")
    private Date time;

    /**
    * 标题
    */
    @TableField(value = "title")
    @ApiModelProperty(value="标题")
    private String title;

    /**
    * 文件id
    */
    @TableField(value = "file_id")
    @ApiModelProperty(value="文件id")
    private String fileId;

}
