package com.ejemplo;

public class PedidoService {

    private DiscountRepository repository;

    public PedidoService(DiscountRepository repository) {
        this.repository = repository;
    }

    public double calcularTotal(double subtotal, String codigoDescuento, boolean envioExpress){
        double descuento = repository.getPercentage(codigoDescuento);
        double envio = envioExpress ? 20.0 : 10.0;
        return (subtotal * (1- descuento)) + envio;
    }
}
