/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utvt.mec.asistencia.Entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

/**
 *
 * @author RAUL
 */
@Entity
@Table(name = "asistencia")
@Data
public class Asistencia {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asidasistencia;

    private Integer astipo;
    
    private LocalDateTime ashora;
    
    private String asalumno;
    
    
}
