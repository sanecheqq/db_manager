package webapp_java.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    @NotBlank(message = "Name is required")
    private String name;

    @Column
    @NotBlank(message = "Surname is required")
    private String surname;

    @Column
    @NotBlank(message = "Department is required")
    private String department;

    @Column
    @Min(value = 1, message = "salary must be greater then 0")
    @Max(value = 1000_000_000, message = "salary must be less then 1000_000_000")
    private int salary;
}
