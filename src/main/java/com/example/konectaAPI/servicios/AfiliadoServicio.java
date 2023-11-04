package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Afiliado consultarAfiliado(Integer idAfiliado)throws Exception
    {
        try
        {
            Optional<Afiliado>AfiliadoBuscado = this.afiliadoRepositorio.findById(idAfiliado);
            if (AfiliadoBuscado.isPresent())//lo encontre en la base de datos
            {
                return AfiliadoBuscado.get();
            }else //no lo encontro
            {
                throw new Exception("Afiliado no encontrado");
            }

        }catch (Exception error)
        {
            throw new Exception(Utilidad.CONSULTAR_USUARIO.getMensaje());
        }
    }

    //Consultar afiliados

    //Modificar datos afiliado

    //Borrar afiliado
}

