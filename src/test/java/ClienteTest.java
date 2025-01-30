import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    Pedido pedido;

    @Test
    void deveNotificarUmCliente() {
        Pedido Pedido = new Pedido("001");
        Cliente Cliente = new Cliente("Cliente 1");
        Cliente.solicitarPedido(Pedido);
        Pedido.solicitar();
        assertEquals("Cliente 1, pedido 001 solicitado.", Cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido Pedido = new Pedido("002");
        Cliente Cliente1 = new Cliente("Cliente 1");
        Cliente Cliente2 = new Cliente("Cliente 2");
        Cliente1.solicitarPedido(Pedido);
        Cliente2.solicitarPedido(Pedido);
        Pedido.solicitar();
        assertEquals("Cliente 1, pedido 002 solicitado.", Cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, pedido 002 solicitado.", Cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido Pedido = new Pedido("003");
        Cliente Cliente = new Cliente("Cliente 1");
        Pedido.solicitar();
        assertEquals(null, Cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientePedidoA() {
        Pedido PedidoA = new Pedido("004");
        Pedido PedidoB = new Pedido("005");
        Cliente Cliente1 = new Cliente("Cliente 1");
        Cliente Cliente2 = new Cliente("Cliente 2");
        Cliente1.solicitarPedido(PedidoA);
        Cliente2.solicitarPedido(PedidoB);
        PedidoA.solicitar();
        assertEquals("Cliente 1, pedido 004 solicitado.", Cliente1.getUltimaNotificacao());
        assertEquals(null, Cliente2.getUltimaNotificacao());
    }


}