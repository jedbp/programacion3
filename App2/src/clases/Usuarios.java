/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public class ValidarUsuario {

        public static boolean validarUsuario(String username, String clave) {
            // Simulamos un usuario en base de datos
            String usuarioValido = "jedabep";
            String claveValida = "1234";

            return username.equals(usuarioValido) && clave.equals(claveValida);
        }
    }
    
    public class RegistroUsuarios {

    private static ArrayList<Usuarios> usuariosRegistrados = new ArrayList<>();

        public static void registrarUsuario(String nombre, String email, String username, String clave) {
            Usuarios nuevoUsuario = new Usuarios();
            usuariosRegistrados.add(nuevoUsuario);
            System.out.println("Usuario registrado correctamente.");
        }

    // Método para ver usuarios registrados (opcional para pruebas)
        public static ArrayList<Usuarios> getUsuariosRegistrados() {
            return usuariosRegistrados;
        }
    }
    
    public int guardarcliente(String nombre, String email, String username, String clave)throws SQLException{
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes(nombre,email,username,clave) VALUES(?,?,?,?)";
        return db.executeUpdate(query,nombre,email,username,clave);
    }
}
