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
@TableName("t_patient")
@ApiModel(value="Patient对象", description="")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ptId")
    @TableId(value = "ptId", type = IdType.AUTO)
    private Integer ptId;

    @ApiModelProperty(value = "身份证号")
    private String citizenId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private LocalDate birthday;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "配偶身份证号")
    private String spouseId;

    @ApiModelProperty(value = "配偶")
    private String spouse;

    @ApiModelProperty(value = "病史")
    private String medicalHistory;


}
