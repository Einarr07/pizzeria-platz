package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.projection.IOrderSummary;
import com.platzi.pizza.persistence.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderRepository orderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";


    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public List<OrderEntity> getTodayOrders() {

        LocalDateTime now = LocalDate.now().atTime(0, 0);
        return orderRepository.findAllByDateAfter(now);
    }

    public List<OrderEntity> getOutsideOrders() {

        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return orderRepository.findAllByMethodIn(methods);
    }

    public List<OrderEntity> getCustomerOrders(String idCustomer) {
        return orderRepository.findCustomerOrders(idCustomer);
    }

    public IOrderSummary getOrderSummary(int orderId) {
        return orderRepository.findSummary(orderId);
    }
}
