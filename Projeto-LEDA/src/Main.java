import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Controllers.ClassificacaoBoaeMuitoboa;
import Controllers.ClassificacaoDeSenhas;
import Controllers.Classificador;
import Controllers.LerArquivosCsv;
import Controllers.TransformadorDeDados;
import Controllers.OrdenacaoDataCrescente;
import Controllers.OrdenacaoLengthDecrescente;
import Controllers.OrdenacaoPorMesCrescente;

public class Main {
    public static void main(String[] args) {
    
        String caminhoEntrada = "Projeto-LEDA\\DadosDeEntrada\\passwords.csv";
        String caminhoSaida = "Projeto-LEDA\\DadosFinais\\password_classifier.csv";
        String caminhoTransformado = "Projeto-LEDA\\DadosFinais\\passwords_formated_data.csv";
        String caminhoBoaeMuitoBoa = "Projeto-LEDA\\DadosFinais\\passwords_classifier.csv";
        
        LerArquivosCsv leitorCsv = new LerArquivosCsv(caminhoEntrada);
        Classificador classificador = new ClassificacaoDeSenhas();

        try {
            // Leitura do arquivo CSV original
            String[] registros = leitorCsv.lerCsv();
            BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoSaida));
            
            escritor.write("Posicao,Senha,Tamanho,Data,Class\n");

            // Iteração do CSV
            for (int i = 1; i < registros.length; i++) {
                String linha = registros[i];
                String[] registro = linha.split(",");
                if (registro.length < 4) {
                    // Ignoramos linhas inválidas
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                // Classificação das senhas
                String senha = registro[1];
                String classificacao = classificador.classificar(senha);
                escritor.write(registro[0] + "," + senha + "," + registro[2] + "," + registro[3] + "," + classificacao + "\n");
            }

            escritor.close();


            ClassificacaoBoaeMuitoboa classificacaoBoaeMuitoboa = new ClassificacaoBoaeMuitoboa();
            TransformadorDeDados transformador = new TransformadorDeDados();
            transformador.transformar(caminhoSaida, caminhoTransformado);

            classificacaoBoaeMuitoboa.classificar(caminhoSaida, caminhoBoaeMuitoBoa);

            exibirArquivo(caminhoBoaeMuitoBoa);

            OrdenacaoLengthDecrescente.Ordenacao(args);
            OrdenacaoDataCrescente.Ordenacao(args);
            OrdenacaoPorMesCrescente.Ordenacao(args);

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        OrdenacaoLengthDecrescente.TempoDeExecucao();
        OrdenacaoDataCrescente.TempoDeExecucao();
        OrdenacaoPorMesCrescente.TempoDeExecucao();
    }
    

    // Função para exibir um arquivo linha por linha no console
    private static void exibirArquivo(String caminhoArquivo) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            System.out.println("\nConteúdo do arquivo gerado (" + caminhoArquivo + "):");
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
