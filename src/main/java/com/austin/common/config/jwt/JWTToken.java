package com.austin.common.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description: 实现JWTToken
 * JWTToken差不多就是Shiro用户名密码的载体。
 * 因为我们是前后端分离，服务器无需保存用户状态，所以不需要RememberMe这类功能，我们简单的实现下AuthenticationToken接口即可。
 * 因为token自己已经包含了用户名等信息，所以这里我就弄了一个字段。
 * 如果你喜欢钻研，可以看看官方的UsernamePasswordToken是如何实现的。
 * @Author:GongJun
 * @Date:2021/1/22
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
