package com.hj.mybatis.bean;

import com.hj.mybatis.service.Department;
import com.hj.mybatis.service.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/8/5
 * @since 1.0.0
 */
public class MybatisTest {


    /**
     * 根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
     * @throws IOException
     */

    public SqlSessionFactory test() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
//            @Test
//    public void testa(){
//    //2、获取sqlSession实例，能直接执行已经映射的sql语句
//        SqlSession openSession=sqlSessionFactory.openSession();
//        try {
//            Employee employee = openSession.selectOne("Dao.selectEmp", 1);
//            System.out.println(employee);
//        }finally {
////
////            openSession.close();
////        }}
        @Test
        public void test01() throws IOException {
//        获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=test();
//        获取sqlSession对象
            SqlSession openSession=sqlSessionFactory.openSession();
//          获取接口的实现类对象
            try {

            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee=mapper.getEmpById(1);
                System.out.println(mapper.getClass());
            System.out.println(employee);
            }finally {
                openSession.close();
            }
        }

    /**
     * mybatis允许直接定义的返回值
     * Ingeter Long Boolean void
     * 我们需要手动提交数据
     * @throws IOException
     */


    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory=test();

        SqlSession openSqlSession=sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSqlSession.getMapper(EmployeeMapper.class);
            Map<String,Object> map=new HashMap<>();
            map.put("id",3);
            map.put("lastName","hj");
            Employee employee = mapper.getMap(map);
            System.out.println(employee);


            openSqlSession.commit();
        }finally {
            openSqlSession.close();
        }
    }
    @Test
    public void test04() throws IOException {
        SqlSessionFactory sqlSessionFactory=test();

        SqlSession openSqlSession=sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSqlSession.getMapper(EmployeeMapper.class);
            Employee hj = mapper.getEmpByIdAndLastNam(3, "hj");
            System.out.println(hj);

            openSqlSession.commit();
        }finally {
            openSqlSession.close();
        }
    }
        @Test
            public void test03() throws IOException {
                SqlSessionFactory sqlSessionFactory=test();

                SqlSession openSqlSession=sqlSessionFactory.openSession();
                try {
                    EmployeeMapper mapper = openSqlSession.getMapper(EmployeeMapper.class);
//                测试添加数据库数据
                    Map<String, Employee> mapByLastNameReturnMap = mapper.getMapByLastNameReturnMap("%j%");
                    System.out.println(mapByLastNameReturnMap);
//                测试修改数据
//                Employee employee = new Employee(2, "hja", "hja@126.com", "0");
//                mapper.updateEmp(employee);
//                测试删除
//                Boolean deleteEmp = mapper.deleteEmp(2);
//                System.out.println(deleteEmp);
                    openSqlSession.commit();
                }finally {
                    openSqlSession.close();
                }

        }
        @Test
        public void test07() throws IOException {
            SqlSessionFactory sqlSessionFactory = test();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            try {

            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
                Employee empAndDept = mapper.getEmpAndDept(3);
                System.out.println(empAndDept);
                System.out.println(empAndDept.getDepartment());
            }finally {
                sqlSession.close();
            }
        }
        @Test
         public  void test08() throws IOException {
             SqlSessionFactory sqlSessionFactory = test();
             SqlSession sqlSession = sqlSessionFactory.openSession();
             try {

                 DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
                 Department deptByIdPlus = mapper.getDeptByIdPlus(1);
                 System.out.println(deptByIdPlus);
                 System.out.println(deptByIdPlus.getEmps());

             }finally {
                 sqlSession.close();
             }
         }
    }
