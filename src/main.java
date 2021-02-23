public class main {
    public static void main(String[] args) {
        findSuitableNumsOrIndexes(new Integer[]{1,2,2}, new Integer[]{2,2,2});
    }

    static public void findSuitableNumsOrIndexes(Integer[] arr1, Integer[] arr2){

        int tmpSum = arraySum(arr1);
        int tmpSum2 = arraySum(arr2);

        if(tmpSum == tmpSum2){
            System.out.println("Array`s are equals");
            return;
        }

        if(!printSuitableIndexes(arr1,arr2)){
            System.out.println("First array");
            printSuitableNums(arr2,arr1);

            System.out.println("Second array");
            printSuitableNums(arr1,arr2);
        }

    }
    static public boolean printSuitableIndexes(Integer[] arr1, Integer[] arr2){
        int sum1 = arraySum(arr1);
        int sum2 = arraySum(arr2);

        boolean isArraysHaveTheseIndexes = false;

        for(int arr1Index = 0; arr1Index < arr1.length; ++arr1Index){
            for(int arr2Index =0; arr2Index < arr2.length; ++arr2Index){
                if(sum1 - arr1[arr1Index] + arr2[arr2Index] == sum2 - arr2[arr2Index] + arr1[arr1Index] )
                {
                    isArraysHaveTheseIndexes = true;

                    System.out.println("You can change "
                            + (arr1Index+1)+ " index " + "(" + arr1[arr1Index] + ") " + "of first arr and "
                            + (arr2Index+1) + " (" + arr2[arr2Index] + ") " +" of second array to make them equals");
                }
            }
        }
      return isArraysHaveTheseIndexes;
    }
    static public void printSuitableNums(Integer[] arr1, Integer[] arr2) {

        int firstArrSum = arraySum(arr1);
        int secondArrSum = arraySum(arr2);

        for (int arr1Index = 0; arr1Index < arr1.length; ++arr1Index) {
            findSuitableNums(firstArrSum, secondArrSum, arr1[arr1Index],arr1Index );
        }
    }
    static public void findSuitableNums(int firstArrSum, int maxSum, int firstArrNumber,int firstArrIndex) {
        int number = 1;
        while (true) {
            int sumWithReplacedNums = firstArrSum - firstArrNumber + number;
            if (sumWithReplacedNums == maxSum) {
                System.out.println("You can change "
                        + (firstArrIndex + 1) + " index " + "(" + firstArrNumber + ") " + "of first arr with "
                        + number + " to make them equals");
                break;
            }

            if (sumWithReplacedNums > maxSum)
                break;

            ++number;
        }
    }
    static  public int arraySum(Integer[] array) {
        int sum = 0;
        for (Integer item: array) {
            sum+=item;
        }
        return sum;
    }
}
