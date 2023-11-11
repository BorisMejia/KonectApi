package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Examen consultarExamen(Integer idExamen)throws Exception
    {
        try
        {
            Optional<Examen>ExamenBuscado = this.examenRepositorio.findById(idExamen);
            if (ExamenBuscado.isPresent())//lo encontre en la base de datos
            {
                return ExamenBuscado.get();
            }else //no lo encontro
            {
                throw new Exception("Afiliado no encontrado");
            }

        }catch (Exception error)
        {
            throw new Exception(Utilidad.CONSULTAR_USUARIO.getMensaje());
        }
    }

}
