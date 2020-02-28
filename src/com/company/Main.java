package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // enter row and column for matrices!
        System.out.println("Броя редове:");
        int rows = input.nextInt();
        System.out.println("Броя колони:");
        int columns = input.nextInt();
//        int rowCounter = 1;
//        int columnCounter = 1;
        int[][] firstMatrix = new int[rows][columns];
        int[][] secondMatrix = new int[rows][columns];

        // enter first array elements.
        System.out.println("Enter " + (rows * columns) + " elements for first array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                firstMatrix[i][j] = input.nextInt();
                System.out.println("Enter next element:");
            }
        }
//        enter second array elements
        System.out.println("Enter " + (rows * columns) + " elements for second array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                secondMatrix[i][j] = input.nextInt();
                System.out.println("Enter next element:");
            }
        }

        // the 2D arrays!
        System.out.print("The first Array is:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(firstMatrix[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.print("The second array is:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(secondMatrix[i][j] + "  ");
            }
            System.out.println();
        }

//        suming Matrices
        int[][] sumOfMatrices = summingMatrices(firstMatrix, secondMatrix, rows, columns);
        System.out.println("Sum:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sumOfMatrices[i][j] + " ");
            }
            System.out.println();
        }

//        subtraction of matrices
        int[][] subtractionOfMatrices = subtractionOfMatrix(firstMatrix, secondMatrix, rows, columns);
        System.out.println("Subtraction:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(subtractionOfMatrices[i][j] + " ");
            }
            System.out.println();
        }

//        multiplication of matrices
        int[][]multiplication = multiplicationОfМatrices(firstMatrix , secondMatrix , rows , columns);
        System.out.println("Multiplication:");
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <columns ; j++) {
                System.out.print(multiplication[i][j] + " ");
            }
            System.out.println();
        }

//        reverse matrices
        int[][] reversefirstMatrix = reverseMatrix(firstMatrix);
        System.out.println("Reverse first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(reversefirstMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Reverse second matrix:");
        int[][] reversesSecondMatrix = reverseMatrix(secondMatrix);
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <columns ; j++) {
                System.out.print(reversesSecondMatrix[i][j] + " ");
            }
            System.out.println();
        }

//        determinant
        int firstDeterminant= determinant(firstMatrix);
        System.out.print("The determinant for first matrix:");
        System.out.println(firstDeterminant);
        int secondDeterminant= determinant(secondMatrix);
        System.out.print("The determinant for second matrix:");
        System.out.println(secondDeterminant);

//        it is checked if it is a single matrix
        isSingular(firstMatrix);

    }

    public static int determinant(int[][] matrix){
        int sum=0;
        int s;
        if (matrix.length==1){
            return (matrix[0][0]);
        }
        for (int i = 0; i <matrix.length ; i++) {
            int[][]smaller= new int [matrix.length-1][matrix.length-1];
            for (int j = 1; j <matrix.length ; j++) {
                for (int k = 0; k <matrix.length ; k++) {
                    if (k<i){
                        smaller[j-1][k]=matrix[j][k];
                    }else if (k>i){
                        smaller[j-1][k-1]=matrix[j][k];
                    }
                }
            }
            if (i%2==0){
                s=1;
            }else{
                s=-1;
            }
            sum+=s*matrix[0][i]*(determinant(smaller));
        }
        return sum;
    }

    public static int[][] multiplicationОfМatrices(int[][] firstMatrix , int [][] secondMatrix , int rows , int columns){
        int[][] resultOfmultiplication = new int [rows][columns];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <columns ; j++) {
                resultOfmultiplication[i][j] =firstMatrix[i][j] * secondMatrix[i][j];
            }
        }
        return resultOfmultiplication;
    }

    public static int[][] reverseMatrix(int[][] firstMatrix) {
        int rows = firstMatrix.length;
        int columns = firstMatrix[0].length;
        int array[][] = new int[rows][columns];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                array[rows - 1 - i][columns - 1 - j] = firstMatrix[i][j];
            }
        }
        return array;
    }

    public static void isSingular(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][i] == 1 && matrix[i][j] == 0) {
                    counter++;
                }
            }
        }
        if ((counter / (matrix.length-1)) == matrix.length){
            System.out.println("Матрицата е единична");
        }
        else {
            System.out.println("Матрицата не е единична");
        }
    }


    public static int[][] summingMatrices(int[][] firstMatrix, int[][] secondMatrix, int rows, int columns) {
        int[][] resultOfSumming = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultOfSumming[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return resultOfSumming;
    }

    public static int[][] subtractionOfMatrix(int[][] firstMatrix, int[][] secondMatrix, int rows, int columns) {
        int[][] resultOfsubtraction = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultOfsubtraction[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return resultOfsubtraction;
    }
}

