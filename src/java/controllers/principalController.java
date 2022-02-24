/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;


import models.MascotaValidation;
import models.MascotasBean;
import models.UsuarioBean;
import models.UsuariosValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ryzen3
 */
@Controller
@RequestMapping(value = "formUsuario.htm")
public class principalController {
    
      private UsuariosValidation mostararDatos;

    public principalController() {
        this.mostararDatos = new UsuariosValidation();
    }
    
    
   @RequestMapping(method = RequestMethod.GET)
     public ModelAndView users(){
      
        return new ModelAndView("views/formUsuario", "usuarios", new UsuarioBean() );
     }

      @RequestMapping( method = RequestMethod.POST)
      
      public ModelAndView mostararDatos(
        
              @ModelAttribute("usuarios") UsuarioBean users, 
              BindingResult result,
              SessionStatus status
      ){  
           this.mostararDatos.validate(users, result);
              if(result.hasErrors()){
                    ModelAndView mav = new ModelAndView();
                    mav.setViewName("views/formUsuario");
                    return mav;
              }else{
               ModelAndView mav = new ModelAndView();
               mav.setViewName("views/VistaUsuario");
               mav.addObject("nombre",users.getNombre());
               mav.addObject("apellido", users.getApellido());
               mav.addObject("tipo_de_identificacion", users.getTipo_de_identificacion());
               mav.addObject("identificacion", users.getIdentificacion());
               mav.addObject("direccion", users.getDireccion());
          
               return mav;
      }
  }
  
   
}
