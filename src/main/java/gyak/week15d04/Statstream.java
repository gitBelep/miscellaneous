package gyak.week15d04;
//Count by using streams in a text wowels, consonants and other things except of spaces.
// EZ  egy      (azaz: 1_db)
//   próbafile!
//else:  No:  \n
//       Yes: tab 9, ( 40, : 58, 1 49, _ 95, ) 41, ! 33

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statstream {
    static final String WOWEL = "aáeéiíoóöőuúüű";

    public void printLetterStat(String fileName) {
        Stream<String> stream = readFile( fileName );
        Map<String, Long> result = countLetters( stream );
        System.out.println( result.toString() );
    }

    private Stream<String> readFile(String file) {
        try {
            Path path = Path.of("src", "main", "resources", file);
            return Files.lines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }
        return null;
    }

    private Map<String, Long> countLetters(Stream<String> str) {
        return str.map(s -> s.toLowerCase())  //lines
                .flatMapToInt(s -> s.chars()) //int stream
                .filter(i -> i != (int) ' ')  //non space
                .mapToObj(i -> getType(i))    //Stream<String>
                .collect(Collectors.groupingBy(  //into Map
                        Function.identity(), Collectors.counting())); //s -> s
    }

    private String getType(int i) {
        if (Character.isLetter(i)) {
            if (WOWEL.contains(String.valueOf((char) i))) {
                return "wowels";
            }
            return "consonants";
        }
        System.out.println("else: " + (char) i +" "+ i);
        return "else but not space";
    }


    public static void main(String[] args) {
        String fileName = "week15d04stream.txt";
        new Statstream().printLetterStat(fileName);
    }

}
