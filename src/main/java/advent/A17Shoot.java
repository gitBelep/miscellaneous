package advent;

public class A17Shoot {
    public static void main(String[] args) {
        int x1 = 269;
        int x2 = 292;
        int y1 = -44;
        int y2 = -68;
        int sumY = 0;

        for (int y = 1; y <= -1 * y2 - 1; y++) {
            sumY = sumY + y;
        }                                                                                                   // part 1.
        System.out.println("I.\nY maximális, ha az x tengely alatt egy lépésből érek el minél lejjebb, vagyis y2-ig:\n" +
                "Y max = " + sumY + " ~ " + (-1 * y2 - 1) + " lépésnyi van a tengely felett.");

        int counter = 0;
        for (int vxi = 23; vxi <= x2; vxi++) {             //vx i: 23 ~ 292
            for (int vyi = y2; vyi < -1 * y2 - 1; vyi++) { //vy i: -68 ~ 67
                int vx = vxi;
                int vy = vyi;
                int x = 0;
                int y = 0;
                while(x <= x2 && y >=  y2){         //x: 0 ~ 292  y: -68 ~ 0
                    x = x + vx;
                    if(vx > 0) vx--;
                    y = y + vy;
                    vy--;
                    //System.out.print("("+ x +","+ y +") ");
                    if( x1 <= x && x <= x2 && y2 <= y && y <= y1){
                        //System.out.println(counter +" >>>  x,y = ("+ x +", "+ y +")");
                        counter++;
                    }
                }
            }
        }
        System.out.println("Össz ennyi: "+ counter);
    }

}
