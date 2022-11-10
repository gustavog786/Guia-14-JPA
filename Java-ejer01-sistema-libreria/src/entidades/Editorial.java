
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private boolean alta;
    
    //contructores

    public Editorial() {
    }

    public Editorial(String nombre, boolean alta) { //constructor sin id
        this.nombre = nombre;
        this.alta = alta;
    }

    
    public Editorial(int id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }
    
    
    //Getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    
    //to String

    @Override
    public String toString() {
        return  id + "\t" + nombre + "\t" + alta ;
    }
    
     public void imprimirLindo(){
        System.out.printf( "%-5d %-15s %-10b\n", id, nombre, alta );
    }
    
}
