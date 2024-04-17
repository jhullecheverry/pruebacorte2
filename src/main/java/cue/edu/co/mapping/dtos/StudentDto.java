package cue.edu.co.mapping.dtos;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record StudentDto(String name,String email,int semester,int id) {
}