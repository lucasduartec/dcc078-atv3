import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    Pedido pedido;

    public ClienteTest() {
    }

    @Test
    void deveNotificarUmCliente() {
        Pedido Pedido = new Pedido("001");
        Cliente Cliente = new Cliente("Cliente 1");
        Cliente.acompanharPedido(Pedido);
        Pedido.solicitar();
        Pedido.iniciarPreparacao();
        Pedido.iniciarEntrega();
        Assertions.assertEquals("Cliente 1, pedido 001 saiu para entrega.", Cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido Pedido = new Pedido("002");
        Cliente Cliente1 = new Cliente("Cliente 1");
        Cliente Cliente2 = new Cliente("Cliente 2");
        Cliente1.acompanharPedido(Pedido);
        Cliente2.acompanharPedido(Pedido);
        Pedido.solicitar();
        Pedido.iniciarPreparacao();
        Pedido.iniciarEntrega();
        Assertions.assertEquals("Cliente 1, pedido 002 saiu para entrega.", Cliente1.getUltimaNotificacao());
        Assertions.assertEquals("Cliente 2, pedido 002 saiu para entrega.", Cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Pedido Pedido = new Pedido("003");
        Cliente Cliente = new Cliente("Cliente 1");
        Pedido.solicitar();
        Pedido.iniciarPreparacao();
        Pedido.iniciarEntrega();
        Assertions.assertEquals((Object) null, Cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientePedidoA() {
        Pedido PedidoA = new Pedido("004");
        Pedido PedidoB = new Pedido("005");
        Cliente Cliente1 = new Cliente("Cliente 1");
        Cliente Cliente2 = new Cliente("Cliente 2");
        Cliente1.acompanharPedido(PedidoA);
        Cliente2.acompanharPedido(PedidoB);
        PedidoA.solicitar();
        PedidoA.iniciarPreparacao();
        PedidoA.iniciarEntrega();
        Assertions.assertEquals("Cliente 1, pedido 004 saiu para entrega.", Cliente1.getUltimaNotificacao());
        Assertions.assertEquals((Object) null, Cliente2.getUltimaNotificacao());
    }
}
