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
        return this.estado;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean solicitar() {
        return this.estado.solicitar(this);
    }

    public boolean iniciarPreparacao() {
        return this.estado.iniciarPreparacao(this);
    }

    public boolean iniciarEntrega() {
        this.setChanged();
        this.notifyObservers();
        return this.estado.iniciarEntrega(this);
    }

    public boolean entregar() {
        return this.estado.entregar(this);
    }

    public boolean cancelar() {
        return this.estado.cancelar(this);
    }
}
