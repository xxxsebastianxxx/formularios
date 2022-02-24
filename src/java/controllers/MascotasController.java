/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import models.MascotaValidation;
import models.MascotasBean;
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

    @RequestMapping(value = "formMascota.htm")
public class MascotasController {
    
    private MascotaValidation mostararDatos;

    public MascotasController() {
        this.mostararDatos = new MascotaValidation();
    }
    
    
     @RequestMapping( method = RequestMethod.GET)
     public ModelAndView mascotas(){
      
        return new ModelAndView("views/formMascota", "mascotas", new MascotasBean() );
     }

      @RequestMapping( method = RequestMethod.POST)
       
      public ModelAndView mostararDatos(
             @ModelAttribute("mascotas") MascotasBean mascotas, 
              BindingResult result,
              SessionStatus status
    
      ){
          
          this.mostararDatos.validate(mascotas, result);
                 if(result.hasErrors()){
                        ModelAndView mav = new ModelAndView();
                        mav.addObject("mascotas", new MascotasBean());
                        mav.setViewName("views/formMascota");
                        return mav;
                 
                }else{ 
                    ModelAndView mav = new ModelAndView();
                    mav.setViewName("views/VistaMascotas");
                    mav.addObject("nombre_mascota",mascotas.getNombre_mascota());
                    mav.addObject("raza", mascotas.getRaza());
                    mav.addObject("genero", mascotas.getRaza());
                    mav.addObject("tipo_de_mascotas", mascotas.getTipo_de_mascotas());
                    mav.addObject("vacunas", mascotas.getVacunas());

                    return mav;
              
              }
          
        
      }  
    
}
