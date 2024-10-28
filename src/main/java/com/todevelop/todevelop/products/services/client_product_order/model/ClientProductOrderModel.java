package com.todevelop.todevelop.products.services.client_product_order.model;

import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_product_order")
@Builder
@Getter
@Setter
public class ClientProductOrderModel extends AuditBaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -1864188992050157183L;

    @EmbeddedId
    @Column(name = "client_product_order_id", nullable = false)
    private ClientProductOrderId clientProductOrderId;

    @Column(name = "order_quantity", nullable = false)
    private Integer orderQuantity;

    @Column(name = "total_pay", nullable = false)
    private Double totalPay;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

}
