package com.ejemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    DiscountRepository mockRepo = mock(DiscountRepository.class);
    OrderService service = new OrderService(mockRepo);

    @BeforeEach
    void setUp(){
        when(mockRepo.getPercentage("PROMO10")).thenReturn(0.10);
    }

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, "", false);
        assertEquals(110.0, total);
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total);
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, "", true);
        assertEquals(220.0, total);
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, "", true);
        assertEquals(170.0, total);
    }
}