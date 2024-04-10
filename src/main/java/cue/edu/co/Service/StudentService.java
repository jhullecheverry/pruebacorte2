package Service;

import dtos.StudentDto;
import java.util.List;

public interface StudentService {

    void addStudent(StudentDto student);
    List<StudentDto> listAllStudent();
}