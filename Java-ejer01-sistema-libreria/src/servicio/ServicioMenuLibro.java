/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidades.Autor;
import entidades.ControladoraJPA;
import entidades.Editorial;
import entidades.Libro;
import java.util.ArrayList;
import java.util.Scanner;


public class ServicioMenuLibro {
    
    ControladoraJPA control = new ControladoraJPA();
    private Scanner scan = new Scanner(System.in).useDelimiter("\n");
    ServicioMenuAutor sma = new ServicioMenuAutor();
    ServicioMenuEditorial sme = new ServicioMenuEditorial();
    public void menuLibro(){
         System.out.println("Bienvenodo al sistema de Libro ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Crear Libro \n2. Mostrar Libro\n3. Editar un libro"
                     + "\n4. Eliminar un libro\n5. Mostra lista completa de libros \n0. Volver al menu principal");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(scan.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }
            
            
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=0 );
        
       
            switch(opcion)
            {
                case 1:    
                    System.out.println("Vamos a crear un nuevo Libro");
                    Libro l1 = crearLibroMenu();
                    control.crearLibro(l1);
                    break;
                case 2:  
                    System.out.println("Ingrese el ISBN del libro: ");
                    long isbn= scan.nextLong();
                    System.out.println(control.traerLibro(isbn));
                break;
                case 3: 
                    System.out.println("Vamos a editar un libro: ");
                    mostrarListaLibros();
                    System.out.println("Ingrese el ISBN del libro a editar: ");
                    long isbn2 = scan.nextLong();
                    Libro libroEdit = control.traerLibro(isbn2);
                    menuEditarLibro(libroEdit);
                break;
                case 4:
                    System.out.println("Vamos a eliminar un Libro");
                    System.out.println("Para eso primero tenemos que darlos de baja");
                    mostrarListaLibros();
                    System.out.println("Seleccione el ISBN del LIBRO a dar de baja: ");
                    long isbnLibro= scan.nextInt();
                    Libro libroEdit2 = control.traerLibro(isbnLibro);
                    libroEdit2.setAlta(false);
                    control.editarLibro(libroEdit2);
                    control.eliminarLibro(isbnLibro);
                    break;
                case 5:
                    mostrarListaLibros();
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 0: break;
            }
        } while (opcion != 0);
        
    }
    //Submetodos
    public Libro crearLibroMenu(){
        System.out.println("Ingrese el numero ISBN: ");
        long isbn = scan.nextLong();
        System.out.println("Ingrese el nombre del libro: ");
        String nombre= scan.next();
        System.out.println("Ingrese el año: ");
        int anio= scan.nextInt();
        System.out.println("Ingrese el total de ejemplares: ");
        int ejemplaresTotal = scan.nextInt();
        System.out.println("Ingrese el total de ejemplares prestados: ");
        int ejemplaresPrestados= scan.nextInt();
        int ejemplaresRestantes = ejemplaresTotal-ejemplaresPrestados;
        sma.mostrarListaAutores();
        System.out.println("Seleccione el Id del autor del libro: ");
        int idAutor= scan.nextInt();
        Autor autorlibro = control.traerAutor(idAutor);
        sme.mostrarListaEditoriales();
        System.out.println("Seleccione el Id de la editorial del libro: ");
        int idEditorial= scan.nextInt();
        Editorial editorialLibro = control.traerEditorial(idEditorial);
        
        return  new Libro(isbn, nombre, anio, ejemplaresTotal, ejemplaresPrestados, ejemplaresRestantes, true, autorlibro, editorialLibro);
    }
    public void mostrarListaLibros(){
        System.out.println("La lista total de Libros es la siguiente: ");
        ArrayList<Libro>listalibros = control.traerListaLibros();
        System.out.println("ISBN\tNOMBRE           \tANIO\tTOTAL\tPRESTADOS\tRESTANTES\tALTA\tAUTOR\tEDITORIAL");
        for (Libro aux : listalibros) {
            System.out.println(aux);
        }
       System.out.println("------------------");
    }

    private void menuEditarLibro(Libro l1) {
        System.out.println("Bienvenodo al sistema edicion de un Libro ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Editar nombre \n2. Editar año\n3. Editar ejempleres totales"
                     + "\n4. editar ejempleres prestados\n5. Editar Autor\n6. Editar Editorial \n0. Volver al menu principal");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(scan.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }
            
            
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 && opcion!=6 && opcion!=0 );
        
       
            switch(opcion)
            {
                case 1:    
                    System.out.println("Ingrese el titulo nuevo: ");
                    String nombreNuevo = scan.next();
                    l1.setTitulo(nombreNuevo);
                    control.editarLibro(l1);
                    break;
                case 2:  
                    System.out.println("Ingrese el nuevo año del libro: ");
                    int anioNuevo = scan.nextInt();
                    l1.setAnio(anioNuevo);
                    control.editarLibro(l1);
                break;
                case 3: 
                    System.out.println("Ingrese la nueva cantidad de ejemplares totales: ");
                    int ejempleresTotalesNuevos = scan.nextInt();
                    l1.setEjemplares(ejempleresTotalesNuevos);
                    control.editarLibro(l1);
                break;
                case 4:
                    System.out.println("Ingrese la nueva cantidad de ejemplares prestados: ");
                    int ejemplaresPrestadosNuevos = scan.nextInt();
                    l1.setEjemplares(ejemplaresPrestadosNuevos);
                    control.editarLibro(l1);
                    break;
                case 5:
                    sma.mostrarListaAutores();
                    System.out.println("Seleccione el Id del nuevo autor del libro: ");
                    int idAutor= scan.nextInt();
                    Autor autorlibro = control.traerAutor(idAutor);
                    l1.setAutor(autorlibro);
                    control.editarLibro(l1);
                    break;
                case 6:
                    sme.mostrarListaEditoriales();
                    System.out.println("Seleccione el Id de la editorial nueva del libro: ");
                    int idEditorial= scan.nextInt();
                    Editorial editorialLibro = control.traerEditorial(idEditorial);
                    l1.setEditorial(editorialLibro);
                    control.editarEditorial(editorialLibro);
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 0: break;
            }
        } while (opcion != 0);
    }
}
