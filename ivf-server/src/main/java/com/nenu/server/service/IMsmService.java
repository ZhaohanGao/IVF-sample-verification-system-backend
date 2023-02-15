package com.nenu.server.service;

import java.util.Map;

/**
 * @author Breon
 * @description: 短信发送
 * @date: 2022/11/27 10:14
 */
public interface IMsmService {
    boolean send(String phone);
}
