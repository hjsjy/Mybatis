package com.hj.mybatis.bean;

import com.hj.mybatis.service.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br6>
 *
 * @author 黄杰
 * @create 2018/8/
 * @since 1.0.0
 */
public interface EmployeeMapper {
    @MapKey("lastName")
    public  Map<String,Employee> getMapByLastNameReturnMap(String lastName);
    public Map<String,Object> getMapById(Integer id);
    public List<Employee> getLsitMapByLastName(String lastName);
    public Employee getMap(Map<String,Object> map);
    public Employee getEmpByIdAndLastNam(@Param("id") Integer id,@Param("lastName") String lastName);
    public Employee getEmpById(Integer id);
    public void addEmp(Employee employee);
    public void updateEmp(Employee employee);
    public  Boolean deleteEmp(Integer id);
}
