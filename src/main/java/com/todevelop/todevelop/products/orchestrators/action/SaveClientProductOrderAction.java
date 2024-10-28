package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.products.dto.RequestClientProductOrder;

public interface SaveClientProductOrderAction {

    ClientProductOrder saveClientProductOrder(RequestClientProductOrder request);
}
