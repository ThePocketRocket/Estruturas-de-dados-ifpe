package pilha;

public class No<T> {
    private T valor;
    private No<T> topo;

    public No (T valor) {
        this.valor = valor;
        this.topo = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getTopo() {
        return topo;
    }

    public void setTopo(No<T> topo) {
        this.topo = topo;
    }
}