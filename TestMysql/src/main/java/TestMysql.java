
import dominio.Persona;
import datos.PersonaDao;
import datos.UsuarioDao;
import dominio.Usuario;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {

    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();

        System.out.println("==============    TABLA PERSONA   =====================");
        Persona p1 = new Persona(1, "Max", "Mestriner", "max@gmail.com", "22425232");
        Persona p2 = new Persona(2, "Carlos", "Perez", "Perez@gmail.com", "666666666");
        //==============    TABLA PERSONA   =====================////
        //personaDao.insert(p1);
        personaDao.actualizar(p2);
        personaDao.eliminar(p1);
        //SELECCIONAR
        try {
            List<Persona> personas = personaDao.seleccionar();
            personas.forEach(persona -> {
                System.out.println("persona = " + persona);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //==============    TABLA USUARIO   =====================////
        UsuarioDao usuarioDao = new UsuarioDao();

        System.out.println("==============    TABLA USUARIO   =====================");
        Usuario U1 = new Usuario(1, "Nicolas", "cor123456");
        Usuario U2 = new Usuario(3, "Nicolas", "cor123456");

        //usuarioDao.insert(U2);  //INSERTAR     
        usuarioDao.actualizar(U1);
       usuarioDao.eliminar(U2);
        try {
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                System.out.println("Usuario = " + usuario);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}


/*
//Defino la url de conexion a nuestra base de datos y sus parametros
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false"
                + "&useTimezone=true&serverTimezone=UTC"
                + "&allowPublicKeyretrieval=true";
        try {
            //Ahora tratamos de establecer nuestra conexion con nuestra base de datos
            //Esta sentencia puede generar una excepción de SQL
            Connection conexion = DriverManager.getConnection(url, "root", "1234");

            //Creo un statement para pder ejecutar mis consultas SQL
            Statement instruccion = (Statement) conexion.createStatement();

            //Defino mi consulta SQL
            String sql = "SELECT * FROM persona";

            //Ejecuto la instrucción
            ResultSet resultado = instruccion.executeQuery(sql);

            //Mientras haya algo en resultado muestro la información iterando
            while (resultado.next()) {
                System.out.println("Id.Persona:" + resultado.getInt("Id"));
                System.out.println("Nombre:" + resultado.getNString("name"));
                System.out.println("Apellidos:" + resultado.getNString("LastName"));
                System.out.println("Gmail:" + resultado.getNString("Email"));
                System.out.println("Telefono:" + resultado.getNString("Telefono"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
 */
