package EstruturasDeDados;

public class TabelaHash<T> implements TabelaHash_IF<T> {

    private Object[] tabela;
    private int capacidade;
    private int tamanho;
    private final Object DELETADO = new Object();

    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new Object[capacidade];
        this.tamanho = 0;
    }

    private int hash(T elemento) {
        return Math.abs(elemento.hashCode()) % capacidade;
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
    public boolean isfull() {
        return tamanho == capacidade;
    }

    @Override
    public void insert(T elemento) {
        if (isfull()) {
            throw new IllegalStateException("Tabela Hash cheia");
        }

        int pos = hash(elemento);
        int tentativas = 0;

        while (tabela[pos] != null && tabela[pos] != DELETADO) {
            if (tabela[pos].equals(elemento)) {
                return; // já existe, não insere duplicado
            }
            pos = (pos + 1) % capacidade;
            tentativas++;
            if (tentativas >= capacidade) {
                throw new IllegalStateException("Tabela Hash cheia (loop)");
            }
        }

        tabela[pos] = elemento;
        tamanho++;
    }

    @Override
    public void remove(T elemento) {
        int pos = hash(elemento);
        int tentativas = 0;

        while (tabela[pos] != null) {
            if (tabela[pos] != DELETADO && tabela[pos].equals(elemento)) {
                tabela[pos] = DELETADO;
                tamanho--;
                return;
            }
            pos = (pos + 1) % capacidade;
            tentativas++;
            if (tentativas >= capacidade) {
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T search(T elemento) {
        int pos = hash(elemento);
        int tentativas = 0;

        while (tabela[pos] != null) {
            if (tabela[pos] != DELETADO && tabela[pos].equals(elemento)) {
                return (T) tabela[pos];
            }
            pos = (pos + 1) % capacidade;
            tentativas++;
            if (tentativas >= capacidade) {
                break;
            }
        }
        return null;
    }

    @Override
    public int indexOf(T elemento) {
        int pos = hash(elemento);
        int tentativas = 0;

        while (tabela[pos] != null) {
            if (tabela[pos] != DELETADO && tabela[pos].equals(elemento)) {
                return pos;
            }
            pos = (pos + 1) % capacidade;
            tentativas++;
            if (tentativas >= capacidade) {
                break;
            }
        }
        return -1;
    }
}
