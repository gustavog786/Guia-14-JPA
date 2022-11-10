package persistencia;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    LibroJpaController libroJpa = new LibroJpaController();
    EditorialJpaController editorialJpa = new EditorialJpaController();
    AutorJpaController autorJpa = new AutorJpaController();
    
    
    //Metodos libro
    public void crearLibro(Libro libro) {
        libroJpa.create(libro);
    }

    public void eliminarLibro(long bn) {
        try {
            libroJpa.destroy(bn);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLibro(Libro libro) {
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro(long bn) {
        return libroJpa.findLibro(bn);
    }

    public ArrayList<Libro> traerListaLibros() {
       List<Libro> lista = libroJpa.findLibroEntities();
       ArrayList<Libro>listaLibros = new ArrayList<>(lista);
       return listaLibros;
    }
    
    public void traerLibroPorTitulo( String titulo){
        libroJpa.consutaLibroNombre(titulo);
    }
    
    //Metodos Editorial
    public void crearEditorial(Editorial editorial) {
        editorialJpa.create(editorial);
    }

    public void eliminarEditorial(int id) {
        try {
            editorialJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarEditorial(Editorial editorial) {
        try {
            editorialJpa.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Editorial traerEditorial(int id) {
        return editorialJpa.findEditorial(id);
    }

    public ArrayList<Editorial> traerListaEditorial() {
        List<Editorial>lista = editorialJpa.findEditorialEntities();
        ArrayList<Editorial> listaEditorials = new ArrayList<>(lista);
        return listaEditorials;
    }

    
    //Metodos Autor
    public void crearAutor(Autor autor) {
       autorJpa.create(autor);
    }

    public void eliminarAutor(int id) {
        try {
            autorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAutor(Autor autor) {
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor traerAutor(int id) {
        return autorJpa.findAutor(id);
    }

    public ArrayList<Autor> traerListaAutores() {
        List<Autor> lista = autorJpa.findAutorEntities();
        ArrayList<Autor>listaAutors = new ArrayList<>(lista);
        return listaAutors;
    }
}
