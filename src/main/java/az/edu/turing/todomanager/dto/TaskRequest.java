package az.edu.turing.todomanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;

}
