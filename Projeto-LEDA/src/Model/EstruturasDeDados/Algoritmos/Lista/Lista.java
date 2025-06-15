package Model.EstruturasDeDados.Algoritmos.Lista;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Lista {

    // ========================= Por Length =========================

    public static void ListaCSVLength(String inputFilePath, String outputFilePath) throws IOException {
        processCSV(inputFilePath, outputFilePath, 2, false);
    }

    // ========================= Por Data =========================

    public static void ListaCSVData(String inputFilePath, String outputFilePath) throws IOException {
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
        writeCSV(outputFilePath, header, dataLines, indices);
    }

    // ========================= Por Mês =========================

    public static void ListaCSVMes(String inputFilePath, String outputFilePath) throws IOException {
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
        writeCSV(outputFilePath, header, dataLines, indices);
    }

    // ========================= Função Genérica =========================

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

        if (reverse) {
            reverseArray(indices);
        }

        writeCSV(outputFilePath, header, dataLines, indices);
    }

    // ========================= Métodos Auxiliares =========================

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

    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

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
