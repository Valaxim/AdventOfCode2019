package d10;

import utils.ParseUtil;

import java.io.IOException;

public class Day10 {

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        char[][] input = parser.read2DArray("inputDay10.txt");
        AsteroidsDetection asteroidsDetection = new AsteroidsDetection();
        asteroidsDetection.run(input);
    }
}