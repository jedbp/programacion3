/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author estudiante
 */
public class cliente {
    
    private String nombre;
    private String email;
    private String username;
    private String clave;
    private String apellido;
    private String telefono;

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
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public ResultSet listarCliente() {
    Conector db = new Conector();
    ResultSet rs = null;

    try {
        db.conectar();
        String query = "SELECT * FROM clientes";
        rs = db.executeSelect(query);
    } catch (SQLException e) {
        System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
    }

    return rs;
}
   
    // Método para insertar un nuevo cliente en la base de datos
    public int guardarCliente(String nombre,String apellido,String telefono, String email, String username, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes (nombre,apellido,telefono, email, username, clave) VALUES (?, ?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre,apellido,telefono, email, username, clave);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarCliente(int id, String nombre,String apellido,String telefono, String email, String username, String clave) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE clientes SET nombre = ?,apellido = ?,telefono = ?, email = ?, username = ?, clave = ? WHERE id = ?";
        return db.executeUpdate(query, nombre,apellido,telefono, email, username, clave, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarCliente(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM clientes WHERE id = ?";
        return db.executeUpdate(query, id);
    }
}
