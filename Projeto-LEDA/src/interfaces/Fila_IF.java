public interface Fila_IF {
    
    public boolean isEmpty();
    public int size();
    public boolean isFull();
    public void enqueue(T element);
    public T dequeue();
    public T peek();
    public int indexOf(T element);
}
