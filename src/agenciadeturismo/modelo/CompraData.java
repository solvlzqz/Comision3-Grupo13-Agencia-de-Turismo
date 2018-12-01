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
public class CompraData {
    
    private Connection con = null;
    private Conexion conexion;
    
    public CompraData(Conexion conexion) {
        con = conexion.getConexion();
    }
    
    public void guardarCompra(Compra compra){
        try {
            
            String sql = "INSERT INTO compra (id_cliente, id_paquete) VALUES ( ? , ? );";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, compra.getCliente().getId());
            statement.setInt(2, compra.getPaquete().getId());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                compra.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una compra: " + ex.getMessage());
        }
    }
    
    public List<Compra> obtenerCompra(){
        List<Compra> compras = new ArrayList<Compra>();
            

        try {
            String sql = "SELECT * FROM compra;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Compra compra;
            while(resultSet.next()){
                compra = new Compra();
                compra.setId(resultSet.getInt("id"));
               
                Cliente cl = buscarCliente(resultSet.getInt("id_cliente"));
                compra.setCliente(cl);
                
                Paquete pq = buscarPaquete(resultSet.getInt("id_paquete"));
                compra.setPaquete(pq);          

                compras.add(compra);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las compras: " + ex.getMessage());
        }
        
        
        return compras;
    }
    
    public List<Compra> obtenerComprasXCliente(int id){
        List<Compra> compras = new ArrayList<Compra>();
            

        try {
            String sql = "SELECT * FROM compra WHERE id_cliente = ?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            Compra compra;
            while(resultSet.next()){
                compra = new Compra();
                compra.setId(resultSet.getInt("id"));
                
                Cliente cl=buscarCliente(resultSet.getInt("id_cliente"));
                compra.setCliente(cl);
                
                Paquete pq = buscarPaquete(resultSet.getInt("id_paquete"));
                compra.setPaquete(pq);               

                compras.add(compra);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las compras: " + ex.getMessage());
        }
        
        
        return compras;
    }
    
    public Cliente buscarCliente(int id){
    
        ClienteData cd=new ClienteData(conexion);
        
        return cd.buscarCliente(id);
        
    }
    
    public Paquete buscarPaquete(int id) {
        
        PaqueteData pq=new PaqueteData(conexion);
        
        return pq.buscarPaquete(id);
    }
    
    public List<Paquete> obtenerPaquetesComprados(int id) {
        
      List<Paquete> paquetes = new ArrayList<Paquete>();
            

        try {
            String sql = "SELECT id_paquete FROM compra, paquete WHERE compra.id_paquete = paquete.id\n" +
"and compra.id_cliente = ?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Paquete paquete;
            while(resultSet.next()){
                paquete = new Paquete();
                paquete.setId(resultSet.getInt("id_paquete"));
                paquete.setAlojamiento(resultSet)// profe aca tengo duda, el get debería ser Object? 
                        //como sería en ese caso?
                
                paquetes.add(paquete);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los paquetes: " + ex.getMessage());
        }
        
        
        return materias;
    }
     
    
    public void borrarCompra(int id){
    try {
            
            String sql = "DELETE FROM compra WHERE id =?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar cliente : " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCompra(int id_cliente, int id_paquete){
    
        try {
            
            String sql = "UPDATE compra SET id_paquete= ? WHERE id_cliente = ?;";

            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_paquete);
            statement.setInt(2, id_cliente);
            statement.executeUpdate();
            
          statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar compra: " + ex.getMessage());
        }
    
    }
    
    public Cliente buscarCompra(int id){
    Compra compra =null;
    try {
            
            String sql = "SELECT * FROM compra WHERE id =?;";

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
