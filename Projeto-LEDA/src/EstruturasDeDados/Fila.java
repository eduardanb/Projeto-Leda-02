package EstruturasDeDados;

public class Fila<T> implements Fila_IF<T> {

    private T[] fila;
    private int tamanho;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isFull() {
        return tamanho == capacidade;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }
        fila[tamanho] = element;
        tamanho++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        T elemento = fila[0];
        // Deslocar todos os elementos uma posição para frente
        for (int i = 0; i < tamanho - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[tamanho - 1] = null;
        tamanho--;
        return elemento;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return fila[0];
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].equals(element)) {
                return i;
            }
        }
        return -1; // Retorna -1 se não encontrar
    }
}

