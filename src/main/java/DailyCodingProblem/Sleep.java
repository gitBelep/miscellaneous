package DailyCodingProblem;

import java.time.LocalTime;
import java.util.function.Function;

public class Sleep {
    static Function<Object, Object> half = a -> a;

    public static void main(String[] args) throws InterruptedException {
        JobScheduler rr = new JobScheduler();
        rr.runFuncAfter(half, 2000);
    }
}

class JobScheduler {

    public void runFuncAfter(Function f, int n) throws InterruptedException {
        //System.out.println("kezd: "+ LocalTime.now().getSecond() );
        Thread.sleep(n);
        f.apply(n);
        //System.out.println("után: "+ LocalTime.now().getSecond() );
    }

}
