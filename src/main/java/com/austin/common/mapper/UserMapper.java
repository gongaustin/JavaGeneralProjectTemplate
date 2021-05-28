package com.austin.common.mapper;

import com.austin.common.entity.User;
import com.austin.common.entity.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:用户
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<UserVo> selectUserVoPage(Page page, @Param("ew") Wrapper wrapper);

    UserVo findUserById(@Param("id") String id);


}
