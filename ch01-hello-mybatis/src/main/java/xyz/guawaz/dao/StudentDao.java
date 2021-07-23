package xyz.guawaz.dao;

import xyz.guawaz.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询Student表的所有数据
    public List<Student> selectStudents();

    //向数据库插入数据
    public int insertStudent(Student student);
}
