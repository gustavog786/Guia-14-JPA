
package principal.entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import principal.persistencia.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearAlumno(Alumno alumno){
        
        controlPersis.crearAlumno(alumno);  
    }
    
    public void eliminarAlumno(int id){
        
        controlPersis.eliminarAlumno(id);
    }
    
    public void editarAlumno(Alumno alumno){
        
        controlPersis.editarAlumno(alumno);
    }
    
    public Alumno traerAlumno(int id){

        return controlPersis.traerAlumno(id);
    }
    
    public ArrayList<Alumno> traerListaAlumnos(){
        
        return controlPersis.traerListaAlumnos();        
    }
    
    
    //Carrera
    
    public void crearCarrera(Carrera carre){
        
        controlPersis.crearCarrera(carre);  
    }
    
    public void eliminarCarrera(int id){
        
        controlPersis.eliminarCarrera(id);
    }
    
    public void editarCarrera(Carrera carre){
        
        controlPersis.editarCarrera(carre);
    }
    
    public Carrera traerCarrera(int id){

        return controlPersis.traerCarrera(id);
    }
    
    public ArrayList<Carrera> traerListaCarreras(){
        
        return controlPersis.traerListaCarreras();        
    }
    
    
     //Materia
    
    public void crearMateria(Materia mate){
        
        controlPersis.crearMateria(mate);  
    }
    
    public void eliminarMateria(int id){
        
        controlPersis.eliminarMateria(id);
    }
    
    public void editarMateria(Materia mate){
        
        controlPersis.editarMateria(mate);
    }
    
    public Materia traerMateria(int id){

        return controlPersis.traerMateria(id);
    }
    
    public LinkedList<Materia> traerListaMaterias(){
        
        return controlPersis.traerListaMaterias();        
    }
    
}
