package Model.EstruturasDeDados.Algoritmos.Pilha;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class MinhaPilha {

    // ==================== Por Length ====================
    public static void PilhaCSVLength(String inputFilePath, String outputFilePath) throws IOException {
        processCSV(inputFilePath, outputFilePath, 2, false);
    }

    // ==================== Por Data ====================
    public static void PilhaCSVData(String inputFilePath, String outputFilePath) throws IOException {
        String[] linhas = readCSV(inputFilePath);
        String header = linhas[0];
        String[] dataLines = Arrays.copyOfRange(linhas, 1, linhas.length);

        long[] keys = new long[dataLines.length];
        int[] indices = new int[dataLines.length];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                String dataStr = campos[3];
                LocalDate data = LocalDate.parse(dataStr, formatter);
                keys[i] = data.toEpochDay();
            } catch (DateTimeParseException e) {
                System.err.println("Erro na linha " + (i + 2) + ": " + campos[3]);
                keys[i] = 0L;
            }
            indices[i] = i;
        }

        insertionSort(keys, indices);

        int[] pilha = empilhar(indices);
        int[] ordenado = desempilhar(pilha);

        writeCSV(outputFilePath, header, dataLines, ordenado);
    }

    // ==================== Por Mês ====================
    public static void PilhaCSVMes(String inputFilePath, String outputFilePath) throws IOException {
        String[] linhas = readCSV(inputFilePath);
        String header = linhas[0];
        String[] dataLines = Arrays.copyOfRange(linhas, 1, linhas.length);

        long[] keys = new long[dataLines.length];
        int[] indices = new int[dataLines.length];

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                String dataStr = campos[3];
                String[] partes = dataStr.split("/");
                keys[i] = Long.parseLong(partes[1]); // mês
            } catch (Exception e) {
                System.err.println("Erro na linha " + (i + 2) + ": " + campos[3]);
                keys[i] = 0L;
            }
            indices[i] = i;
        }

        insertionSort(keys, indices);

        int[] pilha = empilhar(indices);
        int[] ordenado = desempilhar(pilha);

        writeCSV(outputFilePath, header, dataLines, ordenado);
    }

    // ==================== Função Genérica ====================
    private static void processCSV(String inputFilePath, String outputFilePath, int columnIndex, boolean reverse) throws IOException {
        String[] linhas = readCSV(inputFilePath);
        String header = linhas[0];
        String[] dataLines = Arrays.copyOfRange(linhas, 1, linhas.length);

        long[] keys = new long[dataLines.length];
        int[] indices = new int[dataLines.length];

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                keys[i] = Long.parseLong(campos[columnIndex]);
            } catch (NumberFormatException e) {
                System.err.println("Valor inválido na linha " + (i + 2) + ": " + campos[columnIndex]);
                keys[i] = 0L;
            }
            indices[i] = i;
        }

        insertionSort(keys, indices);

        int[] pilha = empilhar(indices);
        int[] ordenado = desempilhar(pilha);

        writeCSV(outputFilePath, header, dataLines, ordenado);
    }

    // ==================== Métodos Auxiliares ====================

    // Insertion Sort
    private static void insertionSort(long[] keys, int[] indices) {
        for (int i = 1; i < keys.length; i++) {
            long chave = keys[i];
            int indice = indices[i];
            int j = i - 1;

            while (j >= 0 && keys[j] > chave) {
                keys[j + 1] = keys[j];
                indices[j + 1] = indices[j];
                j--;
            }
            keys[j + 1] = chave;
            indices[j + 1] = indice;
        }
    }

    // Simula empilhar os índices
    private static int[] empilhar(int[] indices) {
        int[] pilha = new int[indices.length];
        int topo = -1;

        for (int i = 0; i < indices.length; i++) {
            pilha[++topo] = indices[i];
        }

        return pilha;
    }

    // Simula desempilhar (inverte a ordem)
    private static int[] desempilhar(int[] pilha) {
        int[] resultado = new int[pilha.length];

        int topo = pilha.length - 1;
        int i = 0;

        while (topo >= 0) {
            resultado[i++] = pilha[topo--];
        }

        return resultado;
    }

    // Ler CSV
    private static String[] readCSV(String inputFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        int totalLinhas = 0;

        while (br.readLine() != null) {
            totalLinhas++;
        }
        br.close();

        String[] lines = new String[totalLinhas];
        br = new BufferedReader(new FileReader(inputFilePath));
        String line;
        int rowCount = 0;
        while ((line = br.readLine()) != null) {
            lines[rowCount++] = line;
        }
        br.close();

        return lines;
    }

    // Escrever CSV
    private static void writeCSV(String outputFilePath, String header, String[] lines, int[] indices) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
        if (header != null) {
            bw.write(header);
            bw.newLine();
        }

        for (int index : indices) {
            bw.write(lines[index]);
            bw.newLine();
        }
        bw.close();
    }
}
