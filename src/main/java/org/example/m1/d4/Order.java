package org.example.m1.d4;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryData;
    private List<Product> products;
    private Customer customer;

    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryData, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryData = deliveryData.plusDays(2);
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryData() {
        return deliveryData;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryData=" + deliveryData +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
