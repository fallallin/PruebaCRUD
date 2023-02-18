package com.example.PruebaCRUD.Controller;

import com.example.PruebaCRUD.Entity.Persona;
import com.example.PruebaCRUD.Service.PersonaServiceIMPL.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CRUDRepo")
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaService;

    @GetMapping
    @RequestMapping(value = "ConsultarPersonas", method = RequestMethod.GET)
    public ResponseEntity<?> consultarPersonas() {
        List<Persona> listaPersona = this.personaService.ConsultarPersona();
        return ResponseEntity.ok(listaPersona);

    }

    @PostMapping
    @RequestMapping(value = "CrearPersona", method = RequestMethod.POST)
    public ResponseEntity<?> crearPersonas(@RequestBody Persona persona) {
        Persona personaCreada = this.personaService.CrearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaCreada);

    }

    @PutMapping
    @RequestMapping(value = "ModificarPersona", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarPersonas(@RequestBody Persona persona) {
        Persona personaModificada = this.personaService.CrearPersona(persona);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personaModificada);

    }

    @GetMapping
    @RequestMapping(value = "BuscarPersonas/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPersonas(@PathVariable int id) {
        Persona persona = this.personaService.BuscarPersona(id);
        return ResponseEntity.ok(persona);
    }


    @DeleteMapping
    @RequestMapping(value = "EliminarPersonas/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> EliminarPersonas(@PathVariable int id) {
        this.personaService.EliminarPersona(id);
        return ResponseEntity.ok().build();
    }
}
