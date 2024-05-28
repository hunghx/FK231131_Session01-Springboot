package ra.springboot.dao;

import ra.springboot.model.entity.Student;

import java.util.List;

public interface IStudentDao {
    // crud
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student s);
    void deleteById(Integer id);
}
