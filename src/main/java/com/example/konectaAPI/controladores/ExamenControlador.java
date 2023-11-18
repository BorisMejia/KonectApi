package com.example.konectaAPI.controladores;

import com.example.konectaAPI.entidades.Afiliado;
import com.example.konectaAPI.entidades.Examen;
import com.example.konectaAPI.servicios.ExamenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sura/examen")
public class ExamenControlador {
    @Autowired
    ExamenServicio examenServicio;
    @PostMapping
    public ResponseEntity<?> agregarExamen(@RequestBody Examen examen){
        try {
            Examen respuestaServicio = this.examenServicio.registrarExamen(examen);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping("id")
    public ResponseEntity<?> buscarExamen(@PathVariable Integer id){
        try {
            Examen respuestaServicio = this.examenServicio.consultarExamen(id);
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
    public ResponseEntity<List<Examen>> buscarTodosExamen(){
        try {
               List<Examen>listExamne = this.examenServicio.buscarTodosLosExamenes();
               return ResponseEntity
                       .status(HttpStatus.OK)
                       .body(listExamne);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
