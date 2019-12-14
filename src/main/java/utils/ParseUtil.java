package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public int[] readInputContainsIntegers(String fileName) throws IOException {
        String fullFilePath = "C:\\Users\\adamg\\Desktop\\Projects\\AdventOfCode2019\\src\\main\\resources\\" + fileName;
        File file = new File(fullFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int[] arrays = new int[0];
        while ((st = br.readLine()) != null) {
            String[] split = st.split(",");
            arrays = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        return arrays;
    }

    public int[] readFileWithoutDelimeter(String fileName) throws IOException {
        String fullFilePath = "C:\\Users\\adamg\\Desktop\\Projects\\AdventOfCode2019\\src\\main\\resources\\" + fileName;
        File file = new File(fullFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int[] arrays = new int[0];
        while ((st = br.readLine()) != null) {
            arrays = st.chars()
                    .map(x -> x - '0')
                    .toArray();
        }
        br.close();
        return arrays;
    }

    public char[][] read2DArray(String fileName) throws IOException {
        String fullFilePath = "C:\\Users\\adamg\\Desktop\\Projects\\AdventOfCode2019\\src\\main\\resources\\" + fileName;
        File file = new File(fullFilePath);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        List<String> rowsArray = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            rowsArray.add(st);
        }
        br.close();

        char[][] arrays = new char[rowsArray.size()][rowsArray.get(0).length()];
        for (int i = 0; i < rowsArray.size(); i++) {
            String s = rowsArray.get(i);

            for (int j = 0; j < s.length(); j++) {
                arrays[i][j] = s.charAt(j);
            }
        }
        return arrays;
    }
}
