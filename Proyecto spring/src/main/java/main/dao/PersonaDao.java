/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dao;

import main.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author facu_
 */
public interface PersonaDao extends CrudRepository <Persona, Long>{
    
}
