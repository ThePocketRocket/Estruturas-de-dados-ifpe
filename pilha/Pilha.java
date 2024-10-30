package pilha;

public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar (T valor) {
        No<T> no = new No<>(valor);
        no.setTopo(this.topo);
        this.topo = no;
    }

    public void desempilhar () {
        if (this.topo != null) this.topo = this.topo.getTopo();
    }

    public void imprimir() {
        if (this.topo == null) {
            System.out.println("Pilha vazia.");
            return;
        }

        for (No<T> aux = this.topo; aux != null; aux = aux.getTopo()) {
            System.out.println(aux.getValor());
        }
    }
}
