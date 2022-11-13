/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utvt.mec.asistencia.Controller;

import com.utvt.mec.asistencia.Dao.AlumnoDao;
import com.utvt.mec.asistencia.Dao.AsistenciaDao;
import com.utvt.mec.asistencia.Entity.Alumno;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.utvt.mec.asistencia.Entity.Asistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author RAUL
 */

@Controller
public class TomaAsistencia {
    
    @Autowired
    private AlumnoDao alumnoDao;

    @Autowired
    private AsistenciaDao asistenciaDao;
    
    @GetMapping("/Asistencia/{matricula}")
    public String TomaAsistencia(Model model,@PathVariable String matricula){
           String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                    .format(LocalDateTime.now());
 
        
        System.out.println(alumnoDao.findByAcvealumno(matricula));
        model.addAttribute("alumno", alumnoDao.findByAcvealumno(matricula));
        model.addAttribute("fecha", dateTime);
    
    return "tomaAsistencia";
    }
    
    @GetMapping("/RegistraAsistencia/{tipo}/{matricula}")
    public String regAsistencia(Model model,@PathVariable String matricula,@PathVariable int tipo){
        Asistencia asistencia=new Asistencia();
        asistencia.setAstipo(tipo);
        asistencia.setAshora(LocalDateTime.now());
        asistencia.setAsalumno(matricula);
        asistenciaDao.save(asistencia);

        return "redirect:/";
    }
    
}
