package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "item_loam")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @Column(name = "date_issued")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date Issued must be in yyyy-MM-dd format")
    private String dateIssued;

    @Column(name = "renewed")
    @Pattern(regexp = "^(Yes|No)$", message = "Renewed must be 'Yes' or 'No'")
    private String renewed;

    @Column(name = "due")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Due must be in yyyy-MM-dd format")
    private String due;

    @Column(name = "returned")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Returned must be in yyyy-MM-dd format")
    private String returned;

    @Column(name = "payment_date")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Payment Date must be in yyyy-MM-dd format")
    private String paymentDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;

}
