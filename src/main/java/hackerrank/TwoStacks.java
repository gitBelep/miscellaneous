package hackerrank;

public class TwoStacks {

    public int takeElements(int[] a, int[] b, int max){
        int maxTreeDepth = 0;
        for(int k = 0; k < b.length; k++){
            int actualTreeDepth = 0;
            int sum = 0;

            for(int f = 0;  sum < max && f < k; f++) {
                sum += b[f];
                actualTreeDepth ++;
            }
System.out.println("from b[]: "+ actualTreeDepth +" sum: "+ sum);
            for(int i = 0; sum < max && i < a.length; i++){
                sum += a[i];
                actualTreeDepth ++;
            }
System.out.println("together: "+ actualTreeDepth +" sum: "+ sum +" depth: " + actualTreeDepth);

            if(maxTreeDepth < actualTreeDepth){
                maxTreeDepth = actualTreeDepth;
            }
        }
        return maxTreeDepth;
    }

}
