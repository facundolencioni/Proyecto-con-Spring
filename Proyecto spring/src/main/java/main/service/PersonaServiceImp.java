package main.service;

import java.util.List;
import javax.transaction.Transactional;
import main.dao.PersonaDao;
import main.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonaServiceImp implements PersonaService{
    @Autowired   
    private PersonaDao personaDao;
    @Override
    @Transactional
    public List<Persona> ListarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void Guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void Eliminar(Persona persona) {
    personaDao.delete(persona);
    }

    @Transactional
    @Override
    public Persona encontrarPersona(Persona persona) {
     Persona a = personaDao.findById(persona.getIdpersona()).orElse(null);
    return a;
    }
    
}
