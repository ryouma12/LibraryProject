package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "item_type")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name can have at most 255 characters")
    private String name;

    @Column(name = "abbreviation")
    @NotBlank(message = "Abbreviation is required")
    @Size(max = 10, message = "Abbreviation can have at most 10 characters")
    private String abbreviation;

    @Column(name = "per_day")
    @PositiveOrZero(message = "Per day should be a positive integer or zero")
    private Integer perDay;

    @Column(name = "max_fine")
    @PositiveOrZero(message = "Max fine should be a positive integer or zero")
    private Integer maxFine;

    @OneToMany(mappedBy = "itemType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

}


