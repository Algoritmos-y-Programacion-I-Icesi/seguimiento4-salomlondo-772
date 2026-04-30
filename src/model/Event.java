package model;
import java.time.LocalDate;

public class Event {

private LocalDate fecha;
private double duracionhoras;

public Event (LocalDate fecha, double duracionhoras){
    this.fecha = fecha;
    this.duracionhoras = duracionhoras;
}

public LocalDate getFecha(){
    return fecha;
}

public double getDuracionhoras(){
    return duracionhoras;
}

}