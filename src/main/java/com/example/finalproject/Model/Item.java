package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @Column(name = "description")
    @Size(max = 1000, message = "Description can have at most 1000 characters")
    private String description;

    @Column(name = "borrowable")
    @Pattern(regexp = "^(Yes|No)$", message = "Borrowable must be 'Yes' or 'No'")
    private String borrowable;

    @Column(name = "publish_year")
    @Pattern(regexp = "^[0-9]{4}$", message = "Publish year must be a valid 4-digit year")
    private String publishYear;

    @Column(name = "call_number")
    @Positive(message = "Call number must be a positive integer")
    private Integer callNumber;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "itemtype_id")
    private ItemType itemType;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLoan> itemLoans = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemNote> itemNotes = new ArrayList<>();

}
