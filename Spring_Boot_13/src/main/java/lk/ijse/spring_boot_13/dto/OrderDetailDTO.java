package lk.ijse.spring_boot_13.dto;

public class OrderDetailDTO {

    private int itemCode;
    private int quantity;
    private double totalPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int itemCode, int quantity, double totalPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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
