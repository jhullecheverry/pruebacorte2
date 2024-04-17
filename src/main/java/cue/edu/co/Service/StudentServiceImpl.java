package cue.edu.co.Service;

import cue.edu.co.config.DatabaseConnection;
import cue.edu.co.mapping.mappers.Mapper;
import cue.edu.co.repository.Repository;
import cue.edu.co.models.Student;
import cue.edu.co.repository.impl.RepositoryJDBCImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    Connection conn = DatabaseConnection.getInstance();
    private Repository<Student> studentRepository;

    public StudentServiceImpl() throws SQLException {
        this.studentRepository = new RepositoryJDBCImpl();
    }

    @Override
    public List listStudent() {
        return studentRepository.list()
                .stream()
                .map(Mapper::mapFromModel)
                .toList();
    }
}