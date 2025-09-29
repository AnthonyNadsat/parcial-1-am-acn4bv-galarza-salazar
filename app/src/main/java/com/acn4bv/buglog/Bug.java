package com.acn4bv.buglog;

public class Bug {
    private final String nombreJuego;
    private final String plataforma;
    private final String tipo;
    private final String gravedad;
    private final String descripcion;

    public Bug(String nombreJuego, String plataforma, String tipo, String gravedad, String descripcion) {
        this.nombreJuego = nombreJuego;
        this.plataforma = plataforma;
        this.tipo = tipo;
        this.gravedad = gravedad;
        this.descripcion = descripcion;
    }

    public String getNombreJuego() { return nombreJuego; }
    public String getPlataforma()  { return plataforma; }
    public String getTipo()        { return tipo; }
    public String getGravedad()    { return gravedad; }
    public String getDescripcion() { return descripcion; }
}
