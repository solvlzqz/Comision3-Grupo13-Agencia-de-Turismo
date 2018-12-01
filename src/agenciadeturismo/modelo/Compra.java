/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeturismo.modelo;

/**
 *
 * @author Sole
 */
public class Compra {
    
    private int id = -1;
    private Cliente cliente;
    private Paquete paquete;

    public Compra(Cliente cliente, Paquete paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }
    
    public Compra(int id, Cliente cliente, Paquete paquete) {
        this.id = id;
        this.cliente = cliente;
        this.paquete = paquete;
    }
    
    public Compra() {}
    
    public int getId() {
        return id;
    } 
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Paquete getPaquete() {
        return paquete;
    }
    
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }   
    
}
