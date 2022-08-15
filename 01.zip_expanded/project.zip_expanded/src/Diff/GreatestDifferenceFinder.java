package Diff;

public class GreatestDifferenceFinder {
    int greatestDifference(int[] intArray) {
        int max = 0;
        for (int i = 0; i<intArray.length;i++) {
        	for (int j = 0; j < intArray.length; j++) {
				if (i==j) continue;
				int temp = intArray[i]-intArray[j];
				if (max < temp) max = temp;
			}
        }
        if (intArray.length < 3){
            max = 0;
        }
        return max;
    }
}
