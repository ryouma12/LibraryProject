package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "street")
    @NotNull
    @Size(max = 100)
    private String street;

    @Column(name = "city")
    @NotNull
    @Size(max = 50)
    private String city;

    @Column(name = "zip")
    @NotNull
    @Pattern(regexp = "\\d{5}", message = "Zip code must be 5 digits")
    private String zip;

    @Column(name = "phone")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @Column(name = "fax")
    @Pattern(regexp = "\\d{10}", message = "Fax number must be 10 digits")
    private String fax;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLoan> itemLoans = new ArrayList<>();

}

