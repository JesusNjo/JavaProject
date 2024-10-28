package com.todevelop.todevelop.products.orchestrators;

import com.todevelop.todevelop.clients.i18n.I18nClients;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.exceptions.ResourceNotFoundException;
import com.todevelop.todevelop.i18n.I18nService;
import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.products.dto.RequestClientProductOrder;
import com.todevelop.todevelop.products.mapper.ClientProductOrderMapper;
import com.todevelop.todevelop.products.orchestrators.action.SaveClientProductOrderAction;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderId;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import com.todevelop.todevelop.products.services.client_product_order.service.ClientProductOrderService;
import com.todevelop.todevelop.products.services.products.services.ProductService;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
class SaveClientProductOrderActionImpl implements SaveClientProductOrderAction {
    private final ClientsService clientsService;
    private final ProductService productService;
    private final ClientProductOrderMapper clientProductOrderMapper;
    private final ClientProductOrderService clientProductOrderService;
    private final I18nService i18nService;
    @Override
    public List<ClientProductOrder> saveClientProductOrder(RequestClientProductOrder request) {
        var client = clientsService.findById(request.getClientId()).orElseThrow(()->{
            log.error("Client not found {}", request.getClientId());
            return new ResourceNotFoundException(i18nService.getMessage(I18nClients.CLIENT_NOT_FOUND_MSG_ERROR),request.getClientId());
        });
        var response = new ArrayList<ClientProductOrder>();
        request.getProducts().forEach(product->{
            var productF = productService.findById(product).orElseThrow(()->{
                log.error("Product not found {}", product);
                return new ResourceNotFoundException(i18nService.getMessage(I18nClients.PRODUCT_NOT_FOUND_MSG_ERROR),request.getClientId());
            });

            var clientProductOrderId = ClientProductOrderId.of(client,productF);

            response.add(
                    clientProductOrderMapper.toDto(
                            clientProductOrderService.save(
                                    ClientProductOrderModel.builder()
                                            .clientProductOrderId(clientProductOrderId)
                                            .orderQuantity(request.getQuantity())
                                            .totalPay(productF.getPrice()* request.getQuantity())
                                            .status(StatusEnum.ACTIVE)
                                            .build()
                            )
                    )
            );
        });
        return response;
    }
}
