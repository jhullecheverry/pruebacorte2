package mapping;
import dtos.StudentDto;
import models.Student;

public class Mapper {

    public static StudentDto mapFromModel(Student student){
        return new StudentDto(student.getName(), student.getPrice(),student.getRegistrationDate(),student.getCategory());
    }

    public static Student mapFromDTO(StudentDto student){
        return Student.builder()
                .name(student.name())
                .price(student.price())
                .category(student.category())
                .registrationDate(student.registrationDate())
                .build();
    }
}