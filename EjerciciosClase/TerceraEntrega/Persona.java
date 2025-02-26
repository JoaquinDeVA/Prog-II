package terceraEntrega;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento){

        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre(){
        return nombre;
    }
    public long calcularEdad(){
       
        if(LocalDate.now().getMonthValue() > fechaNacimiento.getMonthValue()){ //Si el mes de cumpleaños ha pasado 
            
            return LocalDate.now().getYear() - fechaNacimiento.getYear();
        } else if(LocalDate.now().getMonthValue() == fechaNacimiento.getMonthValue()){ //Si estamos en el mes comprobamos el dia

            if(LocalDate.now().getDayOfMonth() >= fechaNacimiento.getDayOfMonth()){

                return LocalDate.now().getYear() - fechaNacimiento.getYear();
            } 
        }   
        return LocalDate.now().getYear() - fechaNacimiento.getYear() - 1; // No ha ocurrido su cumpleaños por lo que restamos 1.
    }

    public String toString(){
        return ("El nombre: " + nombre + ", edad: " + calcularEdad() + " años");
    }
}
