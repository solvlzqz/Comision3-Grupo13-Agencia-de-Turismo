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
public class Cliente {
    
    private int id;
    private String nombre_apellido;
    private int dni;
    private int numero_celular;

    public Cliente(int id, String nombre_apellido, int dni, int numero_celular) {
        this.id = id;
        this.nombre_apellido = nombre_apellido;
        this.dni = dni;
        this.numero_celular = numero_celular;
    }

    public Cliente(String nombre_apellido, int dni, int numero_celular) {
        this.nombre_apellido = nombre_apellido;
        this.dni = dni;
        this.numero_celular = numero_celular;
        this.id = -1;
    }
    
    public Cliente() {
        this.id = -1;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombreApellido() {
        return nombre_apellido;
    }

    public void setNombreApellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    } 
    
    public int getDni() {
        return dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public int getNumeroCelular() {
        return numero_celular;
    }
    
    public void setNumeroCelular(int numero_celular) {
        this.numero_celular = numero_celular;
    }
    
    }
