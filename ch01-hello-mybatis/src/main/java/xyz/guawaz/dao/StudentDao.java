package xyz.guawaz.dao;

import xyz.guawaz.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询Student表的所有数据
    public List<Student> selectStudents();
}
