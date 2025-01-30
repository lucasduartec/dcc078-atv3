import java.util.Observable;

public class Pedido extends Observable {

    private String codigo;
    private PedidoEstado estado;

    public Pedido(String codigo) {
        this.codigo = codigo;
        this.estado = PedidoEstadoSolicitado.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean solicitar() {
        setChanged();
        notifyObservers();
        return estado.solicitar(this);
    }

    public boolean iniciarPreparacao() {
        return estado.iniciarPreparacao(this);
    }

    public boolean iniciarEntrega() {
        return estado.iniciarEntrega(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

}