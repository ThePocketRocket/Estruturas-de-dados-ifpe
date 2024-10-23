public class Lista<T> {
    private No<T> ref;

    public Lista() {
        this.ref = null;
    }

    public void inserir(T valor) {
        No<T> no = new No<>(valor);
        no.setProx(ref);
        this.ref = no;
    }

    public void imprimir() {
        if (ref == null) {
            System.out.println("Lista Vazia.");
            return;
        }

        if (ref.getProx() == null) {
            System.out.println(ref.getValor());
            return;
        }

        for (No<T> aux = ref; aux.getProx() != null; aux = aux.getProx()) {
            System.out.println(aux.getValor());
            if (aux.getProx().getProx() == null) {
                System.out.println(aux.getProx().getValor());
            }
        }
    }
}
