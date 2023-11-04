package com.example.konectaAPI.servicios;

import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.repositorios.SignoVitalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
