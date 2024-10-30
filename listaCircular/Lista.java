package listaCircular;

public class Lista {
    private No ref;

    public Lista() {
        this.ref = null;
    }

    public void insere(int info) {
        No no = new No(info);

        // Se a lista estiver vazia, insere
        if (ref == null) {
            no.setProx(no);
            ref = no;
            return;
        }

        // Se a infomação a ser adicionada for menor que a primeira infomação da lista
        if (no.getInfo() < ref.getProx().getInfo()) {
            no.setProx(ref.getProx());
            ref.setProx(no);
            return;
        }

        for (No aux = ref.getProx(); aux != ref; aux = aux.getProx()) {
            // Casos normais
            if (no.getInfo() < aux.getProx().getInfo()) {
                no.setProx(aux.getProx());
                aux.setProx(no);
                break;
            }
        }

        // Se a informação for maior que a maior informação
        if (no.getInfo() >= ref.getInfo()) {
            no.setProx(ref.getProx());
            ref.setProx(no);
            ref = no;
        }
    }

    public void remove(int info, boolean duplicados) {
        // Se não estiver vazia
        if (ref != null) {
            for (No aux = ref.getProx(); aux != null; aux = aux.getProx()) {
                if (aux.getInfo() > info) break;

                // Se for o único índice da lista
                if (aux == aux.getProx()) {
                    ref = null;
                    break;
                }

                // Se for o primeiro índice
                if (aux == ref.getProx()) {
                    ref.setProx(aux.getProx());
                    break;
                }

                // Se for um índice do meio
                if (aux.getProx().getInfo() == info) {
                    if (aux.getProx() != ref) {
                        aux.getProx().setProx(aux.getProx().getProx());
                        break;
                    } else {
                        aux.getProx().setProx(aux.getProx().getProx());
                        ref = aux;
                        break;
                    }
                }
            }
        }
    }

    public String imprime() {
        if (ref == null) {
            return "lista vazia";
        }

        String strList = "";
        for (No aux = ref.getProx(); aux != ref; aux = aux.getProx()) {
            strList += aux.getInfo() + " ";
        }
        strList += ref.getInfo();
        return strList;
    }
}