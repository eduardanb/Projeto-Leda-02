package Controllers;

import Model.EstruturasDeDados.Algoritmos.Lista.Lista;

import java.io.IOException;

public class OrdenacaoLista {
    private static long tempoTotalLista = 0;

    public static void Ordenacao(String[]args){
        String entradaCSV = "Projeto-LEDA\\DadosFinais\\passwords_formated_data.csv";

        String saidaListaMes = "Projeto-LEDA\\DadosFinais\\passwords_data_month_Lista.csv";
        String saidaListaData = "Projeto-LEDA\\DadosFinais\\passwords_data_Lista.csv";
        String saidaListaLength = "Projeto-LEDA\\DadosFinais\\passwords_data_length_Lista.csv";

        // Ordenação por data
        medirTempoOrdenacao(() -> {
            try {
                Lista.ListaCSVData(entradaCSV, saidaListaData);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por data: " + e.getMessage(), e);
            }
        }, "Data", saidaListaData);

        // Ordenação por mês
        medirTempoOrdenacao(() -> {
            try {
                Lista.ListaCSVMes(entradaCSV, saidaListaMes);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por mês: " + e.getMessage(), e);
            }
        }, "Mês", saidaListaMes);

        // Ordenação por tamanho (length)
        medirTempoOrdenacao(() -> {
            try {
                Lista.ListaCSVLength(entradaCSV, saidaListaLength);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ordenar por length: " + e.getMessage(), e);
            }
        }, "Length", saidaListaLength);

        System.out.println("\nTempo total de ordenação com Lista: " + formatarTempo(tempoTotalLista));
    }

    private static void medirTempoOrdenacao(Runnable operacao, String tipo, String caminhoSaida) {
        try {
            System.out.println("\nIniciando ordenação por " + tipo + "...");
            long inicio = System.nanoTime();

            operacao.run();

            long fim = System.nanoTime();
            long duracao = fim - inicio;
            tempoTotalLista += duracao;

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
