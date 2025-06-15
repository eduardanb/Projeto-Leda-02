package Model.EstruturasDeDados;

import java.lang.reflect.Array;

public class ArvoreBinaria<K extends Comparable<K>, V> implements ArvoreBinaria_IF<K, V> {

    // Classe interna para os nós da árvore
    protected class No implements ArvoreBinaria_IF.NoArvore<K, V> {
        private K chave;
        private V valor;
        private No esquerda;
        private No direita;

        public No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public K getChave() {
            return chave;
        }

        @Override
        public V getValor() {
            return valor;
        }

        @Override
        public No getEsquerda() {
            return esquerda;
        }

        @Override
        public void setEsquerda(ArvoreBinaria_IF.NoArvore<K, V> esquerda) {
            this.esquerda = (No) esquerda;
        }

        @Override
        public No getDireita() {
            return direita;
        }

        @Override
        public void setDireita(ArvoreBinaria_IF.NoArvore<K, V> direita) {
            this.direita = (No) direita;
        }
    }

    protected No raiz;
    private int tamanho = 0;

    // ======================== Operações básicas ========================

    @Override
    public No getRaiz() {
        return raiz;
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

        int cmp = chave.compareTo(no.getChave());
        if (cmp < 0) {
            no.setEsquerda(inserir(no.getEsquerda(), chave, valor));
        } else if (cmp > 0) {
            no.setDireita(inserir(no.getDireita(), chave, valor));
        } else {
            no.valor = valor; // Atualiza valor se chave já existir
        }
        return no;
    }

    @Override
    public V buscar(K chave) {
        No no = buscar(raiz, chave);
        return no == null ? null : no.getValor();
    }

    private No buscar(No no, K chave) {
        if (no == null) return null;

        int cmp = chave.compareTo(no.getChave());
        if (cmp < 0) return buscar(no.getEsquerda(), chave);
        else if (cmp > 0) return buscar(no.getDireita(), chave);
        else return no;
    }

    @Override
    public boolean contem(K chave) {
        return buscar(raiz, chave) != null;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean vazia() {
        return tamanho == 0;
    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    // ======================== Remoção ========================

    @Override
    public void remover(K chave) {
        raiz = remover(raiz, chave);
    }

    private No remover(No no, K chave) {
        if (no == null) return null;

        int cmp = chave.compareTo(no.getChave());
        if (cmp < 0) {
            no.setEsquerda(remover(no.getEsquerda(), chave));
        } else if (cmp > 0) {
            no.setDireita(remover(no.getDireita(), chave));
        } else {
            // Nó com apenas um filho ou nenhum
            if (no.getEsquerda() == null) {
                tamanho--;
                return no.getDireita();
            } else if (no.getDireita() == null) {
                tamanho--;
                return no.getEsquerda();
            }

            // Nó com dois filhos: pegar o sucessor (menor da direita)
            No sucessor = encontrarMinimo(no.getDireita());
            no.chave = sucessor.getChave();
            no.valor = sucessor.getValor();
            no.setDireita(remover(no.getDireita(), sucessor.getChave()));
        }
        return no;
    }

    private No encontrarMinimo(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    // ======================== Percursos ========================

    @Override
    public String percorrerEmOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerEmOrdem(raiz, sb);
        return sb.toString().trim();
    }

    private void percorrerEmOrdem(No no, StringBuilder sb) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda(), sb);
            sb.append(no.getChave()).append(" ");
            percorrerEmOrdem(no.getDireita(), sb);
        }
    }

    @Override
    public String percorrerPreOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerPreOrdem(raiz, sb);
        return sb.toString().trim();
    }

    private void percorrerPreOrdem(No no, StringBuilder sb) {
        if (no != null) {
            sb.append(no.getChave()).append(" ");
            percorrerPreOrdem(no.getEsquerda(), sb);
            percorrerPreOrdem(no.getDireita(), sb);
        }
    }

    @Override
    public String percorrerPosOrdem() {
        StringBuilder sb = new StringBuilder();
        percorrerPosOrdem(raiz, sb);
        return sb.toString().trim();
    }

    private void percorrerPosOrdem(No no, StringBuilder sb) {
        if (no != null) {
            percorrerPosOrdem(no.getEsquerda(), sb);
            percorrerPosOrdem(no.getDireita(), sb);
            sb.append(no.getChave()).append(" ");
        }
    }

    // ======================== Percorrer em array ========================

    @Override
    @SuppressWarnings("unchecked")
    public V[] percorrerEmOrdemArray() {
        if (raiz == null) return (V[]) new Object[0];

        V[] array = (V[]) Array.newInstance(raiz.getValor().getClass(), tamanho);
        int[] index = {0};
        percorrerEmOrdemArray(raiz, array, index);
        return array;
    }

    private void percorrerEmOrdemArray(No no, V[] array, int[] index) {
        if (no != null) {
            percorrerEmOrdemArray(no.getEsquerda(), array, index);
            array[index[0]++] = no.getValor();
            percorrerEmOrdemArray(no.getDireita(), array, index);
        }
    }
}
