
package servicio;

import entidades.ControladoraJPA;
import java.util.Scanner;


public class ServicioMenu {
    
    ControladoraJPA control = new ControladoraJPA();
    ServicioMenuLibro sml = new ServicioMenuLibro();
    ServicioMenuAutor sma = new ServicioMenuAutor();
    ServicioMenuCliente smc = new ServicioMenuCliente();
    ServicioMenuPrestamo smp = new ServicioMenuPrestamo();
    ServicioMenuEditorial sme = new ServicioMenuEditorial();
    private Scanner scan = new Scanner(System.in).useDelimiter("\n");
    
    public void menu(){
         System.out.println("Bienvenodo al sistema de Libreria ");
        int opcion = 20;
        do {
            do {
             System.out.println("Ingrese la operacion a realizar:\n1. Libro \n2. Autor\n3. Editorial"
                     + "\n4. Cliente\n5. Prestamo \n0. Salir"); 
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
                    sml.menuLibro();
                    break;
                case 2:  
                    sma.menuAutor();
                    break;
                case 3: 
                   sme.menuEditorial();
                    break;
                case 4:
                    smc.menuCliente();
                    break;
                case 5:
                    smp.menuPrestamo();
                    break;
                case 0:
                break;
            }
        } while (opcion != 0);   
    }
}
