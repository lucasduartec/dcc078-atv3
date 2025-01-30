import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void solicitarPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        Pedido p = (Pedido) pedido;
        this.ultimaNotificacao = this.nome + ", pedido " + p.getCodigo() + " solicitado.";
        // System.out.println(this.ultimaNotificacao);
    }
}
