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
@TableName("t_wit_log")
@ApiModel(value="WitLog对象", description="")
public class WitLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId(value = "logId", type = IdType.AUTO)
    private Integer logId;

    @ApiModelProperty(value = "核对类型")
    private String checkType;

    @ApiModelProperty(value = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime dateTime;

    @ApiModelProperty(value = "芯片1编号")
    private String rfid1;

    @ApiModelProperty(value = "芯片1记录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime rfid1Rectime;

    @ApiModelProperty(value = "芯片2编号")
    private String rfid2;

    @ApiModelProperty(value = "芯片2记录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private LocalDateTime rfid2Rectime;

    @ApiModelProperty(value = "结果")
    private String results;

    @ApiModelProperty(value = "结果描述")
    private String resComment;


}
