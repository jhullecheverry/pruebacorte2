package Service;
import dtos.StudentDto;
import mapping.StudentDto;
import mapping.Mapper.StudentMapper;
import model.Product;
import models.Student;
import repository.Repository;
import repository.impl.product.ProductRepositoryFilesImpl;
import repository.impl.product.ProductRepositoryJDBCImpl;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private Repository<Student> studentRepository;

    public StudentServiceImpl() {
        this.studentRepository = new studentRepositoryJDBCImpl();
    }

    @Override
    public void addStudent(StudentDto student) {
        studentRepository.save(Student.mapFromDto(student));
    }

    @Override
    public List<StudentDto> listAllStudent() {
        return null;
    }

    @Override
    public List<StudentDto> listAllProducts() {
        return null;
    }

    @Override
    public List<StudentDto> listAllStudents() {
        return productRepository.list()
                .stream()
                .map(Student::mapFromModel)
                .toList();
    }
}