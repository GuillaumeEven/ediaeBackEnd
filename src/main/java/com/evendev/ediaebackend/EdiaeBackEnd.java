/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.evendev.ediaebackend;

import com.evendev.ediaebackend.utils.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author sensei
 */
public class EdiaeBackEnd {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Create a menu to select one of the different exercices
        ArrayList<String> mainEntries = new ArrayList<String>();
        mainEntries.add("Explore the miscellaneous exercises completed");
        mainEntries.add("Experiment with the Munchkin application");
        mainEntries.add("Experiment with the Monopoly application");
        mainEntries.add("Quit this program");
        Menu mainMenu = new Menu(mainEntries, scan);
        int mainChoice = mainMenu.askForChoice();

        while (mainChoice != mainEntries.size()-1) {
                switch(mainChoice) {
                case 0:
                        net.evendev.ediae.exercices.Main.main(args, scan);
                        break;
                case 1:
                        net.evendev.ediae.munchkin.Main.main(args, scan);
                        break;
                case 2:
                        // TODO fix monopoly app
                        net.evendev.ediae.monopoly.Monopoly.main(args, scan);
                        break;
                case 3:
                        // TODO This call doesn't work
                        System.out.println("Ciao");
                        net.evendev.ediae.exercices.WordOccurenciesCounter.main(args, scan);
                        break;
                default:
                }
                mainChoice = mainMenu.askForChoice();

        
        
        
        System.out.println("Lectura de datos de la base netflix...");

        DBManager dbManager = new DBManager();
        Connection connection = dbManager.getConnection();

        if (connection != null) {
            System.out.println("¡Conexión exitosa!\n");

            // Leer los datos
            lireDonnees(connection);

            // Cerrar la conexión
            try {
                connection.close();
                System.out.println("\nConexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Fallo en la conexión.");
        }
    }

    public static void lireDonnees(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            // Ejemplo: mostrar todas las tablas de la base netflix únicamente
            ResultSet tables = conn.getMetaData().getTables("netflix", null, "%", new String[]{"TABLE"});
            System.out.println("Tablas disponibles en la base netflix:");
            while (tables.next()) {
                System.out.println("  - " + tables.getString("TABLE_NAME"));
            }
            tables.close();

            // Ejemplo de consulta en una tabla (modifique según sus tablas)
            System.out.println("\nEjemplo de lectura de datos:");
            String query = "SELECT * FROM filmografia";
            try {
                ResultSet rs = stmt.executeQuery(query);
                int columnCount = rs.getMetaData().getColumnCount();

                // Mostrar los nombres de las columnas
                System.out.print("[");
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getMetaData().getColumnName(i));
                    if (i < columnCount) System.out.print(" | ");
                }
                System.out.println("]");

                // Mostrar los datos
                while (rs.next()) {
                    System.out.print("[");
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i));
                        if (i < columnCount) System.out.print(" | ");
                    }
                    System.out.println("]");
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }


            // Ejemplo de inserción (INSERT)
            String insertSql = "INSERT INTO filmografia (id, fecha_estreno, sinopsis, titulo, tipo, pais, clasificacion) "
                + "VALUES (5, '2024-03-24', 'Una peli extraordiaria !', 'Un titulo genial', 'Western', 'USA', 'PG-13')";
            int rowsInserted = stmt.executeUpdate(insertSql);
            System.out.println("Filas insertadas: " + rowsInserted);

            // Ejemplo de actualización (UPDATE)
            String updateSql = "UPDATE filmografia SET titulo = 'una peli chulisima' WHERE id = 5";
            int rowsUpdated = stmt.executeUpdate(updateSql);
            System.out.println("Filas modificadas: " + rowsUpdated);

            // Ejemplo de eliminación (DELETE)
            String deleteSql = "DELETE FROM filmografia WHERE id = 5";
            int rowsDeleted = stmt.executeUpdate(deleteSql);
            System.out.println("Filas eliminadas: " + rowsDeleted);

            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error al leer los datos:");
            e.printStackTrace();
        }
    }
}
