package com.todevelop.todevelop.products.services.products.model;

import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
@Getter
@Setter
@Entity
public class ProductModel extends AuditBaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -9136858036548093366L;

    @Id
    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TelecomProductType productType;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "activation_date")
    private Timestamp activationDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;



}
