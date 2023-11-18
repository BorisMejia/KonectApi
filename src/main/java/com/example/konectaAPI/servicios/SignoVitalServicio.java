package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.repositorios.SignoVitalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignoVitalServicio
{
    @Autowired
    private SignoVitalRepositorio signoVitalRepositorio;

    public SignoVital registrarSignoVital(SignoVital signoVital) throws Exception
    {
        try {
            return this.signoVitalRepositorio.save(signoVital);
        }catch (Exception error)
        {
            throw new Exception(Utilidad.REGISTRAR_USUARIO.getMensaje());
        }
    }
    public SignoVital consultarSignoVital(Integer idSignoVital)throws Exception
    {
        try
        {
            Optional<SignoVital> SignoVitalBuscado = this.signoVitalRepositorio.findById(idSignoVital);
            if (SignoVitalBuscado.isPresent())//lo encontre en la base de datos
            {
                return SignoVitalBuscado.get();
            }else //no lo encontro
            {
                throw new Exception("Afiliado no encontrado");
            }

        }catch (Exception error)
        {
            throw new Exception(Utilidad.CONSULTAR_USUARIO.getMensaje());
        }
    }
    public List<SignoVital> buscarTodosLosSignoVital()throws Exception{
        try {
           List<SignoVital>listSignoVital = this.signoVitalRepositorio.findAll();
           return listSignoVital;
        }catch (Exception error){
            throw new Exception(Utilidad.CONSULTAR_TODOS_SIGNOVITAL.getMensaje());
        }
    }
}
