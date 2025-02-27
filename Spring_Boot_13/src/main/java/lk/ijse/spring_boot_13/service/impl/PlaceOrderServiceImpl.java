package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.dto.OrderDetailDTO;
import lk.ijse.spring_boot_13.entity.Customer;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.entity.Order;
import lk.ijse.spring_boot_13.entity.OrderDetail;
import lk.ijse.spring_boot_13.repo.CustomerRepo;
import lk.ijse.spring_boot_13.repo.ItemRepo;
import lk.ijse.spring_boot_13.repo.OrderDetailRepo;
import lk.ijse.spring_boot_13.repo.OrderRepo;
import lk.ijse.spring_boot_13.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Transactional
    @Override
    public void placeOrder(OrderDTO orderDTO) {

        Optional<Customer> customerOptional = customerRepo.findById(orderDTO.getCustomerId());
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        Customer customer = customerOptional.get();

        Order order = new Order(customer, orderDTO.getOrderDate(), new ArrayList<>());


        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetails()) {
            Optional<Item> itemOptional = itemRepo.findById(orderDetailDTO.getItemCode());
            if (itemOptional.isEmpty()) {
                throw new RuntimeException("Item not found for code: " + orderDetailDTO.getItemCode());
            }
            Item item = itemOptional.get();

            if (item.getQuantity() < orderDetailDTO.getQuantity()) {
                throw new RuntimeException("Not enough stock for item: " + item.getName());
            }


            item.setQuantity(item.getQuantity() - orderDetailDTO.getQuantity());
            itemRepo.save(item);


            OrderDetail orderDetail = new OrderDetail(order, item, orderDetailDTO.getQuantity(), orderDetailDTO.getTotalPrice());
            order.getOrderDetails().add(orderDetail);
        }


        orderRepo.save(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepo.findAll();


        return orders.stream().map(order -> {
            List<OrderDetailDTO> orderDetailDTOs = order.getOrderDetails().stream()
                    .map(orderDetail -> new OrderDetailDTO(orderDetail.getItem().getCode(), orderDetail.getQuantity(), orderDetail.getTotalPrice()))
                    .collect(Collectors.toList());
            return new OrderDTO(order.getCustomer().getId(), order.getOrderDate(), orderDetailDTOs);
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Optional<Order> orderOptional = orderRepo.findById(orderDTO.getCustomerId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Order order = orderOptional.get();


        order.getOrderDetails().clear();

        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetails()) {
            Optional<Item> itemOptional = itemRepo.findById(orderDetailDTO.getItemCode());
            if (itemOptional.isEmpty()) {
                throw new RuntimeException("Item not found for code: " + orderDetailDTO.getItemCode());
            }
            Item item = itemOptional.get();


            if (item.getQuantity() < orderDetailDTO.getQuantity()) {
                throw new RuntimeException("Not enough stock for item: " + item.getName());
            }


            item.setQuantity(item.getQuantity() - orderDetailDTO.getQuantity());
            itemRepo.save(item);


            OrderDetail orderDetail = new OrderDetail(order, item, orderDetailDTO.getQuantity(), orderDetailDTO.getTotalPrice());
            order.getOrderDetails().add(orderDetail);
        }


        order.setOrderDate(orderDTO.getOrderDate());
        orderRepo.save(order);
    }

    @Transactional
    @Override
    public void deleteOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepo.findById(Math.toIntExact(orderId));
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Order order = orderOptional.get();


        for (OrderDetail orderDetail : order.getOrderDetails()) {
            Item item = orderDetail.getItem();
            item.setQuantity(item.getQuantity() + orderDetail.getQuantity());
            itemRepo.save(item);
        }


        orderDetailRepo.deleteAll(order.getOrderDetails());
        orderRepo.delete(order);
    }
}
