package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.entidades.SignoVital;
import com.example.konectaAPI.servicios.SignoVitalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/signoVital")
public class SignoVitalControlador {

    @Autowired
    SignoVitalServicio signoVitalServicio;
    @PostMapping
    public ResponseEntity<?> agregarSignoVital(@RequestBody SignoVital signoVital){
        try {
            SignoVital respuestaServicio = this.signoVitalServicio.registrarSignoVital(signoVital);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping("id")
    public ResponseEntity<?> buscarSignoVital(@PathVariable Integer id){
        try {
            SignoVital respuestaServicio = this.signoVitalServicio.consultarSignoVital(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<SignoVital>> buscarTodosSignoVital(@PathVariable Integer id){
        try {
            List<SignoVital>listSignoVital = this.signoVitalServicio.buscarTodosLosSignoVital();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listSignoVital);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
