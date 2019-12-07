package d01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\adamg\\Desktop\\Projects\\AdventofCode2019\\src\\main\\resources\\inputDay1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int resultPart1=0, resultPart2 = 0;
        Rocket r = new Rocket();
        String st;
        while ((st = br.readLine()) != null) {
            resultPart1 += r.calculateFuel(Integer.parseInt(st));
            resultPart2 += r.extendedCalculateFuel(Integer.parseInt(st));
        }
        System.out.println("Day1 Part1 answer: " + resultPart1);
        System.out.println("Day1 Part2 answer: " + resultPart2);
    }
}

