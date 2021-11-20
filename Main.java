package org.kpi.fpm.lab_3;

public class Main {
    public static void main(String[] args) {
        MutableMatrix m = new MutableMatrix(3, 5);
        MutableMatrix m1 = new MutableMatrix(m);
    }
    public static void Draw(float matrix[][]){
        if(matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int k = 0; k < matrix[i].length; k++) {
                    System.out.printf(" %.2f   ", matrix[i][k]);
                }
                System.out.print("\n");
            }
        }
    }
    public static void Draw1D(float matrix[]){
        if(matrix != null) {
            System.out.print("[");
            for (int i = 0; i < matrix.length; i++) {
                System.out.printf(" %.2f ", matrix[i]);
            }
            System.out.println("]");
            System.out.print("\n");
        }
    }
}
