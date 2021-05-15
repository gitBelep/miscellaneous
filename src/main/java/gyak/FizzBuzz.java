package misc;

public class FizzBuzz {
    private static final int FIZZ_NR = 5;
    private static final int BUZZ_NR = 11;
    private static final int START_NR = -23;
    private static final int END_NR = 2341;
    private static final int NR_OF_COLUMNS = 24;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
// Making an object without "new":     //FizzBuzz fb = new FizzBuzz();
        Class cl = null;
        cl = Class.forName("misc.FizzBuzz");
        FizzBuzz fb =  (FizzBuzz) cl.newInstance();

        fb.consolFizzBuzz();
    }

    public void consolFizzBuzz(){
        String fixPlaceholder = makeFixPlaceholder();

        for (int i = START_NR; i <= END_NR; i++){
            if( i % FIZZ_NR == 0 && i % BUZZ_NR == 0){
                System.out.print(fixPlaceholder +"(fb)");
            }
            else if(i % FIZZ_NR == 0) {
                System.out.print(fixPlaceholder +" (f)");
            } else if(i % BUZZ_NR == 0){
                System.out.print(fixPlaceholder +" (b)");
            }else{
                System.out.print( makeDinamicPlaceholder(i) + i);
            }
            beginANewLine(i);
        }
    }

    private String makeDinamicPlaceholder(int actualNr){
        int actualNrSize = (""+ actualNr).length();
        int toNrSize = (""+ END_NR).length();
        int dinamicSize = toNrSize <= 4 ? 5 - actualNrSize : toNrSize + 1 - actualNrSize;
        return " ".repeat(dinamicSize);
    }

    private void beginANewLine(int actualNr){
        if( (actualNr - START_NR + 1) % NR_OF_COLUMNS == 0){
            System.out.println("");
        }
    }

    private String makeFixPlaceholder(){
        int toNrSize = (""+ END_NR).length();
        int fixSize = toNrSize <= 4 ? 1 : toNrSize - 3;
        return " ".repeat(fixSize);
    }

}
