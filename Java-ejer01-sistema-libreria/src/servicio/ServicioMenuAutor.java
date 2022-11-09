/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidades.Autor;
import entidades.ControladoraJPA;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gusta
 */
public class ServicioMenuAutor {
    
    ControladoraJPA control = new ControladoraJPA();
    private Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    public void menuAutor(){
         System.out.println("Bienvenodo al sistema de Autor ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Crear Autor \n2. Mostrar Autor por Id\n3. Editar Autor"
                     + "\n4. Eliminar Autor\n5. Mostrar lista completa de autores \n0. Volver al menu principal");
             
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
                    System.out.println("Vamoa a crear un autor:");
                    System.out.println("Ingrese el nombre de autor: ");
                    String nombre = scan.next();
                    Autor a1 = new Autor(nombre, true);
                    control.crearAutor(a1);
                    break;
                case 2:
                    System.out.println("Ingrese el id del autor: ");
                    int id = scan.nextInt();
                    System.out.println(control.traerAutor(id));
                    break;
                case 3: 
                    System.out.println("Vamos a editar un autor: ");
                    mostrarListaAutores();
                    System.out.println("Seleccione el Id del autor a editar: ");
                    int idAutor= scan.nextInt();
                    Autor autorEdit = control.traerAutor(idAutor);
                    System.out.println("Ingrese el nombre nuevo: ");
                    String nombreNuevo= scan.next();
                    autorEdit.setNombre(nombreNuevo);
                    control.editarAutor(autorEdit);
                break;
                case 4:
                    System.out.println("Vamos a eliminar un Autor");
                    System.out.println("Para eso primero tenemos que darlos de baja");
                    mostrarListaAutores();
                    System.out.println("Seleccione el Id del autor a dar de baja: ");
                    int idAutor2= scan.nextInt();
                    Autor autorEdit2 = control.traerAutor(idAutor2);
                    autorEdit2.setAlta(false);
                    control.editarAutor(autorEdit2);
                    control.eliminarAutor(idAutor2);
                    break;
                case 5:
                    mostrarListaAutores();
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 0: 
                    break;
            }
        } while (opcion != 0);
        
    }
    
    //SubMetodos
    public void mostrarListaAutores(){
        System.out.println("La lista total de autores es la siguiente: ");
        ArrayList<Autor>listaautores = control.traerListaAutores();
        System.out.println("Id\tNOMBRE\t\tALTA");
        for (Autor listaautore : listaautores) {
            System.out.println(listaautore);
        }
       System.out.println("------------------");
    }
}
