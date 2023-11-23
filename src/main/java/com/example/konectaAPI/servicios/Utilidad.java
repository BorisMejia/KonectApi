package com.example.konectaAPI.servicios;

public enum Utilidad
{
    ID_NEGATIVO("Error en el id "),
    NOMBRES_LONGITUD("El numero de caracteres no es correcto debe estar entre 3 y 40"),
    NOMBRES_FORMATO("el nombre no coincide"),
    REGISTRAR_USUARIO("Error al registrar"),
    CONSULTAR_USUARIO("Error al consultar"),
    CONSULTAR_TODOS_AFILIADOS("Error al consultar todos los afiliados"),
    CONSULTAR_TODOS_EXAMENES("Error al consultar todos los examenes"),
    CONSULTAR_TODOS_SIGNOVITAL("Error al consultar todos los signos vital"),
    EDITAR_UN_AFILIADO("Error al editar un afiliado"),
    EDITAR_UN_EXAMEN("Error al editar un examen"),
    BORRAR_UN_AFILIADO("El afiliado no se encontro en la base de datos"),
    BORRAR_UN_EXAMEN("El examen no se encontro en la base de datos"),
    BORRAR_UN_SIGNO("El signo vital no se encontro en la base de datos");
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


