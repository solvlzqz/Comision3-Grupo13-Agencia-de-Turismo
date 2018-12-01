/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciadeturismo.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sole
 */
public class ClienteData {

    private Connection con = null;
    
    public ClienteData(Conexion conexion) {
        con = conexion.getConexion();
    }
    
    public void guardarCliente(Cliente cliente){
        try {
            
            String sql = "INSERT INTO cliente (nombre_apellido, dni, numero_celular) VALUES ( ? , ? , ? );";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombreApellido());
            statement.setInt(2, cliente.getDni());
            statement.setInt(3, cliente.getNumeroCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
    }
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
            

        try {
            String sql = "SELECT * FROM cliente;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombreApellido(resultSet.getString("nombre_apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNumeroCelular(resultSet.getInt("numero_celular"));

                clientes.add(cliente);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los clientes: " + ex.getMessage());
        }
        
        
        return clientes;
    }
    
    public void borrarCliente(int id){
    try {
            
            String sql = "DELETE FROM cliente WHERE id =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCliente(Cliente cliente){
    
        try {
            
            String sql = "UPDATE cliente SET nombre_apellido = ?, dni = ? , numero_celular =? WHERE id = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombreApellido());
            statement.setInt(2, cliente.getDni());
            statement.setInt(3, cliente.getNumeroCelular());
            statement.setInt(4, cliente.getId());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    
    public Cliente buscarCliente(int id){
    Cliente cliente =null;
    try {
            
            String sql = "SELECT * FROM cliente WHERE id =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNombreApellido(resultSet.getString("nombre_apellido"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNumeroCelular(resultSet.getInt("numero_celulaar"));

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
        
        return cliente;
    }
    
}

