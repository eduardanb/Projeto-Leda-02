package EstruturasDeDados;

public interface Lista_IF<T> {
    void adicionar(T elemento);
    void adicionar(int indice, T elemento);
    T obter(int indice);
    void remover(int indice);
    boolean contem(T elemento);
    int tamanho();
    boolean vazia();
    void limpar();
}