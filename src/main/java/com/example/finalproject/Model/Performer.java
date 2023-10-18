package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "performer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performer_id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(max = 255, message = "First name can have at most 255 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(max = 255, message = "Last name can have at most 255 characters")
    private String lastName;

    @Column(name = "middle_name")
    @Size(max = 255, message = "Middle name can have at most 255 characters")
    private String middleName;
}
