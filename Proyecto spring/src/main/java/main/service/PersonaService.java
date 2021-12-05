/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.service;

import java.util.List;
import main.domain.Persona;

/**
 *
 * @author facu_
 */
public interface PersonaService {
    
    public List<Persona> ListarPersonas();
    public void Guardar(Persona persona);
    public void Eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
    
}
