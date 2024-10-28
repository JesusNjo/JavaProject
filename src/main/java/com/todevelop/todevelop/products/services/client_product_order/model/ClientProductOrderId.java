package com.todevelop.todevelop.products.services.client_product_order.model;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.products.model.ProductModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ClientProductOrderId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private ClientsModel client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel product;
}
