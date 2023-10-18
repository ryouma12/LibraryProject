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
@Table(name = "state")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name can have at most 255 characters")
    private String name;

    @Column(name = "abbreviation")
    @NotBlank(message = "Abbreviation is required")
    @Size(min = 2, max = 2, message = "Abbreviation must be exactly 2 characters")
    private String abbreviation;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patron> patrons = new ArrayList<>();

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches = new ArrayList<>();

}
