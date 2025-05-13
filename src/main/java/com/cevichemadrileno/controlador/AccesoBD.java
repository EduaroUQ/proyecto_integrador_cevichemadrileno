package com.cevichemadrileno.controlador;

import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Inscripcion;
import com.cevichemadrileno.modelo.Sala;
import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.util.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            pstmtUsuario.setBoolean(3, usuario.getEsMonitor());
            pstmtUsuario.setString(4, usuario.getNombreApellidos());
            pstmtUsuario.setString(5, usuario.getCiclo());
            pstmtUsuario.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al registrar el usuario");
            e.printStackTrace();
        }
    }

    /**
     * Carga las salas de la base de datos
     */
    public void cargarSalas() {
        String query = "SELECT * FROM sala";
        ArrayList<Sala> salas = new ArrayList<>();
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
                salas.add(sala);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar las salas");
            e.printStackTrace();
        }
        Constantes.salas = salas;
    }

    /**
     * Registra una actividad en la base de datos
     * @param actividad
     */
    public void registrarActividad(Actividad actividad) {
        String query = "INSERT INTO actividad(id_monitor, id_sala, nombre, descripcion, nroMaximoInscritos, fecha) VALUES(?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, Constantes.usuarioAutenticado.getId());
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

    /**
     * Obtiene todas las actividades de la base de datos
     * @return ArrayList<Actividad>
     */
    public ArrayList<Actividad> obtenerActividades() {
        String query = "SELECT a.id, a.nombre, a.descripcion, a.nroMaximoInscritos, a.fecha, s.codigoSala, s.tipoSala FROM actividad a, sala s where a.id_sala = s.id";
        ArrayList<Actividad> actividades = new ArrayList<>();

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("id"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setDescripcion(rs.getString("descripcion"));
                actividad.setNroMaximoInscritos(rs.getInt("nroMaximoInscritos"));
                actividad.setFecha(rs.getTimestamp("fecha"));

                // Crear y asociar la sala
                Sala sala = new Sala();
                sala.setCodigoSala(rs.getString("codigoSala"));
                sala.setTipoSala(rs.getString("tipoSala"));

                actividad.setSala(sala);

                actividades.add(actividad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las actividades");
            e.printStackTrace();
        }
        return actividades;
    }

    /**
     * Obtiene las actividades inscritas por el usuario autenticado
     * @return ArrayList<Inscripcion>
     */
    public ArrayList<Inscripcion> obtenerActividadesInscritas() {
        String query = "select a.id as idActividad, a.nombre as nombreActividad, a.fecha as fechaActividad, s.tipoSala as tipoSala  from INSCRIPCION i , SALA s, ACTIVIDAD a where i.id_actividad = a.id and s.id = a.id_sala and i.id_usuario = ?";
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, Constantes.usuarioAutenticado.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdActividad(rs.getInt("idActividad"));

                Sala sala = new Sala();
                sala.setTipoSala(rs.getString("tipoSala"));

                Actividad actividad = new Actividad();
                actividad.setNombre(rs.getString("nombreActividad"));
                actividad.setFecha(rs.getTimestamp("fechaActividad"));
                actividad.setSala(sala);

                inscripcion.setActividad(actividad);
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las actividades inscritas");
            e.printStackTrace();
        }
        return inscripciones;
    }

    /**
     * Obtiene las actividades creadas por el monitor autenticado
     * @return ArrayList<Actividad>
     */
    public ArrayList<Actividad> obtenerActividadesCreadas() {
        String query = "select a.id as idActividad, a.nombre as nombreActividad, a.fecha as fechaActividad, s.tipoSala as tipoSala  from ACTIVIDAD a, SALA s where a.id_sala = s.id and a.id_monitor = ?";
        ArrayList<Actividad> actividadesCreadas = new ArrayList<>();

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, Constantes.usuarioAutenticado.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("idActividad"));
                actividad.setNombre(rs.getString("nombreActividad"));
                actividad.setFecha(rs.getTimestamp("fechaActividad"));

                Sala sala = new Sala();
                sala.setTipoSala(rs.getString("tipoSala"));

                actividad.setSala(sala);
                actividadesCreadas.add(actividad);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las actividades creadas");
            e.printStackTrace();
        }
        return actividadesCreadas;
    }

    /**
     * Desinscribe al usuario autenticado de una actividad
     * @param idActividad
     */
    public void desinscribirseDeActividad(Integer idActividad) {
        String query = "DELETE FROM INSCRIPCION WHERE id_actividad = ? AND id_usuario = ?";
        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, idActividad);
            pstmt.setInt(2, Constantes.usuarioAutenticado.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al desinscribirse de la actividad");
            e.printStackTrace();
        }
    }

    /**
     * Elimina una actividad de la base de datos y sus inscripciones
     * @param idActividad
     */
    public void eliminarActividad(Integer idActividad) {
        String query = "DELETE FROM ACTIVIDAD WHERE id = ?";
        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, idActividad);
            pstmt.executeUpdate();

            // Eliminar las inscripciones asociadas a la actividad
            String queryInscripcion = "DELETE FROM INSCRIPCION WHERE id_actividad = ?";
            try (PreparedStatement pstmtInscripcion = con.prepareStatement(queryInscripcion)) {
                pstmtInscripcion.setInt(1, idActividad);
                pstmtInscripcion.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la actividad");
            e.printStackTrace();
        }
    }

    /**
     * Actualiza una actividad en la base de datos
     * @param actividad
     */
    public void actualizarActividad(Actividad actividad) {
        String query = "UPDATE actividad SET id_monitor=?, id_sala=?, nombre=?, descripcion=?, nroMaximoInscritos=?, fecha=? WHERE id=?";

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
            pstmt.setInt(7, actividad.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar la actividad");
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una actividad por su id
     * @param idActividad
     * @return Actividad
     */
    public Actividad obtenerActividadPorId(Integer idActividad) {
        String query = "SELECT a.id, a.id_monitor, a.nombre, a.id_sala, a.descripcion, a.nroMaximoInscritos, a.fecha, s.codigoSala, s.capacidad, s.tipoSala FROM actividad a, sala s where a.id_sala = s.id and a.id = ?";
        Actividad actividad = new Actividad();

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, idActividad);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                actividad.setId(rs.getInt("id"));
                actividad.setIdMonitor(rs.getInt("id_monitor"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setIdSala(rs.getInt("id_sala"));
                actividad.setDescripcion(rs.getString("descripcion"));
                actividad.setNroMaximoInscritos(rs.getInt("nroMaximoInscritos"));
                actividad.setFecha(rs.getTimestamp("fecha"));

                // Crear y asociar la sala
                Sala sala = new Sala();
                sala.setId(rs.getInt("id_sala"));
                sala.setCodigoSala(rs.getString("codigoSala"));
                sala.setCapacidad(rs.getInt("capacidad"));
                sala.setTipoSala(rs.getString("tipoSala"));

                actividad.setSala(sala);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la actividad por id");
            e.printStackTrace();
        }
        return actividad;
    }

    /**
     * Obtiene el detalle de una actividad por su id, consultando a las tablas actividad, sala y usuario
     * @param idActividad
     * @return Actividad
     */
    public Actividad obtenerDetalleActividadPorId(Integer idActividad) {
        String query = "select a.id, a.id_monitor as idMonitor, a.nombre, a.descripcion, a.nroMaximoInscritos - (select count(*) from inscripcion i where i.id_actividad = a.id) as nroPlazasDisponibles, a.nroMaximoInscritos , s.tipoSala, u.nombreApellidos from ACTIVIDAD a, USUARIO u, SALA s where a.id_monitor = u.id and a.id_sala = s.id and a.id = ?";
        Actividad actividad = new Actividad();

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, idActividad);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                actividad.setId(rs.getInt("id"));
                actividad.setIdMonitor(rs.getInt("idMonitor"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setDescripcion(rs.getString("descripcion"));
                actividad.setNroMaximoInscritos(rs.getInt("nroMaximoInscritos"));
                actividad.setNroPlazasDisponibles(rs.getInt("nroPlazasDisponibles"));

                // Crear y asociar la sala
                Sala sala = new Sala();
                sala.setTipoSala(rs.getString("tipoSala"));

                actividad.setSala(sala);

                // Crear y asociar el monitor
                Usuario monitor = new Usuario();
                monitor.setNombreApellidos(rs.getString("nombreApellidos"));

                actividad.setMonitor(monitor);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener el detalle de la actividad por id");
            e.printStackTrace();
        }
        return actividad;
    }

    /**
     * Inscribe al usuario autenticado en una actividad
     * @param idActividad
     */
    public void inscribirseEnActividad(Integer idActividad) {
        String query = "INSERT INTO INSCRIPCION(id_usuario, id_actividad) VALUES(?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmtUsuario = con.prepareStatement(query);
        ) {

            pstmtUsuario.setInt(1, Constantes.usuarioAutenticado.getId());
            pstmtUsuario.setInt(2, idActividad);
            pstmtUsuario.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Comprueba si el usuario autenticado ya está inscrito en una actividad
     * @param id
     * @return true si ya está inscrito, false si no
     */
    public boolean usuarioYaInscritoEnActividad(Integer id) {
        String query = "SELECT * FROM INSCRIPCION WHERE id_usuario = ? AND id_actividad = ?";
        try (
            Connection con = DriverManager.getConnection(url, usuarioSQL, passwordSQL);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            pstmt.setInt(1, Constantes.usuarioAutenticado.getId());
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al comprobar si el usuario ya está inscrito en la actividad");
            e.printStackTrace();
        }
        return false;
    }
}

