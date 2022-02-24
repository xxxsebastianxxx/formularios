/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.ejb.Stateless;

/**
 *
 * @author ryzen3
 */
@Stateless
public class MascotasBean {

    private String nombre_mascota;
    private String raza;
    private String genero;
    private String tipo_de_mascotas;
    private String vacunas;

    public MascotasBean() {
    }

    public MascotasBean(String nombre_mascota, String raza, String genero, String tipo_de_mascotas, String vacunas) {
        this.nombre_mascota = nombre_mascota;
        this.raza = raza;
        this.genero = genero;
        this.tipo_de_mascotas = tipo_de_mascotas;
        this.vacunas = vacunas;
    }

 
    
    
    
    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo_de_mascotas() {
        return tipo_de_mascotas;
    }

    public void setTipo_de_mascotas(String tipo_de_mascotas) {
        this.tipo_de_mascotas = tipo_de_mascotas;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }
    
    
}
