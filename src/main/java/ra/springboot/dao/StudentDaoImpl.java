package ra.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ra.springboot.model.entity.Student;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements  IStudentDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public void save(Student s) {
        if (s.getId()==null){
            entityManager.persist(s);
        }else {
            entityManager.merge(s);;
        }
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
    }
}
