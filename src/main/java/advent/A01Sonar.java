package advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class A01Sonar {
    private final List<Integer> measures = new ArrayList<>();

    public static void main(String[] args) {
        Path pp = Path.of("c:", "training", "miscellaneous", "src", "main", "resources", "advent", "sonar.txt");
        A01Sonar sonar = new A01Sonar();
        try(BufferedReader br  = Files.newBufferedReader(pp)){
            System.out.println("Emelkedések száma: "+ sonar.readLines(br));
            System.out.println("Átlagok növekedése: " + sonar.averages(br));
        } catch(IOException ioe){
            System.out.println("IOEx");
        }
    }

    private int readLines(BufferedReader br) throws IOException {
        int sum = 0;
        int actual = 0;
        int before = 0;
        String line;
        while( (line = br.readLine()) != null ){
            actual = Integer.parseInt(line.trim());
            measures.add(actual);
            if(actual > before){
                sum++;
            }
            before = actual;
        }
        return sum - 1;  //because of the first
    }

    private int averages(BufferedReader br) throws IOException{
        int sum = 0;
        int actual = 0;
        int before = 0;
        for(int i = 0; i < measures.size() - 2; i++){
            actual = measures.get(i) + measures.get(i + 1) + measures.get(i + 2);
            if(actual > before){
                sum++;
            }
            before = actual;
        }
        return sum - 1;
    }

}
