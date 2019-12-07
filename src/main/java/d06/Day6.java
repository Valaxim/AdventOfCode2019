package d06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
        List<Orbit> list = getOrbits();
        calculatePartOne(list);
        calculatePartTwo(list);
    }

    private static void calculatePartTwo(List<Orbit> list) {
        List<Orbit> elementsYOU = getElements(list, list.stream().filter(it -> "YOU".equals(it.getValue())).findFirst().orElse(null), null);
        List<Orbit> elementsSAN = getElements(list, list.stream().filter(it -> "SAN".equals(it.getValue())).findFirst().orElse(null), null);

        int repeat = 0;
        for (Orbit orbit : elementsYOU) {
            if (elementsSAN.contains(orbit)) {
                repeat++;
            }
        }

        int repeat2 = 0;
        for (Orbit orbit : elementsSAN) {
            if (elementsYOU.contains(orbit)) {
                repeat2++;
            }
        }
        System.out.println("Answer part two: " + (elementsSAN.size() - repeat + elementsYOU.size() - repeat2 - 2));
    }

    private static List<Orbit> getOrbits() throws IOException {
        File file = new File("C:\\Users\\adamg\\Desktop\\Projects\\AdventofCode2019\\src\\main\\resources\\inputDay6.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<Orbit> list = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            String[] split1 = st.split("\\)");
            list.add(new Orbit(split1[0], split1[1]));
        }
        return list;
    }

    private static void calculatePartOne(List<Orbit> list) {
        int sum = 0;
        for (Orbit x : list) {
            sum = getSum(list, sum, x);
        }
        System.out.println("Answer part one: " + sum);
    }

    private static List<Orbit> getElements(List<Orbit> list, Orbit x, List<Orbit> output) {
        if (output == null) {
            output = new ArrayList<>();
        }
        output.add(x);
        Orbit x1 = list.stream().filter(it -> it.getValue().equals(x.getKey())).findAny().orElse(null);
        if (x1 != null) {
            Orbit x2 = list.stream().filter(it -> it.getValue().equals(x.getKey())).findFirst().orElse(null);
            return getElements(list, x2, output);
        }
        return output;
    }

    private static int getSum(List<Orbit> list, int sum, Orbit x) {
        Orbit x1 = list.stream().filter(it -> it.getValue().equals(x.getKey())).findAny().orElse(null);
        if (x1 != null) {
            Orbit x2 = list.stream().filter(it -> it.getValue().equals(x.getKey())).findFirst().orElse(null);
            return getSum(list, sum + 1, x2);
        } else {
            sum++;
        }
        return sum;
    }

}


