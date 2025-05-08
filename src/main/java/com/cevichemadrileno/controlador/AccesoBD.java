package com.cevichemadrileno.controlador;

import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.util.Constantes;

import java.sql.*;
/**
 * Clase para la conexion a la base de datos que contiene metodos para interactuar con la BBDD.
 *
 * @author Cristhian C.
 * @author Eduardo U.
 * @author Hugo R.
 */
public class AccesoBD {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url ="jdbc:mysql://localhost:3306/ceviche_madrileno";
    private String usuarioSQL = "root";
    private String passwordSQL = "123456";

    /**
     * Comprueba si existe un usuario en la base de datos
     * @param matricula
     * @return true si existe, false si no
     */
    public boolean existeUsuario(String matricula) {
        String query = "select * from usuario where matricula=?";
        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setString(1, matricula);
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean existe = rs.next();
                return existe;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    /**
     * Intenta loguear al usuario mediante su usuario y contraseña
     * @param usuario
     * @param clave
     * @return
     */
    public boolean login(String usuario, String clave) {
        String queryUsuario = "SELECT * FROM usuario WHERE matricula=? AND clave=?";
        String queryDescripcion = "SELECT * FROM usuario_descripcion WHERE matricula=?";

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmtUsuario = con.prepareStatement(queryUsuario)
        ) {
            pstmtUsuario.setString(1, usuario);
            pstmtUsuario.setString(2, clave);

            // Obtener los datos del usuario
            try (ResultSet rsUsuario = pstmtUsuario.executeQuery()) {
                if (rsUsuario.next()) {
                    Usuario usuarioAutenticado = new Usuario();
                    usuarioAutenticado.setId(rsUsuario.getInt("id"));
                    usuarioAutenticado.setCodigoMatricula(rsUsuario.getString("matricula"));
                    usuarioAutenticado.setClave(rsUsuario.getString("clave"));
                    usuarioAutenticado.setEsMonitor(rsUsuario.getBoolean("esMonitor"));
                    usuarioAutenticado.setNombreApellidos(rsUsuario.getString("nombreApellidos"));
                    usuarioAutenticado.setCiclo(rsUsuario.getString("ciclo"));

                    Constantes.usuarioAutenticado = usuarioAutenticado;
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en statement SQL");
            e.printStackTrace();
        }

        return false;
    }




    /**
     * Registra a un usuario
     * @param usuario
     */
    public void registrarUsuario(Usuario usuario) {
        String queryUsuario = "INSERT INTO usuario(matricula, clave, esMonitor, nombreApellidos, ciclo) VALUES(?, ?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmtUsuario = con.prepareStatement(queryUsuario);
        ) {

            // Insertar el usuario
            pstmtUsuario.setString(1, usuario.getCodigoMatricula());
            pstmtUsuario.setString(2, usuario.getClave());
            pstmtUsuario.setBoolean(3, usuario.getEsMonitor() != null ? usuario.getEsMonitor() : false);
            pstmtUsuario.setString(4, usuario.getNombreApellidos());
            pstmtUsuario.setString(5, usuario.getCiclo());
            pstmtUsuario.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al registrar el usuario");
            e.printStackTrace();
        }
    }


}

