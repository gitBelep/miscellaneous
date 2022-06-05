package DailyCodingProblem;

public class AscSubArray {

    public int lengthOfLongestAscendingSubArray(int[] arr) {
        return commonPart(arr, "LENGTH");
    }

    public int beginingOfLongestAscendingSubArray(int[] arr) {
        return commonPart(arr, "BEGINNING");
    }

    private int commonPart(int[] arr, String drive) {
        int actualValue;
        int previousValue = Integer.MIN_VALUE;
        int actualLength = -1;
        int maxLength = -1;
        int actualBegin = -1;
        int maxBegin = -1;
        boolean isNewAscArr = true;

        if (arr == null){
            return -2;
        }
        if (arr.length == 0){
            return -1;
        }

        for(int i = 0; i < arr.length; i++){
            actualValue = arr[i];
            if(previousValue <= actualValue){
                if (isNewAscArr){
                    actualLength = 2;
                    if (i == 0) actualLength = 1;
                    actualBegin = (i - 1) < 0 ? 0 : (i - 1);
                    isNewAscArr = false;
                } else {
                    actualLength += 1;
                }
            } else {
                if ( maxLength < actualLength){
                    maxLength = actualLength;
                    maxBegin = actualBegin;
                }
                actualLength = 1;
                isNewAscArr = true;
            }

        //    System.out.println( "i:"+ i+ " actualValue:"+ actualValue+" previousValue:"+ previousValue+
        //            " actualLength:"+ actualLength+" maxLength:"+ maxLength+" actualBegin:"+ actualBegin+
        //            " maxBegin:"+ maxBegin+" isNewAscArr:"+ isNewAscArr);

            previousValue = actualValue;
        }

        if ( maxLength < actualLength){
            maxLength = actualLength;
            maxBegin = actualBegin;
        }
    //    System.out.println("The longest ascending subarrays beginning:"+ maxBegin +" & length:" + maxLength);
        if ("LENGTH".equals(drive)) {
            return maxLength;
        } else {
            return maxBegin;
        }
    }

}
