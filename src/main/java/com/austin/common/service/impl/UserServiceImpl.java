package com.austin.common.service.impl;

import com.austin.common.core.bean.UserBean;
import com.austin.common.entity.User;
import com.austin.common.entity.vo.UserVo;
import com.austin.common.mapper.UserMapper;
import com.austin.common.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户人员 服务实现类
 * </p>
 *
 * @author GongJun
 * @since 2019-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public UserBean getUser(String username) {
        UserBean ub = new UserBean();
        return null;
    }

    @Override
    public List<UserVo> selectUserVoPage(Page page, Wrapper wrapper) {
        return this.baseMapper.selectUserVoPage(page, wrapper);
    }

    @Override
    public UserVo findUserById(String id) {
        return this.baseMapper.findUserById(id);
    }

}
