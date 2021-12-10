package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class A02Moving {
    public static void main(String[] args) {
        Path pp = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "moving.txt");
        A02Moving move = new A02Moving();
        try(BufferedReader br  = Files.newBufferedReader(pp)){
            System.out.println("Táv és mélység szorzata: "+ move.readLines(br));
        } catch(IOException ioe){
            throw new IllegalArgumentException("..áá@ÁÁ", ioe);
        }
    }

    private int readLines(BufferedReader br) throws IOException{
        int horizontal = 0;
        int depth = 0;
        int change = 0;
        int aim = 0;
        String line;
        while((line = br.readLine()) != null){
            if (line.contains("forward")){
                change = Integer.parseInt( line.substring( line.indexOf('d') + 1 ).trim() );
                horizontal += change;
                depth += aim * change;
            }
            else if (line.contains("down")){
                aim += Integer.parseInt( line.substring( line.indexOf('n') + 1 ).trim() );
            }
            else if (line.contains("up")){
                aim -= Integer.parseInt( line.substring( line.indexOf('p') + 1 ).trim() );
            }
            else {
                System.out.println("Rossz sor: " + line);
            }
        }
        System.out.println("horizontal * depth " + horizontal +" * "+ depth);
        return horizontal * depth;
    }

}
