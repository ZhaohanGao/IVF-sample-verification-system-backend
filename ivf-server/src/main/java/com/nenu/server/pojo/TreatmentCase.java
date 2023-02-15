package com.nenu.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

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
@TableName("t_treatment_case")
@ApiModel(value="TreatmentCase对象", description="")
public class TreatmentCase implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "诊案编号")
    @TableId(value = "tcId", type = IdType.AUTO)
    private Integer tcId;

    @ApiModelProperty(value = "患者女编号")
    private Integer fpatientId;

    @ApiModelProperty(value = "患者男编号")
    private Integer mpatientId;

    @ApiModelProperty(value = "开始日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private LocalDate beginDate;

    @ApiModelProperty(value = "结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private LocalDate endDate;

    @ApiModelProperty(value = "RFID卡编号")
    private String rfid;

    @ApiModelProperty(value = "当前阶段")
    private String step;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "周期数")
    private String cycleNum;

    @ApiModelProperty(value = "简要描述")
    private String description;

    @ApiModelProperty(value = "备注")
    private String comment;

    @ApiModelProperty(value = "男性患者")
    @TableField(exist = false)
    private Patient mpatient;

    @ApiModelProperty(value = "女性患者")
    @TableField(exist = false)
    private Patient fpatient;

}
