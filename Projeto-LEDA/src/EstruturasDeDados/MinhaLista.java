package EstruturasDeDados;

import java.util.Arrays;

public class MinhaLista<T> implements Lista_IF<T> {
    private Object[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    public MinhaLista() {
        elementos = new Object[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    @Override
    public void adicionar(T elemento) {
        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }
        elementos[tamanho++] = elemento;
    }

    @Override
    public void adicionar(int indice, T elemento) {
        if (indice < 0 || indice > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }

        System.arraycopy(elementos, indice, elementos, indice + 1, tamanho - indice);
        elementos[indice] = elemento;
        tamanho++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return (T) elementos[indice];
    }

    @Override
    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        int elementosParaMover = tamanho - indice - 1;
        if (elementosParaMover > 0) {
            System.arraycopy(elementos, indice + 1, elementos, indice, elementosParaMover);
        }

        elementos[--tamanho] = null; // Libera referência para garbage collection
    }

    @Override
    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elemento.equals(elementos[i])) {
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < tamanho; i++) {
            elementos[i] = null;
        }
        tamanho = 0;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, novaCapacidade);
    }
}