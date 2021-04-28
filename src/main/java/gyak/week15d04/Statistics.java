package gyak.week15d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {
    private Map<String, Integer> stat;
    private String fileName;
    private StringBuilder otherLetters = new StringBuilder();
    int counter = 0;

    public Statistics(String fileName) {
        this.fileName = fileName;
        stat = new LinkedHashMap<>();
        stat.put("wowel", 0);
        stat.put("mshz", 0);
        stat.put("space", 0);
        stat.put("other", 0);
    }

    public void makeStatistics() {
        readFile();
        writeFile();
    }

    private void readFile() {
        Path path = Path.of("src", "main", "resources", fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                countLetters(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void countLetters(String line) {
        int wowel = 0;
        String wowels = "aáeéiíoóöőuúüű";
        int mshz = 0;
        String mshzk = "qwrtzpsdfghjklyxcvbnm";
        int space = 0;
        int other = 0;
        for (char c : line.toCharArray()) {
            if (wowels.contains(Character.toString(c).toLowerCase())) {
                wowel++;
            }
            else if (mshzk.contains(String.valueOf(c).toLowerCase())) {
                mshz++;
            }
            else if (c == ' ') {
                space++;
            } else{
                other++;
                counter++;
                otherLetters.append(c);
                if(counter >= 70){
                    otherLetters.append("\n");
                    counter = 0;
                }
            }

        }
        stat.put("wowel", stat.get("wowel") + wowel);
        stat.put("mshz", stat.get("mshz") + mshz);
        stat.put("space", stat.get("space") + space);
        stat.put("other", stat.get("other") + other);
    }

    private void writeFile() {
        int h = fileName.length();
        StringBuilder sb = new StringBuilder(fileName);
        String outputFileName = sb.insert(h - 4, "_stat").toString();
        Path output = Path.of("src", "main", "resources", outputFileName);
        Charset u = StandardCharsets.UTF_8;
        StandardOpenOption oo = StandardOpenOption.CREATE;
        try (BufferedWriter bw = Files.newBufferedWriter(output, u, oo)) {
            writeLines(bw);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private void writeLines(BufferedWriter bw) throws IOException {
        int sum = 0;
        for (Map.Entry<String, Integer> e : stat.entrySet()) {
            sum += e.getValue();
            String row = e.getKey() + ": " + e.getValue().toString() + ";\n";
            bw.write(row);
        }
        bw.write("sum: "+ sum +"\n");
        bw.write(otherLetters.toString());
    }

    public static void main(String[] args) {
//        String fileName = "eretts-2020-10_lista.txt";
//        String fileName = "upperChar.txt";
        String fileName = "week14d02_shoppinglist.txt";
        new Statistics(fileName).makeStatistics();
    }

}
