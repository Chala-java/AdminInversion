package Inversiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conector {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/desarrollo/Desktop/sqjj.db"; // Ruta de tu base de datos

        try (Connection conn = DriverManager.getConnection(url)) {
            // Configurar el tiempo de espera para el bloqueo
            Statement stmt = conn.createStatement();
            stmt.execute("PRAGMA busy_timeout = 3000;");  // Tiempo de espera de 3 segundos si la base de datos está bloqueada

            // Crear tabla 'usuario' (base para admin y cliente)
            String sqlUsuario = "CREATE TABLE IF NOT EXISTS usuario (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL," +
                    "password TEXT NOT NULL," +
                    "tipo TEXT NOT NULL);";
            stmt.execute(sqlUsuario);

            // Crear tabla 'inversion' (tabla para las inversiones de los clientes)
            String sqlInversion = "CREATE TABLE IF NOT EXISTS inversion (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "cliente_id INTEGER," +
                    "monto REAL NOT NULL," +
                    "tipo_inversion TEXT NOT NULL," +
                    "fecha_inversion TEXT NOT NULL," +
                    "FOREIGN KEY (cliente_id) REFERENCES usuario(id));";
            stmt.execute(sqlInversion);

            System.out.println("Tablas creadas con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }
    }}