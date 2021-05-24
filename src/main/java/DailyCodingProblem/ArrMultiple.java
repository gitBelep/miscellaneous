package DailyCodingProblem;

public class ArrMultiple {

    public int[] multipleExceptOfI(int[] arr){
        int[] result = new int[arr.length];
        int multi = 1;
        int numberOfNulls = 0;

        for (int j : arr) {
            if (j == 0) {
                numberOfNulls++;
            } else {
                multi *= j;
            }
        }

        if(numberOfNulls == 0) {
            for (int i = 0; i < arr.length; i++) {
                result[i] = multi / arr[i];
            }
        } else if(numberOfNulls == 1){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0){
                    result[i] = 0;
                } else {
                    result[i] = multi;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                result[i] = 0;
            }
        }

        return result;
    }

    public int[] multipleExceptOfIWithoutDivision(int[] arr){
        int[] result = new int[arr.length];
        int multi = 1;
        int numberOfNulls = 0;

        for (int j : arr) {
            if (j == 0) {
                numberOfNulls++;
            } else {
                multi *= j;
            }
        }

        if(numberOfNulls == 0) {
            for (int i = 0; i < arr.length; i++) {
                int smallMulti = 1;
                for(int k = 0; k < arr.length; k++) {
                    if (k != i) {
                        smallMulti *= arr[k];
                    }
                }
                result[i] = smallMulti;
            }
        } else if(numberOfNulls == 1){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0){
                    result[i] = 0;
                } else {
                    result[i] = multi;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                result[i] = 0;
            }
        }

        return result;
    }

    public int[] universalButSlowMultipleExceptOfIWithoutDivision(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int smallMulti = 1;
            for(int k = 0; k < arr.length; k++) {
                if (k != i) {
                    smallMulti *= arr[k];
                }
            }
            result[i] = smallMulti;
        }
        return result;
    }
}
