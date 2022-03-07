package com.company;

class Main {
    public static void main(String[] args) {
        int[] arrayOfNumbers = {0,0,0,-10,-15,22,-13,11,-1,2,9,-12,-2,55,100,-100};
        int conditionNumber = -1;
        Numbers numbers = new Numbers(arrayOfNumbers, conditionNumber);
        numbers.maxNumber();
    }
}

class Numbers {
    int[] arrayOfNumbers;
    int conditionNumber;
    Integer currentMaxNumber = null;
    boolean isNumberInArrayLowerThanConditionNumber = false;

    public Numbers(int[] arrayOfNumbers, int conditionNumber) {
        this.arrayOfNumbers = arrayOfNumbers;
        this.conditionNumber = conditionNumber;
    }

    public void maxNumber() {
        if (arrayOfNumbers.length == 0) {
            System.out.println("The array is empty");
        } else if (arrayOfNumbers.length == 1 && arrayOfNumbers[0] < conditionNumber) {
            currentMaxNumber = arrayOfNumbers[0];
            System.out.println("The array contains only one element and it is lower than the specified number: " + conditionNumber+", and that is the number: "+currentMaxNumber);
        } else if (arrayOfNumbers.length == 1 && arrayOfNumbers[0] >= conditionNumber) {
            System.out.println("The array contains only one element and it is not lower than the specified number: " + conditionNumber);
        }
        else {
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                if (arrayOfNumbers[i] < conditionNumber && currentMaxNumber == null) {
                    currentMaxNumber = arrayOfNumbers[i];
                    isNumberInArrayLowerThanConditionNumber = true;
                }else if (arrayOfNumbers[i] < conditionNumber && currentMaxNumber != null && arrayOfNumbers[i] >= currentMaxNumber){
                    currentMaxNumber = arrayOfNumbers[i];
                    isNumberInArrayLowerThanConditionNumber = true;
                }
            }
            if (isNumberInArrayLowerThanConditionNumber) {
                System.out.println("The biggest number in the array, which is at the same time lower than the specified number: " + conditionNumber + " is the number: " + currentMaxNumber);
            } else {
                System.out.println("There is no number in the array that is lower than the specified number: " + conditionNumber);
            }
        }
    }
}