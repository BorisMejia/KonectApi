package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.repositorios.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
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
    public List<Examen> buscarTodosLosExamenes()throws Exception{
        try {
            List<Examen>listExamen = this.examenRepositorio.findAll();
            return listExamen;

        }catch (Exception error){
            throw new Exception(Utilidad.CONSULTAR_TODOS_EXAMENES.getMensaje());
        }
    }
    public Examen editarExamen(Integer id, Examen examen) throws Exception{
        try {
            Optional<Examen> examenBuscado = this.examenRepositorio.findById(id);
            if(examenBuscado.isPresent()){
               /* Afiliado afiliadoEditado=this.afiliadoRepositorio.save(afiliado);
                return afiliadoEditado;
                CAMBIAR TOD0
                */
                Examen examenExistente = examenBuscado.get();
                examenExistente.setFechaExamen(examen.getFechaExamen());
                examenExistente.setNombreExamen(examen.getNombreExamen());
                Examen examenModificado = this.examenRepositorio.save(examenExistente);
                return examenModificado;
            }else {
                throw new Exception("examen no encontrado");
            }
        }catch (Exception error){
            throw new Exception(Utilidad.EDITAR_UN_AFILIADO.getMensaje());
        }
    }
    public Boolean eliminarExamen(Integer id)throws Exception{
        try {
            Boolean examenEncontrado = this.examenRepositorio.existsById(id);
            if(examenEncontrado){
                this.examenRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(Utilidad.BORRAR_UN_EXAMEN.getMensaje());
            }

        }catch (Exception error){
            throw new Exception("Error borrando el examen");
        }

    }

}
