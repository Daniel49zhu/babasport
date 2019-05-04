package com.zjc.core.dao.user;


import com.zjc.core.bean.user.Employee;
import com.zjc.core.query.user.EmployeeQuery;

import java.util.List;

public interface EmployeeDao {

    /**
     * 添加
     *
     * @param employee
     */
    Integer addEmployee(Employee employee);

    /**
     * 根据主键查找
     *
     */
    Employee getEmployeeByKey(String id);

    /**
     * 根据主键批量查找
     */
    List<Employee> getEmployeesByKeys(List<String> idList);

    /**
     * 根据主键删除
     */
    Integer deleteByKey(String id);

    /**
     * 根据主键批量删除
     */
    Integer deleteByKeys(List<String> idList);

    /**
     * 根据主键更新
     */
    Integer updateEmployeeByKey(Employee employee);

    /**
     * 分页查询
     *
     * @param employeeQuery
     */
    List<Employee> getEmployeeListWithPage(EmployeeQuery employeeQuery);

    /**
     * 集合查询
     *
     * @param employeeQuery
     */
    List<Employee> getEmployeeList(EmployeeQuery employeeQuery);

    /**
     * 总条数
     *
     * @param employeeQuery
     */
    int getEmployeeListCount(EmployeeQuery employeeQuery);
}
