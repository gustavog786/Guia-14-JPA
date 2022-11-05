
package principal.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.entidades.Alumno;
import principal.entidades.Carrera;
import principal.persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
 
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    CarreraJpaController carreJpa = new CarreraJpaController();

    public void crearAlumno(Alumno alu) {
        
       aluJpa.create(alu);
    }
     public void eliminarAlumno(int id) {
         
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public void editarAlumno(Alumno alumno) {

        try {
            aluJpa.edit(alumno);

        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int id) {
        
        return aluJpa.findAlumno(id);
    }
    
    public ArrayList<Alumno> traerListaAlumnos() {

        List<Alumno> listita = aluJpa.findAlumnoEntities();

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(listita);

        return listaAlumnos;
    }

    
    
    
    public void crearCarrera(Carrera carre) {
        carreJpa.create(carre);
    }

    public void eliminarCarrera(int id) {
        try {
            carreJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCarrera(Carrera carre) {
        try {
            carreJpa.edit(carre);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Carrera traerCarrera(int id) {
        return carreJpa.findCarrera(id);
    }

    public ArrayList<Carrera> traerListaCarreras() {
        
        List <Carrera> lista = carreJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarreras = new ArrayList<>(lista);
        
        return listaCarreras; 
    }
}
