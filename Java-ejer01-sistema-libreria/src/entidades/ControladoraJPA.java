package entidades;

import java.util.ArrayList;
import persistencia.ControladoraPersistencia;


public class ControladoraJPA {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Libro
    public void crearLibro(Libro libro){
        
        controlPersis.crearLibro(libro);  
    }
    
    public void eliminarLibro(long isbn){
        
        controlPersis.eliminarLibro(isbn);
    }
    
    public void editarLibro(Libro libro){
        
        controlPersis.editarLibro(libro);
    }
    
    public Libro traerLibro(long isbn){

        return controlPersis.traerLibro(isbn);
    }
    
    public ArrayList<Libro> traerListaLibros(){
        
        return controlPersis.traerListaLibros();        
    }
    
    
    //Editorial
    public void crearEditorial(Editorial editorial){
        
        controlPersis.crearEditorial(editorial);  
    }
    
    public void eliminarEditorial(int id){
        
        controlPersis.eliminarEditorial(id);
    }
    
    public void editarEditorial(Editorial editorial){
        
        controlPersis.editarEditorial(editorial);
    }
    
    public Editorial traerEditorial(int id){

        return controlPersis.traerEditorial(id);
    }
    
    public ArrayList<Editorial> traerListaEditorial(){
        
        return controlPersis.traerListaEditorial();        
    }
    
    
    //Autor
    
      public void crearAutor(Autor autor){
        
        controlPersis.crearAutor(autor);  
    }
    
    public void eliminarAutor(int id){
        
        controlPersis.eliminarAutor(id);
    }
    
    public void editarAutor(Autor autor){
        
        controlPersis.editarAutor(autor);
    }
    
    public Autor traerAutor(int id){

        return controlPersis.traerAutor(id);
    }
    
    public ArrayList<Autor> traerListaAutores(){
        
        return controlPersis.traerListaAutores();        
    }
    
}
