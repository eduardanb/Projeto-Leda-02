package EstruturasDeDados;

public interface TabelaHash_IF<T> {
    
    public boolean isEmpty();
    public int size();
    public boolean isfull();
    public void insert(T element);
    public void remove(T element);
    public T search(T element);
    public int indexOf(T element);
    
}