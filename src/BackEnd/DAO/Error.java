/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.DAO;

/**
 *
 * @author sinozuke
 */
public class Error {
    private String tipo;
    private String Descripccion;
    private int fila;
    private int columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripccion() {
        return Descripccion;
    }

    public void setDescripccion(String Descripccion) {
        this.Descripccion = Descripccion;
    }
    
}
