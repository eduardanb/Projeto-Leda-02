# Projeto-Leda-02
## Visão Geral

Evolução do T2-Projeto Passwords com novas estruturas de dados: Este projeto implementa três estruturas de dados fundamentais em Java: Pilha, Lista e Árvore Binária, utilizadas para classificação e processamento de senhas. 
* Árvore Binária para classificação eficiente
* Pilha para gerenciamento de transformações
* Lista Encadeada para processamento dinâmico

## Estruturas Implementadas
1. Pilha (Stack)
   LIFO (Last-In-First-Out)

* Finalidade: Gerenciar transformações de dados (ex.: conversão de datas).

* Implementação: Pilha.java (array com tamanho fixo).


* Operações Principais:

        push(T element) → Adiciona no topo (O(1))

        pop() → Remove do topo (O(1))

        peek() → Consulta o topo (O(1))
* Exemplo de Uso:

        java Pilha<String> pilha = new Pilha<>(10);  
        pilha.push("Senha1");  
        String topo = pilha.pop(); // "Senha1"


2. Lista (List)
Lista Dinâmica Baseada em Array

* Finalidade: Armazenar senhas durante processamento.


* Implementação: MinhaLista.java (redimensionamento automático).


* Ordenação flexível (tamanho, data, mês).


* Operações Principais:

        adicionar(T elemento) → Adiciona no fim (O(1) amortizado)

        remover(int indice) → Remove por posição (O(n))

        obter(int indice) → Acesso direto (O(1))

* Exemplo de Uso:

        java MinhaLista<Password> senhas = new MinhaLista<>();  
        senhas.adicionar(new Password("abc123"));  
        Password p = senhas.obter(0);


3. Árvore Binária (Binary Tree)
   BST (Binary Search Tree)

* Finalidade: Classificação eficiente de senhas por critérios.


* Implementação: ArvoreBinaria.java.


* Busca eficiente em grandes volumes de dados.


* Operações Principais:

        inserir(K chave, V valor) → O(log n)

        buscar(K chave) → O(log n)

        percorrerEmOrdem() → Retorna elementos ordenados

* Exemplo de Uso:

        java ArvoreBinaria<String, Password> arvore = new ArvoreBinaria<>();  
        arvore.inserir("Boa", new Password("SenhaForte@123"));  
        Password encontrada = arvore.buscar("Boa"); 


## Integração no Projeto
As estruturas são utilizadas nos seguintes módulos:


| Estrutura       | Classe de Uso           | Aplicação                          |
|-----------------|-------------------------|-----------------------------------|
| Pilha          | TransformadorDeDados    | Conversão de formatos (datas)     |
| Lista          | LerArquivosCsv          | Armazenamento temporário          |
| Árvore Binária | ClassificacaoDeSenhas   | Organização hierárquica           |

##  Comparação de Desempenho

| Operação   | Pilha | Lista       | Árvore    |
|------------|-------|-------------|-----------|
| Inserção   | O(1)  | O(1)*       | O(log n)  |
| Busca      | O(n)  | O(n)        | O(log n)  |
| Remoção    | O(1)  | O(n)        | O(log n)  |
| Ordenação  | N/A   | N/A         | O(n)      |



## Guia de Implementação
### Fluxo Principal
    java
    MinhaLista<Password> dadosBrutos = new CsvReader().carregar("entrada.csv");
    ArvoreBinaria<String, Password> dadosClassificados = new Classificador().processar(dadosBrutos);
    Pilha<Password> dadosTransformados = new Transformador().converterParaTimestamp(dadosClassificados);
### Configuração do Ambiente


    git clone https://github.com/leda-project/gerenciador-senhas.git
    javac -d bin src/main/java//*.java
    java -cp bin Main classificar senhas.csv --critério=seguranca
## Exemplo de Caso de Uso
    java
    public class ProcessadorSenhas {
    public static void main(String[] args) { 

    Extração
    MinhaLista<Senha> bancoDados = new LerArquivosCsv()
    .ler("dados/senhas_2023.csv");
    
    Classificação
            ArvoreBinaria<String, Senha> arvore = new ClassificacaoDeSenhas()
                .porNivelSeguranca(bancoDados);

    Pós-processamento
            Pilha<Senha> historico = new TransformadorDeDados()
                .empilharPorData(arvore.listarEmOrdem());

    Exportação
            historico.exportar("output/senhas_processadas.json");
        }
    }

## Estrutura do projeto


    Projecto-Leda-02/  
    ├── .idea/                     # Configurações do IntelliJ  
    ├── DadosDeEntrada/            # Arquivos de entrada  
    │   └── passwords.csv          # Dados brutos das senhas  
    ├── out/                       # Saída compilada  
    │   └── production/  
    │       └── Projecto-LEDA/  
    │           ├── ArquivosCSV/   # Resultados processados  
    │           │   ├── password_classifier.csv  
    │           │   ├── passwords_classifier.csv  
    │           │   └── passwords_formated_data.csv  
    │           └── ArquivosCSVOrdenados/  
    ├── src/                       # Código-fonte  
    │   ├── Controllers/           # Lógica principal  
    │   │   ├── ClassificacaoBoaeMultoboa.java  
    │   │   ├── ClassificacaoDeSenhas.java  
    │   │   ├── LerArquivosCsv.java  
    │   │   └── TransformadorDeDados.java  
    │   ├── Algorithms/            # Algoritmos de ordenação  
    │   │   ├── CountingSort/  
    │   │   ├── HeapSort/  
    │   │   ├── QuickSortMedianas/  
    │   │   └── SelectionSort/  
    │   └── Model.EstruturasDeDados/ # Estruturas personalizadas  
    │       ├── ArvoreBinaria.java  
    │       ├── Pilha.java  
    │       └── Lista_IF.java  
    ├── .classpath                 # Configuração do Eclipse  
    ├── .gitignore                 # Arquivos ignorados pelo Git  
    └── Main.java                  # Ponto de entrada  

Colaboradores: [Maria Eduarda da Nóbrega, João Victor da Silva Almeida Guimarães e Adrielly Carla Ferreira de Melo]

Link do Relatório (usar email institucional): https://docs.google.com/document/d/1GNFJbCi61TcjFmMhDJg45nBveEifvDYAxZ2nKPeuJKY/edit?usp=sharing