
package principal;

import entidades.Autor;
import entidades.Cliente;
import entidades.ControladoraJPA;
import entidades.Editorial;
import entidades.Libro;
import entidades.Prestamo;
import java.util.Date;
import servicio.ServicioMenu;


public class PrincipalEjer01 {

   
    public static void main(String[] args) {
//        // TODO code application logic here
//        ControladoraJPA control = new ControladoraJPA();
//        //Primero tengo que crear una editoria y un autor ya que son atributos de libro
//        //Creo editorial
//        Editorial editorial1 = new Editorial(1, "Atlantida", true);
//        //Agrego editorial a BD
//        control.crearEditorial(editorial1);
//        
//        //Creo Autor
//        Autor autor1 = new Autor(1, "Victor Sueiro", true);
//        
//        //Agrego Autor a BD
//        control.crearAutor(autor1);
//        
//        //Creo libro
//        Libro libro1 = new Libro(5445, "Libranos del mal", 2000, 100, 10,90, true, autor1, editorial1);
//        //Agrego Libro a BD
//        control.crearLibro(libro1);
        
        //ya esta cargado, no lo puedo volver a ejecutar
        
        //ServicioMenu sm = new ServicioMenu();
        // sm.menu();
         //ControladoraJPA control = new ControladoraJPA();
         
         // Primero tengo que crear una editoria y un autor ya que son atributos de libro
        //Creo editorial
//        Editorial editorial1 = new Editorial(4, "Atlantida2", true);
//        //Agrego editorial a BD
//        control.crearEditorial(editorial1);
//        
//        //Creo Autor
//        Autor autor1 = new Autor(18, "Victor Sueiro2", true);
//        
//        //Agrego Autor a BD
//        control.crearAutor(autor1);
//        
//        //Creo libro
//        Libro libro1 = new Libro(5455, "Libranos del mal2", 2000, 100, 10,90, true, autor1, editorial1);
//        //Agrego Libro a BD
//        control.crearLibro(libro1);
//        
//        //creo un cliente
//        Cliente c1 = new Cliente(30455666, "juan", "Torres", "45553366");
//        
//        //Agrego a cliente BD
//        control.crearCliente(c1);
//        
//        //creo un prestamo
//        Prestamo p1 = new Prestamo( new Date(),  new Date(), libro1, c1);
//        
//        //Agrego prestamo a BD
//        control.crearPrestamo(p1);
        
        //YA estan cargados la pruba salio bien
        
        ServicioMenu sm = new ServicioMenu();
        sm.menu();
        ControladoraJPA control = new ControladoraJPA();
    }
    
}
