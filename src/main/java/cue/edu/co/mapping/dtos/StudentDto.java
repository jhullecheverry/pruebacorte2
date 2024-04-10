package dtos;
import lombok.Builder;
import models.Category;

import java.time.LocalDateTime;
@Builder
public record StudentDto(String name, double price, LocalDateTime registrationDate, Category category) {
}