package EstruturasDeDados;

public class ArvoreBinaria<K extends Comparable<K>, V> implements ArvoreBinaria_IF<K, V> {
    private No raiz;
    private int tamanho;

    private class No {
        K chave;
        V valor;
        No esquerda;
        No direita;

        public No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    @Override
    public void inserir(K chave, V valor) {
        raiz = inserir(raiz, chave, valor);
    }

    private No inserir(No no, K chave, V valor) {
        if (no == null) {
            tamanho++;
            return new No(chave, valor);
        }

        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            no.esquerda = inserir(no.esquerda, chave, valor);
        } else if (cmp > 0) {
            no.direita = inserir(no.direita, chave, valor);
        } else {
            no.valor = valor; // Atualiza valor se chave já existe
        }
        return no;
    }

    @Override
    public V buscar(K chave) {
        No no = buscar(raiz, chave);
        return no == null ? null : no.valor;
    }

    private No buscar(No no, K chave) {
        if (no == null) return null;

        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) return buscar(no.esquerda, chave);
        else if (cmp > 0) return buscar(no.direita, chave);
        else return no;
    }

    @Override
    public void remover(K chave) {
        raiz = remover(raiz, chave);
    }

    private No remover(No no, K chave) {
        if (no == null) return null;

        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            no.esquerda = remover(no.esquerda, chave);
        } else if (cmp > 0) {
            no.direita = remover(no.direita, chave);
        } else {
            if (no.direita == null) {
                tamanho--;
                return no.esquerda;
            }
            if (no.esquerda == null) {
                tamanho--;
                return no.direita;
            }

            No temp = no;
            no = min(temp.direita);
            no.direita = removerMin(temp.direita);
            no.esquerda = temp.esquerda;
            tamanho--;
        }
        return no;
    }

    private No min(No no) {
        if (no.esquerda == null) return no;
        else return min(no.esquerda);
    }

    private No removerMin(No no) {
        if (no.esquerda == null) return no.direita;
        no.esquerda = removerMin(no.esquerda);
        return no;
    }

    @Override
    public boolean contem(K chave) {
        return buscar(chave) != null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return raiz == null;
    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    @Override
    public String percorrerEmOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerEmOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerEmOrdem(No no, StringBuilder sb) {
        if (no != null) {
            percorrerEmOrdem(no.esquerda, sb);
            sb.append(no.chave).append(" ");
            percorrerEmOrdem(no.direita, sb);
        }
    }

    @Override
    public String percorrerPreOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerPreOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerPreOrdem(No no, StringBuilder sb) {
        if (no != null) {
            sb.append(no.chave).append(" ");
            percorrerPreOrdem(no.esquerda, sb);
            percorrerPreOrdem(no.direita, sb);
        }
    }

    @Override
    public String percorrerPosOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerPosOrdem(raiz, sb);
        return sb.toString();
    }

    private void percorrerPosOrdem(No no, StringBuilder sb) {
        if (no != null) {
            percorrerPosOrdem(no.esquerda, sb);
            percorrerPosOrdem(no.direita, sb);
            sb.append(no.chave).append(" ");
        }
    }
}