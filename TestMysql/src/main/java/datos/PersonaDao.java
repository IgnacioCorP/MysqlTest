/*
 *CONJUNTO DE OPERACIONES QUE PUEDO REALIZAR SOBRE UNA PERSONA
 */
package datos;

import dominio.Persona;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Usuario identificador nombre pasword
 *
 * @author Alumno Mañana
 */
public class PersonaDao {

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT into persona (name,LastName,Email,Telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET name = ?, LastName = ?, Email = ?, Telefono = ?   where Id = ?";
    private static final String SQL_DELETE = "DELETE FROM persona where Id = ?";

    //MÉTODO QUE NOS LISTA TODAS LAS PERSONAS DE NUESTRO SISTEMA las visualiza
    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while (rs.next()) {
            int Id = rs.getInt("Id");
            String name = rs.getString("name");
            String LastName = rs.getString("LastName");
            String Email = rs.getString("Email");
            String Telefono = rs.getString("Telefono");

            //Instanciar Objeto
            personas.add(new Persona(Id, name, LastName, Email, Telefono));
        }
        close(rs);
        close(stmt);
        close(conn);

        return personas;
    }

    //MÉTODO PARA INSERTAR PERSONAS EN MI SISTEMA
    public int insert(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //Establecer la conexión
            conn = getConnection();
            //Preparo mi instrucción para ejecutarlo con la base de datos
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar los valores interrogantes ? de la consulta
            stmt.setString(1, persona.getName());
            stmt.setString(2, persona.getLastName());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
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

    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getName());
            stmt.setString(2, persona.getLastName());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getId());

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

    public int eliminar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, persona.getId());

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
