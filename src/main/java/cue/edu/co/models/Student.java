package cue.edu.co.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private int id;
    private String name;
    private String email;
    private int semester;
}