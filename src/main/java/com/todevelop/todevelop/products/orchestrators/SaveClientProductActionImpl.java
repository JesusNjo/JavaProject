package com.todevelop.todevelop.products.orchestrators;

import com.todevelop.todevelop.clients.i18n.I18nClients;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.exceptions.ResourceNotFoundException;
import com.todevelop.todevelop.i18n.I18nService;
import com.todevelop.todevelop.products.dto.ClientProduct;
import com.todevelop.todevelop.products.dto.RequestClientProduct;
import com.todevelop.todevelop.products.mapper.ClientProductMapper;
import com.todevelop.todevelop.products.orchestrators.action.SaveClientProductAction;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.products.services.client_products.service.ClientProductService;
import com.todevelop.todevelop.products.services.products.services.ProductService;
import com.todevelop.todevelop.utils.ResourceTypeEnum;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
class SaveClientProductActionImpl implements SaveClientProductAction {
    private final ClientProductService clientProductService;
    private final ClientProductMapper clientProductMapper;
    private final ClientsService clientsService;
    private final ProductService productService;
    private final I18nService i18nService;
    @Override
    public List<ClientProduct> saveClientProduct(RequestClientProduct request) {

        var client = clientsService.findById(request.getClientId()).orElseThrow(()->{
            log.error("Client not found {}", request.getClientId());
            return new ResourceNotFoundException(i18nService.getMessage(I18nClients.CLIENT_NOT_FOUND_MSG_ERROR),request.getClientId());
        });

        //List<ClientProductModel> clientProductByClient = clientProductService.getClientProductModelByClientId(client);


        List<ClientProduct> response = new ArrayList<>();
        request.getProducts().forEach(productId->{
            var product = productService.findById(productId).orElseThrow(()->{
                log.error("Product not found {}",productId);
                return new ResourceNotFoundException(i18nService.getMessage(I18nClients.PRODUCT_NOT_FOUND_MSG_ERROR),productId);
            });


            clientProductService.findByClientAndProductAndStatus(client, product,StatusEnum.ACTIVE).ifPresentOrElse(present -> {
                /*present.setStatus(StatusEnum.ACTIVE);
                response.add(clientProductMapper.toDto(clientProductService.save(present)));
                clientProductByClient.remove(present);*/
                throw new ResourceNotFoundException(i18nService.getMessage("This relationship already exist!"),
                        present.getClientProductId());
            }, () -> {
                response.add(
                        clientProductMapper.toDto(
                                clientProductService.save(
                                        ClientProductModel.builder()
                                                .clientProductId(ResourceTypeEnum.PRODUCT_CLIENT.getPrefix())
                                                .client(client)
                                                .product(product)
                                                .status(StatusEnum.ACTIVE)
                                                .build()
                                )
                        )
                );

            });
        });
        /*clientProductByClient.forEach(clientProduct -> {
            clientProduct.setStatus(StatusEnum.INACTIVE);
            clientProductService.save(clientProduct);
        });*/
        return response;
    }
}
