package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServicio
{
    @Autowired
    private ExamenRepositorio examenRepositorio;

    public Examen registrarExamen(Examen examen) throws Exception
    {
        try {
            return this.examenRepositorio.save(examen);
        }catch (Exception error)
        {
            throw new Exception(Utilidad.REGISTRAR_USUARIO.getMensaje());
        }
    }
}
