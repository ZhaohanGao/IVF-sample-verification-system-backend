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
@TableName("t_experiment_opt")
@ApiModel(value="ExperimentOpt对象", description="")
public class ExperimentOpt implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实验操作编号")
    @TableId(value = "expId", type = IdType.AUTO)
    private Integer expId;

    @ApiModelProperty(value = "操作对象编号")
    private Integer operandId;

    @ApiModelProperty(value = "实验种类")
    private String expType;

    @ApiModelProperty(value = "实验内容")
    private String expName;

    @ApiModelProperty(value = "实验时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime expDate;

    @ApiModelProperty(value = "操作人编号")
    private Integer operatorId;

    @ApiModelProperty(value = "周期")
    private Integer cycleNum;


}
