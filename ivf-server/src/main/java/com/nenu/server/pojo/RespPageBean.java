package com.nenu.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Breon
 * @description: 分页公共返回对象
 * @date: 2022/10/20 11:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {

    /*
    总条数
     */
    private Long total;
    /*
    数据List
     */
    private List<?>data;
}
