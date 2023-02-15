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
@TableName("t_treatment_rec")
@ApiModel(value="TreatmentRec对象", description="")
public class TreatmentRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "就诊编号")
    @TableId(value = "trId", type = IdType.AUTO)
    private Integer trId;

    @ApiModelProperty(value = "患者男编号")
    private String patientId;

    @ApiModelProperty(value = "医生编号")
    private String docId;

    @ApiModelProperty(value = "就诊项目")
    private String treatmentProgram;

    @ApiModelProperty(value = "处方项目")
    private String prescription;

    @ApiModelProperty(value = "就诊时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime trDate;

    @ApiModelProperty(value = "费用")
    private Double fee;

    @ApiModelProperty(value = "患者")
    @TableField(exist = false)
    private Patient patient;

}
