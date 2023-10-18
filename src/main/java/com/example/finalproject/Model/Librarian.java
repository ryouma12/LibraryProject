package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "librarian")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarian_id")
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(max = 255, message = "First name can have at most 255 characters")
    private String firstName;

    @Column(name = "middle_name")
    @Size(max = 255, message = "Middle name can have at most 255 characters")
    private String middleName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(max = 255, message = "Last name can have at most 255 characters")
    private String lastName;

    @Column(name = "password_hash")
    @NotBlank(message = "Password hash is required")
    @Size(min = 6, max = 255, message = "Password hash must be between 6 and 255 characters")
    private String passwordHash;

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLoan> itemLoans = new ArrayList<>();

}
