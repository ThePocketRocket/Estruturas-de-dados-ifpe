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
            for (No aux = ref.getProx(); aux != ref; aux = aux.getProx()) {
                if (aux.getInfo() > info) return;

                // Se for o primeiro índice
                if (aux == ref.getProx() && aux.getInfo() == info) {
                    ref.setProx(aux.getProx());
                    if (!duplicados) break;
                    aux = ref;
                    continue;
                }

                // Se for um índice do meio
                if (aux.getProx().getInfo() == info) {
                    if (aux.getProx() != ref) {
                        aux.setProx(aux.getProx().getProx());
                        if (!duplicados) break;
                        aux = ref.getProx();
                    } else {
                        aux.setProx(aux.getProx().getProx());
                        ref = aux;
                        break;
                    }
                }
            }
            // Se for o único índice da lista
            if (ref.getProx() == ref.getProx().getProx() && ref.getProx().getInfo() == info) {
                ref = null;
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