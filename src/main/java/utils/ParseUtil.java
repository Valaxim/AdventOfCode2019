package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
        return arrays;
    }
}
