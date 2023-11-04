package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliadoServicio {
    @Autowired
    protected AfiliadoRepositorio afiliadoRepositorio;
    //Registrar un afiliado
    public Afiliado registrarAfiliado(Afiliado afiliado) throws Exception
    {
        try
        {
            return this.afiliadoRepositorio.save(afiliado);
        }catch(Exception error)
        {
            throw new Exception(Utilidad.REGISTRAR_USUARIO.getMensaje());
        }
    }
    //Consultar un afiliado

    //Consultar afiliados

    //Modificar datos afiliado

    //Borrar afiliado
}

