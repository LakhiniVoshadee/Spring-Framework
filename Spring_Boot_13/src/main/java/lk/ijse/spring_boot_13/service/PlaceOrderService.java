package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.OrderDTO;

import java.util.List;

public interface PlaceOrderService {
    void placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    void updateOrder(OrderDTO orderDTO);
    void deleteOrder(Long orderId);
}
