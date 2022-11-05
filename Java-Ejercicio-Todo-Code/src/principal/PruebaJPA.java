
package principal;

import java.util.Date;
import principal.entidades.Alumno;
import principal.entidades.Carrera;
import principal.entidades.Controladora;
import principal.persistencia.ControladoraPersistencia;


public class PruebaJPA {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Controladora control = new Controladora();
        
        //Creacion Carrera
        Carrera carre = new Carrera("ingenieria22303");
        
        //Guardo Carrera en BD
        control.crearCarrera(carre);
        
        //Creacion de alumno con Carrera
        Alumno al = new Alumno(566,"Juanes", "Lopezax", new Date(),carre);
        
        //Guardo Alumno en BD
        control.crearAlumno(al);
//        
//        //Vemos Resultado
//        System.out.println("-------------------------------------------");
//        System.out.println("              DATOS ALUMNO                 ");
//        Alumno aluu = control.traerAlumno(23);
//        System.out.println("Alumno: " + aluu.getNombre() + " " + aluu.getApellido());
//        System.out.println("Cursa de carrera de " + aluu.getCarre().getNombre());
    }
    
}
