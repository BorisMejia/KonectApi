package com.example.konectaAPI.servicios;

public enum Utilidad
{
    ID_NEGATIVO("Error en el id care chimba porque es negativo"),
    NOMBRES_LONGITUD("El numero de caracteres no es correcto debe estar entre 3 y 40"),
    NOMBRES_FORMATO("el nombre no coincide"),
    REGISTRAR_USUARIO("Error al registrar"),
    CONSULTAR_USUARIO("Error al consultar");
    private String mensaje;

    Utilidad(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}


