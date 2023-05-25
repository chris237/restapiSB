package com.onlinestore.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    private String name_cust;

    @Column(name = "address")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orderdate")
    private Date orderdate;

    @Transient
    private BigDecimal amount;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Line> lines = new HashSet<>();

    public BigDecimal getAmount() {
        amount = new BigDecimal(0);
        if ((this.getLines() != null) && (this.getLines().size() > 0)) {
            for (Line line : this.getLines()) {
                if (line.getLaptops().getPrix() != null) {
                    amount = amount.add(
                            line.getLaptops().getPrix().multiply(BigDecimal.valueOf(line.getQte().longValue())));
                }
            }
        }

        return amount;
    }
}
