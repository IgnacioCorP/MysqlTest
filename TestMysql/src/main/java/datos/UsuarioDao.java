/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class UsuarioDao {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT into usuario(Name,Password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET Name = ?, Password = ?   where Id = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario where Id = ?";
    //MÉTODO QUE NOS LISTA TODAS LAS PERSONAS DE NUESTRO SISTEMA las visualiza

    public List<Usuario> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            int Id = rs.getInt("Id");
            String Name = rs.getString("Name");
            String Password = rs.getString("Password");

            //Instanciar Objeto
            usuarios.add(new Usuario(Id, Name, Password));
        }
        close(rs);
        close(stmt);
        close(conn);

        return usuarios;
    }

    //MÉTODO PARA INSERTAR PERSONAS EN MI SISTEMA
    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getPassword());

            //Ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    //MÉTODO DONDE ACTUALIZAREMOS UNA PERSONA DE NUESTRA COLECCIÓN
    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    //MÉTODO PARA ELIMINAR UNO DE LOS USUARIOS POR ID
    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, usuario.getId());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

}
