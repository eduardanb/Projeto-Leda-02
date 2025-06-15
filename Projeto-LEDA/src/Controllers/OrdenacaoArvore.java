package Controllers;

import Model.EstruturasDeDados.Algoritmos.Arvore.BinaryTreeSort;
import java.io.IOException;

public class OrdenacaoArvore {
    private static long tempoTotalArvore = 0;

    public static void Ordenacao(String[] args) {
        String entradaCSV = "Projeto-LEDA\\DadosFinais\\passwords_formated_data.csv";

        String saidaArvoreBinariaMonth = "Projeto-LEDA\\DadosFinais\\passwords_data_month_Arvore_Binaria.csv";
        String saidaArvoreBinariaLength = "Projeto-LEDA\\DadosFinais\\passwords_length_Arvore_Binaria.csv";
        String saidaArvoreBinariaData = "Projeto-LEDA\\DadosFinais\\passwords_data_Arvore_Binaria.csv";

        // Ordenação por data
        medirTempoOrdenacao(() -> {
            try {
                BinaryTreeSort.BinaryTreeSortCSVData(entradaCSV, saidaArvoreBinariaData);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por data: " + e.getMessage(), e);
            }
        }, "Data", saidaArvoreBinariaData);

        // Ordenação por mês
        medirTempoOrdenacao(() -> {
            try {
                BinaryTreeSort.BinaryTreeSortCSVMes(entradaCSV, saidaArvoreBinariaMonth);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por mês: " + e.getMessage(), e);
            }
        }, "Mês", saidaArvoreBinariaMonth);

        // Ordenação por length
        medirTempoOrdenacao(() -> {
            try {
                BinaryTreeSort.BinaryTreeSortCSVLength(entradaCSV, saidaArvoreBinariaLength);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por length: " + e.getMessage(), e);
            }
        }, "Length", saidaArvoreBinariaLength);

        System.out.println("\nTempo total de ordenação com Árvore Binária: " + formatarTempo(tempoTotalArvore));
    }

    private static void medirTempoOrdenacao(Runnable operacao, String tipo, String caminhoSaida) {
        try {
            System.out.println("\nIniciando ordenação por " + tipo + "...");
            long inicio = System.nanoTime();

            operacao.run();

            long fim = System.nanoTime();
            long duracao = fim - inicio;
            tempoTotalArvore += duracao;

            System.out.println("Arquivo ordenado por " + tipo + " com sucesso!");
            System.out.println("Salvo em: " + caminhoSaida);
            System.out.println("Tempo de execução: " + formatarTempo(duracao));
        } catch (Exception e) {
            System.err.println("Erro ao processar ordenação por " + tipo + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String formatarTempo(long nanos) {
        if (nanos < 1000) {
            return nanos + " ns";
        }

        double micros = nanos / 1000.0;
        if (micros < 1000) {
            return String.format("%.2f µs", micros);
        }

        double millis = micros / 1000.0;
        if (millis < 1000) {
            return String.format("%.2f ms", millis);
        }

        double seconds = millis / 1000.0;
        return String.format("%.2f s", seconds);
    }
}