package lk.ijse.spring_boot_13.dto;

import lk.ijse.spring_boot_13.entity.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private int customerId;
    private LocalDate orderDate;
    private List<OrderDetailDTO> orderDetails;

    // Add a no-argument constructor
    public OrderDTO() {
    }

    public OrderDTO(int customerId, LocalDate orderDate, List<OrderDetailDTO> orderDetails) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    // Getter and Setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
