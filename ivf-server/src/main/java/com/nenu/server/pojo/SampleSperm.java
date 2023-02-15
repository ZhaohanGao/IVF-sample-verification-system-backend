package com.nenu.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Breon
 * @since 2022-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sample_sperm")
@ApiModel(value="SampleSperm对象", description="")
public class SampleSperm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "样本编号")
    @TableId(value = "ssId", type = IdType.AUTO)
    private Integer ssId;

    @ApiModelProperty(value = "诊案编号")
    private Integer tcId;

    @ApiModelProperty(value = "存放位置")
    private String position;

    @ApiModelProperty(value = "存放容器编号")
    private String containerId;

    @ApiModelProperty(value = "采集时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime collectDate;

    @ApiModelProperty(value = "实验编号")
    private Integer expId;

    @ApiModelProperty(value = "状态")
    private String conditions;

    @ApiModelProperty(value = "备注")
    private String comment;


}
