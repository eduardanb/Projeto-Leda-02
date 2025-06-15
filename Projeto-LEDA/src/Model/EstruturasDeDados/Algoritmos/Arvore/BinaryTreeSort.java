package Model.EstruturasDeDados.Algoritmos.Arvore;

import Model.EstruturasDeDados.ArvoreBinaria;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class BinaryTreeSort {

    public static void BinaryTreeSortCSVLength(String inputFilePath, String outputFilePath) throws IOException {
        processCSVWithTree(inputFilePath, outputFilePath, 2, false);
    }

    public static void BinaryTreeSortCSVData(String inputFilePath, String outputFilePath) throws IOException {
        String[] lines = readCSV(inputFilePath);
        if (lines.length == 0) {
            System.err.println("Arquivo CSV vazio.");
            return;
        }

        String header = lines[0];
        String[] dataLines = Arrays.copyOfRange(lines, 1, lines.length);

        ArvoreBinaria<Long, Integer> tree = new ArvoreBinaria<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                LocalDate data = LocalDate.parse(campos[3], formatter);
                tree.inserir(data.toEpochDay(), i);
            } catch (DateTimeParseException e) {
                System.err.println("Erro na linha " + (i + 2) + ": " + campos[3]);
                tree.inserir(0L, i);
            }
        }

        Integer[] indices = new Integer[dataLines.length];
        int[] contador = new int[1]; // Para controlar a posição no array
        percorrerEmOrdem(tree, indices, contador);

        writeCSV(outputFilePath, header, dataLines, indices);
    }

    public static void BinaryTreeSortCSVMes(String inputFilePath, String outputFilePath) throws IOException {
        String[] lines = readCSV(inputFilePath);
        if (lines.length == 0) {
            System.err.println("Arquivo CSV vazio.");
            return;
        }

        String header = lines[0];
        String[] dataLines = Arrays.copyOfRange(lines, 1, lines.length);

        ArvoreBinaria<Long, Integer> tree = new ArvoreBinaria<>();

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                String[] partes = campos[3].split("/");
                long mes = Long.parseLong(partes[1]);
                tree.inserir(mes, i);
            } catch (Exception e) {
                System.err.println("Erro na linha " + (i + 2) + ": " + campos[3]);
                tree.inserir(0L, i);
            }
        }

        Integer[] indices = new Integer[dataLines.length];
        int[] contador = new int[1];
        percorrerEmOrdem(tree, indices, contador);

        writeCSV(outputFilePath, header, dataLines, indices);
    }

    private static void processCSVWithTree(String inputFilePath, String outputFilePath, int columnIndex, boolean reverse) throws IOException {
        String[] lines = readCSV(inputFilePath);
        if (lines.length == 0) {
            System.err.println("Arquivo CSV vazio.");
            return;
        }

        String header = lines[0];
        String[] dataLines = Arrays.copyOfRange(lines, 1, lines.length);

        ArvoreBinaria<Long, Integer> tree = new ArvoreBinaria<>();

        for (int i = 0; i < dataLines.length; i++) {
            String[] campos = dataLines[i].split(",");
            try {
                long valor = Long.parseLong(campos[columnIndex]);
                tree.inserir(valor, i);
            } catch (NumberFormatException e) {
                System.err.println("Valor inválido na linha " + (i + 2) + ": " + campos[columnIndex]);
                tree.inserir(0L, i);
            }
        }

        Integer[] indices = new Integer[dataLines.length];
        int[] contador = new int[1];
        percorrerEmOrdem(tree, indices, contador);

        if (reverse) {
            reverseArray(indices);
        }

        writeCSV(outputFilePath, header, dataLines, indices);
    }

    // Percorre a árvore e preenche o array de índices
    private static void percorrerEmOrdem(ArvoreBinaria<Long, Integer> tree, Integer[] indices, int[] contador) {
        percorrerRec(tree.getRaiz(), indices, contador);
    }

    private static void percorrerRec(ArvoreBinaria.NoArvore<Long, Integer> no, Integer[] indices, int[] contador) {
        if (no == null) return;

        percorrerRec(no.getEsquerda(), indices, contador);
        indices[contador[0]] = no.getValor();
        contador[0]++;
        percorrerRec(no.getDireita(), indices, contador);
    }

    private static void reverseArray(Integer[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    private static String[] readCSV(String inputFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
        int linhas = 0;
        while (br.readLine() != null) {
            linhas++;
        }
        br.close();

        String[] lines = new String[linhas];
        br = new BufferedReader(new FileReader(inputFilePath));
        String line;
        int contador = 0;
        while ((line = br.readLine()) != null) {
            lines[contador++] = line;
        }
        br.close();

        return lines;
    }

    private static void writeCSV(String outputFilePath, String header, String[] lines, Integer[] indices) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));

        bw.write(header);
        bw.newLine();

        for (Integer index : indices) {
            if (index != null && index >= 0 && index < lines.length) {
                bw.write(lines[index]);
                bw.newLine();
            }
        }

        bw.close();
    }
}
