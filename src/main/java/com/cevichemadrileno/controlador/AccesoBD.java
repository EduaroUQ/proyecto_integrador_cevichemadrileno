package com.cevichemadrileno.controlador;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Sala;
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


    public void cargarSalas() {
        String query = "SELECT * FROM sala";
        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String codigoSala = rs.getString("codigoSala");
                Integer capacidad = rs.getInt("capacidad");
                String tipoSala = rs.getString("tipoSala");
                Sala sala = new Sala(id, codigoSala, capacidad, tipoSala);
                Constantes.salas.add(sala);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar las salas");
            e.printStackTrace();
        }
    }

    public void registrarActividad(Actividad actividad) {
        String query = "INSERT INTO actividad(id_monitor, id_sala, nombre, descripcion, nroMaximoInscritos, fecha) VALUES(?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, actividad.getIdMonitor());
            pstmt.setInt(2, actividad.getIdSala());
            pstmt.setString(3, actividad.getNombre());
            pstmt.setString(4, actividad.getDescripcion());
            pstmt.setInt(5, actividad.getNroMaximoInscritos());
            pstmt.setTimestamp(6, actividad.getFecha());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al registrar la actividad");
            e.printStackTrace();
        }
    }
}

