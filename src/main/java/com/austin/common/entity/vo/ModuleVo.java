package com.austin.common.entity.vo;

import com.austin.common.entity.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 15:54 2021/5/14
 */
public class ModuleVo extends Module {
    List<ModuleVo> children = new ArrayList<>();

    public List<ModuleVo> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleVo> children) {
        this.children = children;
    }
}
