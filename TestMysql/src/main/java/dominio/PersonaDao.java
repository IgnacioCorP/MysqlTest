/*
 *CONJUNTO DE OPERACIONES QUE PUEDO REALIZAR SOBRE UNA PERSONA
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
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
public class PersonaDao {

    private static final String SQL_SELECT = "SELECT * FROM persona";

    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs=stmt.executeQuery();
        while (rs.next()) {
                int Id = rs.getInt("Id");
                String name = rs.getString("name");
                String LastName = rs.getString("LastName");
                String Email = rs.getString("Email");
                String Telefono = rs.getString("Telefono");
                
                //Instanciar Objeto
                personas.add(new Persona(Id,name,LastName,Email,Telefono));
            }
        close(rs);
        close(stmt);
        close(conn);
        
        return personas;
    }
}
