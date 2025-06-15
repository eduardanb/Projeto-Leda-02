package Controllers;

import Model.EstruturasDeDados.Algoritmos.CountingSort.*;
import Model.EstruturasDeDados.Algoritmos.HeapSort.*;
import Model.EstruturasDeDados.Algoritmos.InsectionSort.*;
import Model.EstruturasDeDados.Algoritmos.MergeSort.*;
import Model.EstruturasDeDados.Algoritmos.QuickSort.*;
import Model.EstruturasDeDados.Algoritmos.QuickSortMediana3.*;
import Model.EstruturasDeDados.Algoritmos.SelectionSort.*;
import java.io.*;

public class OrdenacaoDataCrescente {
    static long TempoTotalCountingMedioCaso = 0;
    static long TempoTotalCountingPiorCaso = 0;
    static long TempoTotalCountingMelhorCaso = 0;
    static long TempoTotalMergeMelhorCaso = 0;
    static long TempoTotalMergePiorCaso = 0;
    static long TempoTotalMergeMedioCaso = 0;
    static long TempoTotalQuickMedianaDe3MelhorCaso = 0;
    static long TempoTotalQuickMedianaDe3PiorCaso = 0;
    static long TempoTotalQuickMedianaDe3MedioCaso = 0;
    static long TempoTotalSelectionMelhorCaso = 0;
    static long TempoTotalSelectionPiorCaso = 0;
    static long TempoTotalSelectionMedioCaso = 0;
    static long TempoTotalQuickMelhorCaso = 0;
    static long TempoTotalQuickPiorCaso = 0;
    static long TempoTotalQuickMedioCaso = 0;
    static long TempoTotalHeapSortMelhorCaso = 0;
    static long TempoTotalHeapSortPiorCaso = 0;
    static long TempoTotalHeapSortMedioCaso = 0;
    static long TempoTotalInsectionSortMelhorCaso = 0;
    static long TempoTotalInsectionSortPiorCaso = 0;
    static long TempoTotalInsectionSortMedioCaso = 0;


    public static void Ordenacao(String[] args) {

        String EntradaCSV = "Projeto-LEDA\\DadosDeEntrada\\passwords_formated_data.csv";
        String SaidaMedioCasoCounting = "Projeto-LEDA\\DadosFinais\\passwords_data_countingSort_medioCaso.csv";
        String SaidaPiorCasoCounting = "Projeto-LEDA\\DadosFinais\\passwords_data_countingSort_piorCaso.csv";
        String SaidaMelhorCasoCounting = "Projeto-LEDA\\DadosFinais\\passwords_data_countingSort_melhorCaso.csv";

        try {
            // Chamada para o método de ordenação Counting Sort
            long Inicio = System.nanoTime();
            CountingMedioCaso.CountingSortCSVData(EntradaCSV, SaidaMedioCasoCounting);
            long Fim = System.nanoTime();
            TempoTotalCountingMedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMedioCasoCounting);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        try {
            // Chamada para o método de ordenação Counting Sort
            long Inicio = System.nanoTime();
            CountingPiorCaso.CountingSortCSVData(EntradaCSV, SaidaPiorCasoCounting);
            long Fim = System.nanoTime();
            TempoTotalCountingPiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaPiorCasoCounting);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        try {
            // Chamada para o método de ordenação Counting Sort
            long Inicio = System.nanoTime();
            CountingMelhorCaso.CountingSortCSVData(EntradaCSV, SaidaMelhorCasoCounting);
            long Fim = System.nanoTime();
            TempoTotalCountingMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMelhorCasoCounting);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        // Selection Sort - Melhor Caso
        String SaidaSelectionMelhorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_selectionSort_melhorCaso.csv";
        try {
            // Chamada para o método de ordenação Selection Sort
            long Inicio = System.nanoTime();
            SelectionMelhorCaso.SelectionCSVData(EntradaCSV, SaidaSelectionMelhorCaso);
            long Fim = System.nanoTime();
            TempoTotalSelectionMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaSelectionMelhorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        // Selection Sort - Pior Caso
        String SaidaSelectionPiorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_selectionSort_piorCaso.csv";
        try {
            // Chamada para o método de ordenação Selection Sort
            long Inicio = System.nanoTime();
            SelectionPiorCaso.SelectionCSVData(EntradaCSV, SaidaSelectionPiorCaso);
            long Fim = System.nanoTime();
            TempoTotalSelectionPiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaSelectionPiorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        // Selection Sort - Médio Caso
        String SaidaSelectionMedioCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_selectionSort_medioCaso.csv";
        try {
            // Chamada para o método de ordenação Selection Sort
            long Inicio = System.nanoTime();
            SelectionMedioCaso.SelectionCSVData(EntradaCSV, SaidaSelectionMedioCaso);
            long Fim = System.nanoTime();
            TempoTotalSelectionMedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaSelectionMedioCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        
        String SaidaMedioCasoMerge = "Projeto-LEDA\\DadosFinais\\passwords_data_mergeSort_medioCaso.csv";
        String SaidaPiorCasoMerge = "Projeto-LEDA\\DadosFinais\\passwords_data_mergeSort_piorCaso.csv";
        String SaidaMelhorCasoMerge = "Projeto-LEDA\\DadosFinais\\passwords_data_mergeSort_melhorCaso.csv";

        try {
            // Chamada para o método de ordenação Merge Sort
            long Inicio = System.nanoTime();
            MergeMedioCaso.mergeSortCSVData(EntradaCSV, SaidaMedioCasoMerge);
            long Fim = System.nanoTime();
            TempoTotalMergeMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMedioCasoMerge);
            
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        try {
            // Chamada para o método de ordenação Merge Sort
            long Inicio = System.nanoTime();
            MergePiorCaso.mergeSortCSVData(EntradaCSV, SaidaPiorCasoMerge);
            long Fim = System.nanoTime();
            TempoTotalMergeMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaPiorCasoMerge);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        try {
            // Chamada para o método de ordenação Merge Sort
            long Inicio = System.nanoTime();
            MergeMelhorCaso.mergeSortCSVData(EntradaCSV, SaidaMelhorCasoMerge);
            long Fim = System.nanoTime();
            TempoTotalMergeMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMelhorCasoMerge);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        // Quick Sort mediana 3
        String SaidaMedioCasoQuick = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSortmedianade3_medioCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            Quick3MedioCaso.QuickSort3CSVData(EntradaCSV, SaidaMedioCasoQuick);
            long Fim = System.nanoTime();
            TempoTotalQuickMedianaDe3MedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMedioCasoQuick);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        String SaidaPiorCasoQuick = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSortmedianade3_piorCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            Quick3PiorCaso.QuickSort3CSVData(EntradaCSV, SaidaPiorCasoQuick);
            long Fim = System.nanoTime();
            TempoTotalQuickMedianaDe3PiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaPiorCasoQuick);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        String SaidaMelhorCasoQuick = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSortmedianade3_melhorCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            Quick3MelhorCaso.QuickSort3CSVData(EntradaCSV, SaidaMelhorCasoQuick);
            long Fim = System.nanoTime();
            TempoTotalQuickMedianaDe3MelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaMelhorCasoQuick);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Quick Sort - Melhor Caso
        String SaidaQuickMelhorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSort_melhorCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            QuickMelhorCaso.quickSortCSVData(EntradaCSV, SaidaQuickMelhorCaso);
            long Fim = System.nanoTime();
            TempoTotalQuickMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaQuickMelhorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Quick Sort - Pior Caso
        String SaidaQuickPiorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSort_piorCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            QuickPiorCaso.quickSortCSVData(EntradaCSV, SaidaQuickPiorCaso);
            long Fim = System.nanoTime();
            TempoTotalQuickPiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaQuickPiorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Quick Sort - Médio Caso
        String SaidaQuickMedioCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_quickSort_medioCaso.csv";
        try {
            // Chamada para o método de ordenação Quick Sort
            long Inicio = System.nanoTime();
            QuickMedioCaso.quickSortCSVData(EntradaCSV, SaidaQuickMedioCaso);
            long Fim = System.nanoTime();
            TempoTotalQuickMedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaQuickMedioCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Heap Sort - Melhor Caso
        String SaidaHeapSortMelhorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_heapSort_melhorCaso.csv";
        try {
            // Chamada para o método de ordenação Heap Sort
            long Inicio = System.nanoTime();
            HeapMelhorCaso.heapSortCSVData(EntradaCSV, SaidaHeapSortMelhorCaso);
            long Fim = System.nanoTime();
            TempoTotalHeapSortMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaHeapSortMelhorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Heap Sort - Pior Caso
        String SaidaHeapSortPiorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_heapSort_piorCaso.csv";
        try {
            // Chamada para o método de ordenação Heap Sort
            long Inicio = System.nanoTime();
            HeapPiorCaso.heapSortCSVData(EntradaCSV, SaidaHeapSortPiorCaso);
            long Fim = System.nanoTime();
            TempoTotalHeapSortPiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaHeapSortPiorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Heap Sort - Médio Caso
        String SaidaHeapSortMedioCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_heapSort_medioCaso.csv";
        try {
            // Chamada para o método de ordenação Heap Sort
            long Inicio = System.nanoTime();
            HeapMedioCaso.heapSortCSVData(EntradaCSV, SaidaHeapSortMedioCaso);
            long Fim = System.nanoTime();
            TempoTotalHeapSortMedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaHeapSortMedioCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Insection Sort - Melhor Caso
        String SaidaInsectionSortMelhorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_insectionSort_melhorCaso.csv";
        try {
            // Chamada para o método de ordenação Insection Sort
            long Inicio = System.nanoTime();
            InsectionMelhorCaso.insertionSortCSVData(EntradaCSV, SaidaInsectionSortMelhorCaso);
            long Fim = System.nanoTime();
            TempoTotalInsectionSortMelhorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaInsectionSortMelhorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

        //Insection Sort - Pior Caso
        String SaidaInsectionSortPiorCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_insectionSort_piorCaso.csv";
        try {
            // Chamada para o método de ordenação Insection Sort
            long Inicio = System.nanoTime();
            InsectionPiorCaso.insertionSortCSVData(EntradaCSV, SaidaInsectionSortPiorCaso);
            long Fim = System.nanoTime();
            TempoTotalInsectionSortPiorCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaInsectionSortPiorCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        
        //Insection Sort - Médio Caso
        String SaidaInsectionSortMedioCaso = "Projeto-LEDA\\DadosFinais\\passwords_data_insectionSort_medioCaso.csv";
        try {
            // Chamada para o método de ordenação Insection Sort
            long Inicio = System.nanoTime();
            InsectionMedioCaso.insertionSortCSVData(EntradaCSV, SaidaInsectionSortMedioCaso);
            long Fim = System.nanoTime();
            TempoTotalInsectionSortMedioCaso = Fim - Inicio;
            System.out.println("Arquivo ordenado com sucesso e salvo em: " + SaidaInsectionSortMedioCaso);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }

    }

    public static void TempoDeExecucao() {
        System.out.println("Tempo de execução de cada algoritmo quando ordenados pela coluna data: \n" +
            "Counting Sort Medio Caso: " + TempoTotalCountingMedioCaso + " ns\n" +
            "Counting Sort Pior Caso: " + TempoTotalCountingPiorCaso + " ns\n" +
            "Counting Sort Melhor Caso: " + TempoTotalCountingMelhorCaso + " ns\n" +
            "Merge Sort Melhor Caso: " + TempoTotalMergeMelhorCaso + " ns\n" +
            "Merge Sort Pior Caso: " + TempoTotalMergePiorCaso + " ns\n" +
            "Merge Sort Medio Caso: " + TempoTotalMergeMedioCaso + " ns\n"+
            "Quick Sort Melhor Caso: " + TempoTotalQuickMelhorCaso + " ns\n" +
            "Quick Sort Pior Caso: " + TempoTotalQuickPiorCaso + " ns\n" +
            "Quick Sort Medio Caso: " + TempoTotalQuickMedioCaso + " ns\n" +
            "Quick Sort Mediana de 3 Melhor Caso: " + TempoTotalQuickMedianaDe3MelhorCaso + " ns\n" +
            "Quick Sort Mediana de 3 Pior Caso: " + TempoTotalQuickMedianaDe3PiorCaso + " ns\n" +
            "Quick Sort Mediana de 3 Medio Caso: " + TempoTotalQuickMedianaDe3MedioCaso + " ns\n" +
            "Selection Sort Melhor Caso: " + TempoTotalSelectionMelhorCaso + " ns\n" +
            "Selection Sort Pior Caso: " + TempoTotalSelectionPiorCaso + " ns\n" +
            "Selection Sort Medio Caso: " + TempoTotalSelectionMedioCaso + " ns\n" +
            "Heap Sort Melhor Caso: " + TempoTotalHeapSortMelhorCaso + " ns\n" +
            "Heap Sort Pior Caso: " + TempoTotalHeapSortPiorCaso + " ns\n" +
            "Heap Sort Medio Caso: " + TempoTotalHeapSortMedioCaso + " ns\n" +
            "Insection Sort Melhor Caso: " + TempoTotalInsectionSortMelhorCaso + " ns\n" +
            "Insection Sort Pior Caso: " + TempoTotalInsectionSortPiorCaso + " ns\n" +
            "Insection Sort Medio Caso: " + TempoTotalInsectionSortMedioCaso + " ns\n" +
            "----------------------------------------\n");
    }
}
