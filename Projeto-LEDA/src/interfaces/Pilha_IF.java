public interface Pilha_IF {
    
    public boolean isEmpty();
    public int size();
    public boolean isFull();
    public void push(T element);
    public T pop();
    public T peek();
    public int indexOf(T element);
    
}
