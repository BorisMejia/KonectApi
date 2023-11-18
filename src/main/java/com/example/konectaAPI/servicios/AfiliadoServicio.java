package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.repositorios.AfiliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Afiliado> buscarTodosLosAfiliados()throws Exception{
        try {
           List<Afiliado>listaConsultada = this.afiliadoRepositorio.findAll();
           return listaConsultada;

        }catch (Exception error)
        {
            throw new Exception(Utilidad.CONSULTAR_TODOS_AFILIADOS.getMensaje());
        }
    }

    //Modificar datos afiliado
    public Afiliado editarAfiliado(Integer id, Afiliado afiliado) throws Exception{
        try {
            Optional<Afiliado> afiliadoBuscado = this.afiliadoRepositorio.findById(id);
            if(afiliadoBuscado.isPresent()){
               /* Afiliado afiliadoEditado=this.afiliadoRepositorio.save(afiliado);
                return afiliadoEditado;
                CAMBIAR TODO
                */
                Afiliado afiliadoExistente = afiliadoBuscado.get();
                afiliadoExistente.setCorreo(afiliado.getCorreo());
                afiliadoExistente.setDepartmento(afiliado.getDepartmento());
                Afiliado afiliadoModificado = this.afiliadoRepositorio.save(afiliadoExistente);
                return afiliadoModificado;
            }else {
                
                throw new Exception("Afiliado no encontrado");
            }
        }catch (Exception error){
            throw new Exception(Utilidad.EDITAR_UN_AFILIADO.getMensaje());
        }
    }

    //Borrar afiliado
}

