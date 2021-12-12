package advent;

import java.util.ArrayList;
import java.util.List;

public class A04BingoTable {
    private final List<List<A04BingoNr>> rows = new ArrayList<>(5);

    public A04BingoTable amITheWinner(int actualNr){
        draw(actualNr);
        if(findFullRowOrColumn()){
            return this;
        }
        return null;
    }

    public void draw(int nr){
        for(List<A04BingoNr> r : rows){
            for(A04BingoNr bn : r){
                if(nr == bn.getNr()){
                    bn.setDrawn();
                    return;
                }
            }
        }
    }

    public boolean findFullRowOrColumn(){
        int[] columnCounter = new int[5];
        for(int r = 0; r < 5; r++){
            int rowCounter = 0;
            for(int c = 0; c < 5; c++){
                if(rows.get(r).get(c).isDrawn()){
                    rowCounter++;
                    columnCounter[c] += 1;
                }
            }
            if(rowCounter == 5){
                return true;
            }
        }
        for(int i : columnCounter){
            if (i == 5){
                return true;
            }
        }
        return false;
    }

    public List<List<A04BingoNr>> getRows() {
        return rows;
    }

    public void addList(List<A04BingoNr> inList){
        rows.add(inList);
    }

}
