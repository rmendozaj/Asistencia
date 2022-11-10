
package com.utvt.mec.asistencia.Controller;

import com.utvt.mec.asistencia.Dao.AlumnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author RAUL
 */
@Controller
public class RegistroController {
    
    
    @Autowired
    private AlumnoDao alumnoDao;
    
    @GetMapping("/")
    public String getVistaRegistro(Model model){
        model.addAttribute("alumnos",alumnoDao.findAll());
        
    
    return "registro";
    }
    
}
