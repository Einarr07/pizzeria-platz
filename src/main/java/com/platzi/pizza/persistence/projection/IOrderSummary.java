package com.platzi.pizza.persistence.projection;

import java.time.LocalDateTime;

public interface IOrderSummary {

    Integer getIdOrder();
    String getCustomerName();
    LocalDateTime getOrderDate();
    Double getTotalPrice();
    String getPizzaNames();

}
