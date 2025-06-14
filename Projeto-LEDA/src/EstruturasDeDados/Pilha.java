package EstruturasDeDados;

public class Pilha<T> implements Pilha_IF<T> {

    private T[] pilha;
    private int topo;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = (T[]) new Object[capacidade];
        this.topo = -1; // Pilha começa vazia
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @Override
    public int size() {
        return topo + 1;
    }

    @Override
    public boolean isFull() {
        return topo == capacidade - 1;
    }

    @Override
    public void push(T element) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        }
        topo++;
        pilha[topo] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T elemento = pilha[topo];
        pilha[topo] = null; // Limpa a posição
        topo--;
        return elemento;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return pilha[topo];
    }

    @Override
    public int indexOf(T element) {
        for (int i = topo; i >= 0; i--) {
            if (pilha[i].equals(element)) {
                return i;
            }
        }
        return -1; // Não encontrado
    }
}

