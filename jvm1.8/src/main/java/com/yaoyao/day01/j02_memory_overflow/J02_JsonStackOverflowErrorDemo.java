package com.yaoyao.day01.j02_memory_overflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * 第三方库导致的栈内存溢出：StackOverflowError
 *
 * @JsonIgnore注解可以不转换该属性
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J02_JsonStackOverflowErrorDemo {
    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setName("研发部");

        Emp emp1 = new Emp();
        emp1.setName("张三");
        emp1.setDept(dept);

        Emp emp2 = new Emp();
        emp2.setName("李四");
        emp2.setDept(dept);

        dept.setEmps(Arrays.asList(emp1, emp2));

        // { name: '研发部', emps: [{ name: '张三', dept: { name: '', emps: [{...}, ... ] } }, ... ] }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(dept));
    }
}

//员工
class Emp {
    private String name;
//    @JsonIgnore //转换的时候，遇到dept属性就不转了。
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}

//部门
class Dept {
    private String name;
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
