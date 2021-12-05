
package main.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import main.domain.Persona;
import main.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class Controlador {
    @Autowired
    private PersonaService personaSimp;
    
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user ){
        Iterable<Persona> personas;
        personas = (Iterable<Persona>) personaSimp.ListarPersonas();
        
        log.info("usuario que hizo login" + user);
        
        model.addAttribute("personas", personas);
        Double saldoTotal=0D;
        
        for(Persona p: personas){
        saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
        return "modificar";
        }
        personaSimp.Guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idpersona}")
    public String editar(Persona persona, Model model){
        persona= personaSimp.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
     @GetMapping("/eliminar/{idpersona}")
     public String eliminar(Persona persona){
     personaSimp.Eliminar(persona);
     return "redirect:/";
     }
      @GetMapping("/muestra/{idpersona}")
    public String mostrar(Persona persona, Model model){
        persona= personaSimp.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "muestra";
    }
}

