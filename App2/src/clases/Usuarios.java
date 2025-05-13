/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiantes
 */
public class Usuarios {
    
    private String nombre;
    private String email;
    private String username;
    private String clave;

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String username, String clave) {
        Conector ae = new Conector();
        
        try {
            ae.conectar();
            String query = "SELECT * FROM usuario WHERE username = ? AND clave = ?";
            ResultSet rs = ae.executeSelect(query, username, clave);
            return rs.next();
            
        }catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }finally {
           ae.desconectar();
        }
    }
    
    public ResultSet listarUsuarios() {
        Conector db = new Conector();
        ResultSet rs = null;

        try {
            db.conectar();
            String query = "SELECT * FROM usuario";
            rs = db.executeSelect(query);
        } catch (SQLException e) {
            System.err.println("Error al listar los usuarios: " + e.getMessage());
        }

        return rs;
    }
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarUsuario(String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO usuario (nombre, apellido, username, email, clave) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, username, email, clave);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarUsuario(int id,String nombre, String apellido, String username, String email, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE usuario SET nombre = ?, apellido = ?, email = ?, username = ?, clave = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, username, email, clave, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarUsuario(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM usuario WHERE id = ?";
        return db.executeUpdate(query, id);
    } 
}
