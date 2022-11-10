/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utvt.mec.asistencia.Dao;

import com.utvt.mec.asistencia.Entity.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RAUL
 */
public interface AlumnoDao extends JpaRepository<Alumno, String>{
    
    public Alumno findByAcvealumno(String acvealumno);
}
