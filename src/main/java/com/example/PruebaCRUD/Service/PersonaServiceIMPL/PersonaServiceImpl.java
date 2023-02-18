package com.example.PruebaCRUD.Service.PersonaServiceIMPL;

import com.example.PruebaCRUD.Entity.Persona;
import com.example.PruebaCRUD.Repository.PersonaRepo;
import com.example.PruebaCRUD.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepo repo;

    @Override
    public List<Persona> ConsultarPersona() {
        return (List<Persona>) this.repo.findAll();
    }

    @Override
    public Persona CrearPersona(Persona persona) {
        persona.setEmail(persona.getEmail());
        return this.repo.save(persona);
    }

    @Override
    public Persona ModificarPersona(Persona persona) {
        return this.repo.save(persona);
    }

    @Override
    public Persona BuscarPersona(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void EliminarPersona(int id) {
        this.repo.deleteById(id);
    }
}
