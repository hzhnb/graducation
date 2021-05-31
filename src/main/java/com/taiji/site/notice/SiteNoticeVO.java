
package com.taiji.site.notice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taiji.eap.web.annotation.Dictionary;
import com.taiji.eap.web.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description="表现层实体类",value = "SiteNoticeVO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteNoticeVO extends BaseVO{



    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String id;
    /**
    * 类别
    */
    @Dictionary(dataSource = "sysDictionary",params = "1393073754296328194",fieldName = "typeDesc")
    @ApiModelProperty(value="类别")
    private String type;
    private String typeDesc;
    /**
    * 内容
    */
    @ApiModelProperty(value="内容")
    private String content;
    /**
    * 时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    @ApiModelProperty(value="时间")
    private Date time;
    /**
    * 标题
    */
    @ApiModelProperty(value="标题")
    private String title;
    /**
    * 文件id
    */
    @ApiModelProperty(value="文件id")
    private String fileId;

}
