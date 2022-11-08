
package principal;

import entidades.Autor;
import entidades.ControladoraJPA;
import entidades.Editorial;
import entidades.Libro;


public class PrincipalEjer01 {

   
    public static void main(String[] args) {
        // TODO code application logic here
        ControladoraJPA control = new ControladoraJPA();
        //Primero tengo que crear una editoria y un autor ya que son atributos de libro
        //Creo editorial
        Editorial editorial1 = new Editorial(1, "Atlantida", true);
        //Agrego editorial a BD
        control.crearEditorial(editorial1);
        
        //Creo Autor
        Autor autor1 = new Autor(1, "Victor Sueiro", true);
        
        //Agrego Autor a BD
        control.crearAutor(autor1);
        
        //Creo libro
        Libro libro1 = new Libro(5445, "Libranos del mal", 2000, 100, 10,90, true, autor1, editorial1);
        //Agrego Libro a BD
        control.crearLibro(libro1);
    }
    
}
