package org.kpi.fpm.lab_3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class ImmutableMatrix extends MutableMatrix{
    private float immatrix[][];

    public ImmutableMatrix(){
        this.immatrix = new float[0][0];
    }
    public ImmutableMatrix(int row, int column) {
        this.immatrix = new float[row][column];
    }
    public ImmutableMatrix(MutableMatrix matrix) {
        this.immatrix = new float[matrix.getMatrix().length][matrix.getMatrix()[0].length];
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                this.immatrix[i][j] = matrix.getMatrix()[i][j];
            }
        }
    }
    public ImmutableMatrix(ImmutableMatrix immatrix) {
        this.immatrix = new float[immatrix.getMatrix().length][immatrix.getMatrix()[0].length];
        for (int i = 0; i < immatrix.getMatrix().length; i++) {
            for (int j = 0; j < immatrix.getMatrix()[0].length; j++) {
                this.immatrix[i][j] = immatrix.getMatrix()[i][j];
            }
        }
    }
    @Override
    public float getValue(int row, int column){
        return this.immatrix[row][column];
    }
    @Override
    public float[] getRow(int row){
        return this.immatrix[row];
    }
    public float[] getColumn(int column) {
        float col[] = new float[this.immatrix.length];
        for(int i = 0; i < this.immatrix.length; i++){
            col[i] = this.immatrix[i][column];
        }
        return col;
    }
    @Override
    public String getSize(){
        return String.valueOf(this.immatrix.length)+"x"+String.valueOf(this.immatrix[0].length);
    }
    @Override
    public float[][] getMatrix() {
        return immatrix;
    }
    @Override
    public boolean equals(MutableMatrix matrix){
        boolean m_s, s_d, s_nr, s_nc;
        m_s = true;
        if(this.getClass() != matrix.getClass()){
            return false;
        }
        try {
            for (int i = 0; i < this.immatrix.length; i++) {
                for (int k = 0; k < this.immatrix[i].length; k++) {
                    if (this.immatrix[i][k] != matrix.getMatrix()[i][k]) {
                        m_s = false;
                        break;
                    }
                }
            }
        } catch (Exception ex){
            m_s = false;
        }
        if(this.immatrix == null || matrix.getMatrix() == null){
            m_s = false;
            s_nr = false;
            s_nc = false;
            s_d = false;
        }
        else {
            s_nr = this.immatrix.length == matrix.getMatrix().length;
            s_nc = this.immatrix[0].length == matrix.getMatrix()[0].length;
            s_d = s_nr && s_nc;
        }
        if(m_s && s_d && s_nr && s_nc){
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean equals(ImmutableMatrix immatrix){
        boolean m_s, s_d, s_nr, s_nc;
        m_s = true;
        if(this.getClass() != immatrix.getClass()){
            return false;
        }
        try {
            for (int i = 0; i < this.immatrix.length; i++) {
                for (int k = 0; k < this.immatrix[i].length; k++) {
                    if (this.immatrix[i][k] != immatrix.getMatrix()[i][k]) {
                        m_s = false;
                        break;
                    }
                }
            }
        } catch (Exception ex){
            m_s = false;
        }
        if(this.immatrix == null || immatrix.getMatrix() == null){
            m_s = false;
            s_nr = false;
            s_nc = false;
            s_d = false;
        }
        else {
            s_nr = this.immatrix.length == immatrix.getMatrix().length;
            s_nc = this.immatrix[0].length == immatrix.getMatrix()[0].length;
            s_d = s_nr && s_nc;
        }
        if(m_s && s_d && s_nr && s_nc){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        if(this.immatrix.length == 0 || this.immatrix[0].length == 0){
            return 0;
        }
        int result = Objects.hash(this.immatrix.length, this.immatrix[0].length);
        for(int i = 0; i < this.immatrix.length; i++){
            for(int k = 0; k < this.immatrix[i].length; k++){
                result = 31 * result + Objects.hashCode(this.immatrix[i][k]);
            }
        }
        return result;
    }
}
