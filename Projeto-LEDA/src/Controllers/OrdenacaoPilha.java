package Controllers;

import Model.EstruturasDeDados.Algoritmos.Pilha.MinhaPilha;

import java.io.IOException;

public class OrdenacaoPilha {
    private static long tempoTotalPilha = 0;

    public static void Ordenacao(String[]args){
        String entradaCSV = "Projeto-LEDA\\DadosFinais\\passwords_formated_data.csv";

        String SaidaPilhaMes = "Projeto-LEDA\\DadosFinais\\passwords_data_month_Pilha.csv";
        String SaidaPilhaData = "Projeto-LEDA\\DadosFinais\\passwords_data_Pilha.csv";
        String SaidaPilhaLength = "Projeto-LEDA\\DadosFinais\\passwords_data_length_Pilha.csv";


        // Ordenação por data
        medirTempoOrdenacao(() -> {
            try {
                MinhaPilha.PilhaCSVData(entradaCSV, SaidaPilhaData);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por data: " + e.getMessage(), e);
            }
        }, "Data", SaidaPilhaData);

        // Ordenação por mês
        medirTempoOrdenacao(() -> {
            try {
                MinhaPilha.PilhaCSVMes(entradaCSV, SaidaPilhaMes);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por mês: " + e.getMessage(), e);
            }
        }, "Mês", SaidaPilhaMes);

        // Ordenação por length
        medirTempoOrdenacao(() -> {
            try {
                MinhaPilha.PilhaCSVLength(entradaCSV, SaidaPilhaLength);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por length: " + e.getMessage(), e);
            }
        }, "Length", SaidaPilhaLength);

        System.out.println("\nTempo total de ordenação com Pilha: " + formatarTempo(tempoTotalPilha));
    }

    private static void medirTempoOrdenacao(Runnable operacao, String tipo, String caminhoSaida) {
        try {
            System.out.println("\nIniciando ordenação por " + tipo + "...");
            long inicio = System.nanoTime();

            operacao.run();

            long fim = System.nanoTime();
            long duracao = fim - inicio;
            tempoTotalPilha += duracao;

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
