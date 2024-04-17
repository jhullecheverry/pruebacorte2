package cue.edu.co.mapping.mappers;
import cue.edu.co.mapping.dtos.StudentDto;
import cue.edu.co.models.Student;

public class Mapper {

    public static StudentDto mapFromModel(Student student){
        return new StudentDto(student.getName(), student.getEmail(),student.getSemester(), student.getId());
    }

    public static Student mapFromDTO(StudentDto student){
        return Student.builder()
                .name(student.name())
                .email(student.email())
                .semester(student.semester())
                .id(student.id())
                .build();
    }
}
