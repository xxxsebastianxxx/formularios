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
public class listarUsuarioController {

    private JdbcTemplate jdbcTemplate;
    
    public listarUsuarioController() {
        
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
    }
    
    
    
    
    @RequestMapping("ListarUsuario.htm")
    
    public ModelAndView formUsuario(){
     ModelAndView mav = new ModelAndView();
     String sql = "select * from usuarios";
     List datos = jdbcTemplate.queryForList(sql);
     mav.addObject("usuarios",datos);
     mav.setViewName("views/ListarUsuario");
     return mav;
    }
}
