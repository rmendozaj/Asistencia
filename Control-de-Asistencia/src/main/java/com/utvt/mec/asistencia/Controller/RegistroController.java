
package com.utvt.mec.asistencia.Controller;

import com.utvt.mec.asistencia.Dao.AlumnoDao;
import com.utvt.mec.asistencia.Entity.Alumno;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/GeneraGafete/{matricula}")
    public String generaGafete(HttpServletResponse response,@PathVariable String matricula) throws IOException {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"Constancia.pdf\""));
            OutputStream out = response.getOutputStream();
            generaGft(matricula, out);
            out.close();
        return "redirect:/";
    }



    @GetMapping("/Registro/Alumno")

    public String registraAlumno(Alumno alumno){
        alumnoDao.save(alumno);
    return "redirect:/";
}


    public void generaGft(String matricula,OutputStream out) throws FileNotFoundException {

        var alumno=alumnoDao.findByAcvealumno(matricula);

        try {
            String sourceFileName = "C:\\GafeteDiseño\\gafete.jrxml";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("urlqr","localhost:8080/Asistencia/"+matricula);
            parameters.put("nombrec",alumno.getAnombre()+" "+alumno.getAapaterno()+" "+alumno.getAamaterno());
            parameters.put("carrera",alumno.getAcarrera());
            parameters.put("matricula",alumno.getAcvealumno());
            parameters.put("grupo",alumno.getAgrupo());


            InputStream input = new FileInputStream(new File(sourceFileName));
            JasperDesign jasDesign = JRXmlLoader.load(input);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Prueba\\bo.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
        } catch (JRException ex) {
            System.out.println("Error al Generar PDF " + ex);
        }
    }
    
}
