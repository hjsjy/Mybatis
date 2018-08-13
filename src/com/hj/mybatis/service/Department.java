package com.hj.mybatis.service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/8/8
 * @since 1.0.0
 */
public class Department {
     private Integer id;
     private String departmentName;
     private List<Employee>  emps;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}