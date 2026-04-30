package model;
import java.util.ArrayList;

public class Device {

private String serie;
private double consumo;
private String descripcion;
private ArrayList<Event> event;


public Device (String serie, double consumo, String descripcion){
     this.serie = serie;
     this.consumo = consumo;
     this.descripcion = descripcion;
     this.event = new ArrayList<>();

}
   
public boolean agregarEvento(Events evento){
    event.add(evento);
    return true;
}

public String getSerie(){
    return serie;
}

public void setSerie(String serie){
    this.serie = serie;
}

public double getConsumo(){
    return consumo;
}

public void setConsumo(double consumo){
    this.consumo = consumo;
}

public String getDescripcion(){
    return descripcion;
}

public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
}

public ArrayList<Events> getEvents(){
    return event;
}

}

