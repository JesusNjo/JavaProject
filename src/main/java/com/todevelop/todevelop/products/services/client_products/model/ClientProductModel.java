package com.todevelop.todevelop.products.services.client_products.model;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_product")
@Builder
public class ClientProductModel extends AuditBaseModel implements Serializable {

    @Id
    @Column(name = "client_product_id")
    private String clientProductId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientsModel client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel product;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
