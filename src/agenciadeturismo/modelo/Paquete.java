/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeturismo.modelo;

import java.time.LocalDate;

/**
 *
 * @author Sole
 */
public class Paquete {
    
    private int id;
    private Alojamiento alojamiento;
    private Traslado traslado;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_egreso;
    private String descripcion;
    private String nombre;
            

    public Paquete(int id, Alojamiento alojamiento, Traslado traslado) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.traslado = traslado;
    }

    public Paquete(Alojamiento alojamiento, Traslado traslado) {
        this.alojamiento = alojamiento;
        this.traslado = traslado;
    }
    
    public Paquete() {}
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }
    
    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }
    
    
    
    
    
}
