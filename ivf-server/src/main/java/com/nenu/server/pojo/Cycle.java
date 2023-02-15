package com.nenu.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("t_cycle")
@ApiModel(value="Cycle对象", description="")
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "周期编号")
    @TableId(value = "ccId", type = IdType.AUTO)
    private Integer ccId;

    @ApiModelProperty(value = "所属诊案编号")
    private Integer tcId;

    @ApiModelProperty(value = "周期次序")
    private String ccNum;

    @ApiModelProperty(value = "第一阶段是否完成")
    private String step1;

    @ApiModelProperty(value = "第二阶段是否完成")
    private String step2;

    @ApiModelProperty(value = "第三阶段是否完成")
    private String step3;

    @ApiModelProperty(value = "第四阶段是否完成")
    private String step4;

    @ApiModelProperty(value = "第五阶段是否完成")
    private String step5;

    @ApiModelProperty(value = "第六阶段是否完成")
    private String step6;


}
