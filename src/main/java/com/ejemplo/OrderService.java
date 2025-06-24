package com.ejemplo;

public class OrderService {

    private final DiscountRepository repository;

    public OrderService(DiscountRepository repository) {
        this.repository = repository;
    }

    public double calcularTotal(double subtotal, String discountCode, boolean expressDelivery){
        double discount = repository.getPercentage(discountCode);
        double delivery = expressDelivery ? 20.0 : 10.0;
        return (subtotal * (1- discount)) + delivery;
    }
}
