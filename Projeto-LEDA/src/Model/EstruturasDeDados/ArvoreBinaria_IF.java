package Model.EstruturasDeDados;

public interface ArvoreBinaria_IF<K extends Comparable<K>, V> {
    // Métodos básicos
    void inserir(K chave, V valor);
    V buscar(K chave);
    void remover(K chave);
    boolean contem(K chave);
    int tamanho();
    boolean vazia();
    void limpar();

    // Percursos
    String percorrerEmOrdem();
    String percorrerPreOrdem();
    String percorrerPosOrdem();

    // Novos métodos de acesso
    NoArvore<K, V> getRaiz();
    V[] percorrerEmOrdemArray();

    // Interface para o nó da árvore
    interface NoArvore<K, V> {
        K getChave();
        V getValor();
        NoArvore<K, V> getEsquerda();
        NoArvore<K, V> getDireita();
        void setEsquerda(NoArvore<K, V> esquerda);
        void setDireita(NoArvore<K, V> direita);
    }
}