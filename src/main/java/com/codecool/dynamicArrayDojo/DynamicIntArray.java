package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int lengthOfIntArray = 0;

    private int intArray[] = new int[lengthOfIntArray];


    public void setLengthOfIntArray(int lengthOfIntArray) {
        this.lengthOfIntArray = lengthOfIntArray;
    }


    public void add(int numberToAdd) {
        int[] extendedArray = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, extendedArray, 0, intArray.length);
        extendedArray[extendedArray.length - 1] = numberToAdd;
        intArray = extendedArray;
    }

    public void remove(int indexToRemove) {
        if (indexToRemove <= intArray.length) {
            int[] decreasedArray = new int[intArray.length - 1];
            System.arraycopy(intArray, 0, decreasedArray, 0, indexToRemove);
            System.arraycopy(intArray, indexToRemove + 1, decreasedArray, indexToRemove, intArray.length - indexToRemove - 1);
            //System.out.println(Arrays.toString(decreasedArray));

            intArray = decreasedArray;
        }
    }

    public void insert(int index, int numberToInsert) {
        int[] insertedArray = new int[intArray.length + 1];
        if (index <= intArray.length) {
            System.arraycopy(intArray, 0, insertedArray, 0, index);
            insertedArray[index] = numberToInsert;
            System.arraycopy(intArray, index, insertedArray, index + 1, intArray.length - index);
            intArray = insertedArray;
        } else {
            add(numberToInsert);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            result.append(" ");
            result.append(String.valueOf(intArray[i]));
        }
        return result.toString();
    }

    public DynamicIntArray(int arrayLength) {
        setLengthOfIntArray(arrayLength);
    }

    public DynamicIntArray() {

    }

}
