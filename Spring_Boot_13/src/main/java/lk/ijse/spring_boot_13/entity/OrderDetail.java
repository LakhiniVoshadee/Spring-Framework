package lk.ijse.spring_boot_13.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order placeOrder;

    @ManyToOne
    @JoinColumn(name = "item_code", nullable = false)
    private Item item;

    private int quantity;
    private double totalPrice;

    public OrderDetail() {
    }

    public OrderDetail(Order placeOrder, Item item, int quantity, double totalPrice) {
        this.placeOrder = placeOrder;
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(Order placeOrder) {
        this.placeOrder = placeOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
