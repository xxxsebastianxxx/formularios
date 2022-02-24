/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.ConectarDB;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ryzen3
 */

@Controller
public class listarMascotasController {
     private JdbcTemplate jdbcTemplate;
    
    public listarMascotasController() {
        
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
    }
    
    
    
    
    @RequestMapping("ListarMascotas.htm")
    
    public ModelAndView formUsuario(){
     ModelAndView mav = new ModelAndView();
     String sql = "select * from mascotas";
     List datosm = jdbcTemplate.queryForList(sql);
     mav.addObject("mascotas",datosm);
     mav.setViewName("views/ListarMascotas");
     return mav;
    }
}
