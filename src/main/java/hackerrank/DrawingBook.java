package hackerrank;

public class DrawingBook {
    
    public int minPages(int to, int pages){
        int fromFront = to / 2;

        if(pages % 2 == 0){
            pages = pages + 1;
        }
        int fromBack = (pages - to) / 2;
        return Math.min(fromBack, fromFront);
    }
    
}
