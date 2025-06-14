package EstruturasDeDados;


public interface ArvoreBinaria_IF<K extends Comparable<K>, V> {
    void inserir(K chave, V valor);
    V buscar(K chave);
    void remover(K chave);
    boolean contem(K chave);
    int tamanho();
    boolean vazia();
    void limpar();
    String percorrerEmOrdem();
    String percorrerPreOrdem();
    String percorrerPosOrdem();
}