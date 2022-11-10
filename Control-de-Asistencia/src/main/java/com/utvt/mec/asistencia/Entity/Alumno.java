/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utvt.mec.asistencia.Entity;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author RAUL
 */
@Entity
@Table(name = "alumno")
@Data
public class Alumno {
    
    @Id
    private String acvealumno;
    
    private String anombre;
    
    private String aapaterno;
    
    private String aamaterno;
    
    private String agrupo;
    
    private String acarrera;
    
    
}
