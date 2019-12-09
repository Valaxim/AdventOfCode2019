package d08;

import utils.ParseUtil;

import java.io.IOException;

public class Day8 {

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        Layer layer = new Layer();

        int[] input = parser.readFileWithoutDelimeter("inputDay8.txt");
        layer.calculatePartOne(input);
        int[] ints = layer.calculatePartTwo(input);
        layer.printLayer(ints);
    }

}
