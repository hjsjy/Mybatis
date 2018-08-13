package com.hj.mybatis.bean;

import com.hj.mybatis.service.Department;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/8/8
 * @since 1.0.0
 */
public interface DepartmentMapper {
    public Department getDeptByIdPlus(Integer id);
}
