package com.hj.mybatis.bean;

import com.hj.mybatis.service.Employee;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/8/8
 * @since 1.0.0
 */
public interface EmployeeMapperPlus {
        public Employee getEmpAndDept(Integer id);
       public Employee getEmpId(Integer id);
}