package com.ejemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PedidoServiceMockTest {

    @Test
    void testConMockDeDescuento() {
        DiscountRepository mockRepo = mock(DiscountRepository.class);
        when(mockRepo.getPercentage("PROMO10")).thenReturn(0.10);

        PedidoService service = new PedidoService(mockRepo);
        double total = service.calcularTotal(100, "PROMO10", true);

        assertEquals(110.0, total);
    }
}