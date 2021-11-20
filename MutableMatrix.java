package org.kpi.fpm.lab_3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MutableMatrix{
    private float matrix[][];

    public MutableMatrix(){
        this.matrix = new float[0][0];
    }
    public MutableMatrix(int row, int column) {
        this.matrix = new float[row][column];
    }
    public MutableMatrix(MutableMatrix matrix) {
        this.matrix = new float[matrix.getMatrix().length][matrix.getMatrix()[0].length];
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                this.matrix[i][j] = matrix.getMatrix()[i][j];
            }
        }
    }
    public MutableMatrix(ImmutableMatrix im_matrix) {
        this.matrix = new float[im_matrix.getMatrix().length][im_matrix.getMatrix()[0].length];
        for (int i = 0; i < im_matrix.getMatrix().length; i++) {
            for (int j = 0; j < im_matrix.getMatrix()[0].length; j++) {
                this.matrix[i][j] = im_matrix.getMatrix()[i][j];
            }
        }
    }

    public float getValue(int row, int column){
        return this.matrix[row][column];
    }
    public void setValue(int row, int column, float value) {
        this.matrix[row][column] = value;
    }

    public float[] getRow(int row){
        return this.matrix[row];
    }
    public void setRow(int row, float a[]){
        this.matrix[row] = a;
    }

    public float[] getColumn(int column) {
        float col[] = new float[this.matrix.length];
        for(int i = 0; i < this.matrix.length; i++){
            col[i] = matrix[i][column];
        }
        return col;
    }
    public void setColumn(int column, float matrix[]){
        for(int i = 0; i < this.matrix.length; i++){
            this.matrix[i][column] = matrix[i];
        }
    }

    public String getSize(){
        return String.valueOf(this.matrix.length)+"x"+String.valueOf(this.matrix[0].length);
    }

    public void setMatrix(MutableMatrix matrix) {
        this.matrix = new float[matrix.getMatrix().length][matrix.getMatrix()[0].length];
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                this.matrix[i][j] = matrix.getMatrix()[i][j];
            }
        }
    }
    public void setMatrix(ImmutableMatrix immatrix) {
        this.matrix = new float[immatrix.getMatrix().length][immatrix.getMatrix()[0].length];
        for (int i = 0; i < immatrix.getMatrix().length; i++) {
            for (int j = 0; j < immatrix.getMatrix()[0].length; j++) {
                this.matrix[i][j] = immatrix.getMatrix()[i][j];
            }
        }
    }
    public float[][] getMatrix() {
        return this.matrix;
    }

    public void inputRandomMatrix(int row, int column) {
        Random rnd = new Random();
        float matrix[][] = new float[row][column];
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                int d = rnd.nextInt(2);
                switch(d){
                    case 0:
                        matrix[i][k] = Math.round(rnd.nextInt(1100) + (rnd.nextFloat() * 2)) / 100.0f;
                        break;
                    case 1:
                        matrix[i][k] = Math.round(rnd.nextInt(1100) - 1100 + (rnd.nextFloat() * 2 - 0.55f)) / 100.0f;
                        break;
                }
            }
        }
        this.matrix = matrix;
    }
    public void inputMatrix(int row, int column){
        float matrix[][] = new float[row][column];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                System.out.printf("matrix[%d][%d] = ", i, k);
                matrix[i][k] = in.nextFloat();
            }
        }
        this.matrix = matrix;
    }

    public static float[] getRandomRowMatrix(int len){
        float random_matrix[] = new float[len];
        Random rnd = new Random();
        for(int i = 0; i < len; i++){
            int d = rnd.nextInt(2);
            switch(d){
                case 0:
                    random_matrix[i] = Math.round(rnd.nextInt(1100) + (rnd.nextFloat() * 2)) / 100.0f;
                    break;
                case 1:
                    random_matrix[i] = Math.round(rnd.nextInt(1100) - 1100 + (rnd.nextFloat() * 2 - 0.55f)) / 100.0f;
                    break;
            }
        }
        return random_matrix;
    }
    public void MultiplyMatrix(MutableMatrix a, MutableMatrix b){
        try {
            float matrix[][] = new float[a.getMatrix().length][b.getMatrix()[0].length];
            for (int i = 0; i < a.getMatrix().length; i++) {
                for (int j = 0; j < b.getMatrix()[0].length; j++) {
                    for (int k = 0; k < b.getMatrix().length; k++) {
                        matrix[i][j] += a.getMatrix()[i][k] * b.getMatrix()[k][j];
                    }
                }
            }
            this.matrix = matrix;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public boolean equals(MutableMatrix matrix){
        boolean m_s, s_d, s_nr, s_nc;
        m_s = true;
        if(getClass() != matrix.getClass()){
            return false;
        }
        try {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int k = 0; k < this.matrix[i].length; k++) {
                    if (this.matrix[i][k] != matrix.getMatrix()[i][k]) {
                        m_s = false;
                        break;
                    }
                }
            }
        } catch (Exception ex){
            m_s = false;
        }
        if(this.matrix == null || matrix.getMatrix() == null){
            m_s = false;
            s_nr = false;
            s_nc = false;
            s_d = false;
        }
        else {
            s_nr = this.matrix.length == matrix.getMatrix().length;
            s_nc = this.matrix[0].length == matrix.getMatrix()[0].length;
            s_d = s_nr && s_nc;
        }
        if(m_s && s_d && s_nr && s_nc){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean equals(ImmutableMatrix immatrix){
        immatrix = new ImmutableMatrix(immatrix);
        boolean m_s, s_d, s_nr, s_nc;
        m_s = true;
        boolean smae;
        if(getClass() != immatrix.getClass()){
            return false;
        }
        try {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int k = 0; k < this.matrix[i].length; k++) {
                    if (this.matrix[i][k] != immatrix.getMatrix()[i][k]) {
                        m_s = false;
                        break;
                    }
                }
            }
        } catch (Exception ex){
            m_s = false;
        }
        if(this.matrix == null || immatrix.getMatrix() == null){
            m_s = false;
            s_nr = false;
            s_nc = false;
            s_d = false;
        }
        else {
            s_nr = this.matrix.length == immatrix.getMatrix().length;
            s_nc = this.matrix[0].length == immatrix.getMatrix()[0].length;
            s_d = s_nr && s_nc;
        }
        if(m_s && s_d && s_nr && s_nc){
            return true;
        }
        else {
            return false;
        }

    }
    public int hashCode() {
        if(this.matrix.length == 0 || this.matrix[0].length == 0){
            return 0;
        }
        int result = Objects.hash(this.matrix.length, this.matrix[0].length);
        for(int i = 0; i < this.matrix.length; i++){
            for(int k = 0; k < this.matrix[i].length; k++){
                result = 31 * result + Objects.hashCode(this.matrix[i][k]);
            }
        }
        return result;
    }
}
