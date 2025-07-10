package az.edu.turing.todomanager.model;

import az.edu.turing.todomanager.Enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Table(name="tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;




}
