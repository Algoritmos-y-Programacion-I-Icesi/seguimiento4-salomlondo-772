package model;

public class Controller {

    private Device[][] dispositivos;

    public Controller(){
        dispositivos = new Device[12][4];
    }

    public boolean agregarDispositivo(int piso, String serie, double consumo, String descripcion){
        for(int i = 0; i < dispositivos.length; i++){
            for(int j = 0; j < dispositivos[i].length; j++){
                if(dispositivos[i][j] != null && dispositivos[i][j].getSerie().equals(serie)){
                    return false;
                }
            }
        }
        for(int j = 0; j < dispositivos[piso].length; j++){
            if(dispositivos[piso][j] == null){
                dispositivos[piso][j] = new Device(serie, consumo, descripcion);
                return true;
            }
        }
        return false;
    }

    public boolean agregarEvento(String serie, LocalDate fecha, double duracionhoras){
        for(int i = 0; i < dispositivos.length; i++){
            for(int j = 0; j < dispositivos[i].length; j++){
                if(dispositivos[i][j] != null && dispositivos[i][j].getSerie().equals(serie)){
                    Event evento = new Event(fecha, duracionhoras);
                    return dispositivos[i][j].agregarEvento(evento);
                }
            }
        }
        return false;
    }

    public boolean actualizarConsumo(String serie, double nuevoConsumo){
        for(int i = 0; i < dispositivos.length; i++){
            for(int j = 0; j < dispositivos[i].length; j++){
                if(dispositivos[i][j] != null && dispositivos[i][j].getSerie().equals(serie)){
                    dispositivos[i][j].setConsumo(nuevoConsumo);
                    return true;
                }
            }
        }
        return false;
    }

    public double calcularConsumoTotal(String serie){
        for(int i = 0; i < dispositivos.length; i++){
            for(int j = 0; j < dispositivos[i].length; j++){
                if(dispositivos[i][j] != null && dispositivos[i][j].getSerie().equals(serie)){
                    double totalHoras = 0;
                    for(Event evento : dispositivos[i][j].getEvents()){
                        totalHoras += evento.getDuracionhoras();
                    }
                    return totalHoras * dispositivos[i][j].getConsumo();
                }
            }
        }
        return -1;
    }

     public String dispositivosAltoConsumo(){
        
    }

}


/** Pirmer metodo
 * Agrega un dispositivo al piso indicado.
 * Pre: piso >= 0 && piso < 12
 * Post: dispositivo agregado en la primera posicion disponible del piso
 */

/** Segundo metodo
 * Agrega un evento a un dispositivo.
 * Pre: el dispositivo con ese serial existe
 * Post: evento agregado a la lista del dispositivo
 */

/** Tercer metodo
 * Actualiza el consumo de un dispositivo.
 * Pre: el dispositivo con ese serial existe
 * Post: consumo del dispositivo actualizado
 */

/** Cuarto metodo
 * Calcula el consumo total de un dispositivo.
 * Pre: el dispositivo con ese serial existe
 * Post: retorna el consumo total en KWh, -1 si no existe
 */

/** Quinto metodo
 * Lista los dispositivos con consumo superior a 0.3 KWh.
 * Post: retorna un String con serial y consumo de cada dispositivo de alto consumo
 */