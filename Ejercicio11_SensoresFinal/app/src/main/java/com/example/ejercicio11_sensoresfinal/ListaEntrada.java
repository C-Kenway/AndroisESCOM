package com.example.ejercicio11_sensoresfinal;

public class ListaEntrada {
    private int Idim;
    private String a;
    private String d;

    /**Creamos el constructor del objeto*/
    public ListaEntrada(int Idim, String a, String d) {
        this.Idim = Idim;
        this.a = a;
        this.d = d;
    }

    /**Creamos los getters del objeto*/
    public String get_textArriba(){return a;}
    public String get_textDebajo(){return d;}
    public int get_idImagen(){return Idim;}
}
