package pilha;

public class TestePilha {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<>();
        
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.imprimir();
        System.out.println();
        pilha.empilhar(1);
        pilha.desempilhar();
        pilha.empilhar(2);
        pilha.empilhar(3);
        pilha.imprimir();
    }
}
