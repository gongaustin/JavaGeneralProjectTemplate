package com.austin.common.config.realm;

import com.austin.common.config.jwt.JWTToken;
import com.austin.common.entity.User;
import com.austin.common.service.IUserService;
import com.austin.common.utils.JWTUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:前端控制器
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);
    @Resource
    private IUserService service;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String id = JWTUtil.getUserId(principals.toString());
//        String username = JWTUtil.getUsername(principals.toString());
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        QueryWrapper ew = new QueryWrapper<User>().eq("id",id);
//        if(!"admin".equals(username)){
//            ew.eq("up.status={0}",1);
//            ew.eq("ur.status={0}",1);
//        }
//        List<Permission> permissions = this.service.selectUserPermissionsByWrapper(ew);
//        Set<String> permission = new HashSet<>(Objects.requireNonNull(permissions == null ? null : permissions.stream().map(Permission::getPermissionValue).collect(Collectors.toList())));
//        simpleAuthorizationInfo.addStringPermissions(permission);
//        return simpleAuthorizationInfo;
//    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String id = JWTUtil.getUserId(token);
        if (id == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = this.service.getById(id);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, id, user.getUsername())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
