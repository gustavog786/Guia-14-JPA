
package principal;

import java.util.Date;
import java.util.LinkedList;
import principal.entidades.Alumno;
import principal.entidades.Carrera;
import principal.entidades.Controladora;
import principal.entidades.Materia;
import principal.persistencia.ControladoraPersistencia;


public class PruebaJPA {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Controladora control = new Controladora();
        
        //Pare relacion 1 a 1
//        //Creacion Carrera
//        Carrera carre = new Carrera("ingenieria22303");
//        
//        //Guardo Carrera en BD
//        control.crearCarrera(carre);
//        
//        //Creacion de alumno con Carrera
//        Alumno al = new Alumno(566,"Juanes", "Lopezax", new Date(),carre);
//        
//        //Guardo Alumno en BD
//        control.crearAlumno(al);
//        
//        //Vemos Resultado
//        System.out.println("-------------------------------------------");
//        System.out.println("              DATOS ALUMNO                 ");
//        Alumno aluu = control.traerAlumno(23);
//        System.out.println("Alumno: " + aluu.getNombre() + " " + aluu.getApellido());
//        System.out.println("Cursa de carrera de " + aluu.getCarre().getNombre());



           //Para relacion 1 a muchos borro datos de BD
           
           //Creamos lista de materias y las agregamos
           LinkedList<Materia> listaMaterias = new LinkedList<Materia>();
           
           //Creacion de carrera con lista de materias
           
           Carrera carre = new Carrera(25,"Tecnicatura en Programacion",listaMaterias);
//        
//        //Guardo Carrera en BD
            control.crearCarrera(carre);
           
           //creacion Materias
           Materia mate1 = new Materia(58, "programacion 1", "Cuatrimestral",carre);
           Materia mate2 = new Materia(59, "programacion 2", "Cuatrimestral",carre);
           Materia mate3 = new Materia(60, "programacion Avanzada", "Anual",carre);
           
           //Agregar Materias a BD
           control.crearMateria(mate1);
           control.crearMateria(mate2);
           control.crearMateria(mate3);
           
           
           listaMaterias.add(mate1);
           listaMaterias.add(mate2);
           listaMaterias.add(mate3);
           
           carre.setListaMaterias(listaMaterias);
           control.editarCarrera(carre);
//        
//        //Creacion de alumno con Carrera
            Alumno al = new Alumno(23,"Juan", "Lopez", new Date(),carre);
//        
//        //Guardo Alumno en BD
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
