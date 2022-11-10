/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utvt.mec.asistencia.Entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author RAUL
 */
@Entity
@Table(name = "asistencia")
@Data
public class Asistencia {
    
    
    @Id
    private Integer asidasistencia;

    private Integer astipo;
    
    private LocalDateTime ashora;
    
    private String asalumno;
    
    
}
