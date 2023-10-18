package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "patron")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patron_id")
    private Long id;

    @Column(name = "phone")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a 10-digit number")
    private String phone;

    @Column(name = "street")
    @Size(max = 255, message = "Street can have at most 255 characters")
    private String street;

    @Column(name = "city")
    @Size(max = 255, message = "City can have at most 255 characters")
    private String city;

    @Column(name = "zip")
    @Pattern(regexp = "^[0-9]{5}$", message = "ZIP code must be a 5-digit number")
    private String zip;

    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(max = 255, message = "First name can have at most 255 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(max = 255, message = "Last name can have at most 255 characters")
    private String lastName;

    @Column(name = "email")
    @Email(message = "Invalid email address")
    @Size(max = 255, message = "Email can have at most 255 characters")
    private String email;

    @Column(name = "middle_name")
    @Size(max = 255, message = "Middle name can have at most 255 characters")
    private String middleName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLoan> itemLoans = new ArrayList<>();

}
