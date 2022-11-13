package servicio;

import entidades.Cliente;
import entidades.ControladoraJPA;
import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ServicioMenuPrestamo {
    
    ControladoraJPA control = new ControladoraJPA();
    ServicioMenuLibro sml = new ServicioMenuLibro();
    ServicioMenuCliente smc = new ServicioMenuCliente();
    private final Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    public void menuPrestamo(){
    
        System.out.println("Bienvenodo al sistema de Autor ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Crear Prestamo \n2. Mostrar Prestamo por Id\n3. Editar Prestamo"
                     + "\n4. Dar de baja y/o Eliminar Prestamo\n5. Mostrar lista completa de Prestamos \n6. Finalizar un Prestamo"
                     + "(devolver un libro)\n7. Buscar todos los préstamos de un Cliente. \n0. Volver al menu principal");
             
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(scan.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }
            
            
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 &&
                    opcion!=6 && opcion!=7 && opcion!=0 );
        
       
            switch(opcion)
            {
                case 1:    
                    System.out.println("Vamoa a crear un prestamo:");
                    Prestamo p1 = menuCrearPrestamo();
                    control.crearPrestamo(p1);
                    int diferencia = (int) (( p1.getFechaDevolucion().getTime()- p1.getFechaPrestamo().getTime())/1000/60/60/24);
                    System.out.println("El prestamo ha sido creado exitosamente y tiene una duracion de "
                            + diferencia + " dias");
                    
                    break;
                case 2:
                    System.out.println("Ingrese el id del prestamo: ");
                    int id = scan.nextInt();
                    System.out.println(control.traerPrestamo(id));
                    break;
                case 3: 
                    System.out.println("Vamos a editar un prestamo: ");
                    mostrarListaPrestamos();
                    System.out.println("Seleccione el Id del prestamo a editar: ");
                    int idPrestamo= scan.nextInt();
                    Prestamo prestamoEdit = control.traerPrestamo(idPrestamo);
                    menuEditarPrestamo(prestamoEdit);  
                break;
                case 4:
                    System.out.println("Vamos a eliminar un prestamo");
                    mostrarListaPrestamos();
                    System.out.println("Seleccione el Id del prestamo: ");
                    int idPrestamo2= scan.nextInt();
                    Prestamo prestamoEdit2 = control.traerPrestamo(idPrestamo2);
                    control.eliminarPrestamo(idPrestamo2);
                    break;
                case 5:
                    mostrarListaPrestamos();
                    break;
                case 6:
                    System.out.println("Elegiste finalizar un prestamo. ");
                    mostrarListaPrestamos();
                    System.out.println("Ingrese el Id del prestamo a finalizar: ");
                    int idFinPrestamo = scan.nextInt();
                    Prestamo prestamoFin = control.traerPrestamo(idFinPrestamo);
                    prestamoFin.setCliente( null);
                    control.editarPrestamo(prestamoFin);
                    System.out.println("Desea eliminar completamente el prestamo de la BD? s/n");
                    String respuestaFin = scan.next();
                        if (respuestaFin.equalsIgnoreCase("s")) {
                            control.eliminarPrestamo(idFinPrestamo);
                        }
                    break;
                case 7:
                    System.out.println("Ingres el nombre del cliente para ver sus prestamos: ");
                    String buscarNombreCliente= scan.next();
                    control.traerPrestamoPorCliente(buscarNombreCliente);
                    break;
                case 8:
                    
                    break;
                case 0: 
                    break;
            }
        } while (opcion != 0);
    }
    
    //Submetodos
    
    public void mostrarListaPrestamos(){
        System.out.println("La lista total de autores es la siguiente: ");
        ArrayList<Prestamo>listaprestamos = control.traerListaPrestamos();
        System.out.printf("%-5s %-20s %-20s %-20s %-10s\n", "ID","FECHA PRESTAMO", "FECHA DEVOLUCION",
                "LIBRO", "CLIENTE");
        for (Prestamo listapres : listaprestamos) {
            listapres.imprimirLindo();
        }
       System.out.println("------------------");
    }
    
    public Prestamo menuCrearPrestamo(){
        System.out.println("La fecha del prestamo se fija al dia de hoy");
        Date fechaPrestamo = new Date();
        int dia2, mes2, anio2;
        System.out.println("Fecha devolución del prestamo:");
        System.out.print("Día: ");
        dia2 = scan.nextInt();        
        System.out.print("Mes: ");
        mes2 = scan.nextInt();        
        System.out.print("Año: ");
        anio2 = scan.nextInt() - 1900;
        Date fechaDevolucion = (new Date(anio2, mes2 - 1, dia2)); 
        sml.mostrarListaLibros();
        System.out.println("Seleccione el ISBN del libro que quiere: ");
        long isbnprestamo = scan.nextLong();
        Libro libroPrestado = control.traerLibro(isbnprestamo);
        
        //ACA armo la logica para restar un libro y asinarlo a la BD
        libroPrestado.setEjemplaresPrestados(libroPrestado.getEjemplaresPrestados()+1);
        libroPrestado.setEjemplaresRestantes(libroPrestado.getEjemplaresRestantes()-1);
        control.editarLibro(libroPrestado);
        smc.mostrarListaClientes();
        System.out.println("Seleccione el Id del cliente: ");
        int idClientePrestamo = scan.nextInt();
        Cliente clientePrestamo = control.traerCliente(idClientePrestamo);
        
        return new Prestamo(fechaPrestamo, fechaDevolucion, libroPrestado, clientePrestamo);
    }
    
    public void menuEditarPrestamo(Prestamo p1){
        System.out.println("Bienvenodo al sistema edicion de un Prestamo ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Editar fechaPrestamo \n2. Editar fechaDevolucion\n3. Editar libro prestado"
                     + "\n4. Editar Cliente de prestamo \n0. Volver al menu principal");
            try {
                opcion = 20; // se reinicia con una opcion diferente a una valida
                opcion=Integer.parseInt(scan.next());
                break;
                }catch(Exception ex) {
                    System.out.println("Error, ingrese un numero ");
            }    
        } while (opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=0 );
            switch(opcion)
            {
                case 1:    
                    int dia1, mes1, anio1;
                    System.out.println("Fecha nuevo  de inicio del prestamo: ");
                    System.out.print("Día: ");
                    dia1 = scan.nextInt();        
                    System.out.print("Mes: ");
                    mes1 = scan.nextInt();        
                    System.out.print("Año: ");
                    anio1 = scan.nextInt() - 1900; 
                    p1.setFechaPrestamo(new Date(anio1, mes1 - 1, dia1));
                    control.editarPrestamo(p1);
                    break;
                case 2:  
                    int dia2, mes2, anio2;
                    System.out.println("Fecha nueva de devolución:");
                    System.out.print("Día: ");
                    dia2 = scan.nextInt();        
                    System.out.print("Mes: ");
                    mes2 = scan.nextInt();        
                    System.out.print("Año: ");
                    anio2 = scan.nextInt() - 1900;
                    p1.setFechaDevolucion(new Date(anio2, mes2 - 1, dia2));
                    control.editarPrestamo(p1);
                break;
                case 3:
                    sml.mostrarListaLibros();
                    System.out.println("Ingrese el nuevo ISBN del libro a prestar: ");
                    long isbnNuevo = scan.nextInt();
                    Libro nuevoLibroPrestamo = control.traerLibro(isbnNuevo);
                    p1.setLibro(nuevoLibroPrestamo);
                    control.editarPrestamo(p1);
                break;
                case 4:
                    smc.mostrarListaClientes();
                    System.out.println("Ingrese el nuevo Id del cliente para el prestamo: ");
                    int nuevoIdPrestamo = scan.nextInt();
                    Cliente nuevoClientePrestamo = control.traerCliente(nuevoIdPrestamo);
                    p1.setCliente(nuevoClientePrestamo);
                    control.editarPrestamo(p1);
                    break;
                case 0: 
                    break;
            }
        } while (opcion != 0);
    }
}
