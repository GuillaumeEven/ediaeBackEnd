/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.evendev.ediaebackend;

import com.evendev.ediaebackend.utils.DBManager;
import com.evendev.ediaebackend.daos.FilmografiaDao;
import com.evendev.ediaebackend.utils.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
/**
 *
 * @author sensei
 */
public class Main {

    public static void main(String[] args) {

        DBManager dbManager = new DBManager();
        Connection connection = dbManager.getConnection();
        FilmografiaDao filmografiaDao = null;

        try {
            filmografiaDao = new FilmografiaDao(connection);
            System.out.println("Test de filmo.listall");
            filmografiaDao.listAllFilmografia();
            System.out.println("\nTest de filmo.listOne avec id = 3");
            filmografiaDao.listOne(3);
        } catch (SQLException e) {
            System.err.println("Something went wrong while reading the filmografia:");
            e.printStackTrace();
        }
        DBManager.disconnect(connection);
        AbandonedConnectionCleanupThread.checkedShutdown();


        /*
        System.out.println("Hello ! What do you want to do ?");

        Scanner scan = new Scanner(System.in);

        // instantiate a DBManager to get a connection
        DBManager dbManager = new DBManager();
        Connection connection = dbManager.getConnection();

        // Create a menu to select one of the different possibilities
        ArrayList<String> mainEntries = new ArrayList<String>();
        mainEntries.add("Read the filmografia table");
//        mainEntries.add("Experiment with the Munchkin application");
//        mainEntries.add("Experiment with the Monopoly application");
        mainEntries.add("Quit this program");
        Menu mainMenu = new Menu(mainEntries, scan);
        int mainChoice = mainMenu.askForChoice();

        while (mainChoice != mainEntries.size()-1) {
            switch(mainChoice) {
            case 0:
                dbManager.getTableColumns("filmografia");
                break;
            case 1:
                System.out.println("Exiting...");
                break;
            default:
            }
            mainChoice = mainMenu.askForChoice();
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion:");
                e.printStackTrace();
            }
        }
        scan.close();
        AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("Program finished.");
        */

    }
//
//    public static void readDatas(Connection conn) {
//        try {
//            Statement stmt = conn.createStatement();
//
//            // Ejemplo: mostrar todas las tablas de la base actual
//            String catalog = conn.getCatalog();
//            ResultSet tables = conn.getMetaData().getTables(catalog, null, "%", new String[]{"TABLE"});
//            System.out.println("Tablas disponibles en la base " + (catalog != null ? catalog : "(catalogue inconnu)") + ":");
//            while (tables.next()) {
//                System.out.println("  - " + tables.getString("TABLE_NAME"));
//            }
//            tables.close();
//
//            // Ejemplo de consulta en una tabla (modifique según sus tablas)
//            System.out.println("\nEjemplo de lectura de datos:");
//            String query = "SELECT * FROM filmografia";
//            try {
//                ResultSet rs = stmt.executeQuery(query);
//                int columnCount = rs.getMetaData().getColumnCount();
//
//                // Mostrar los nombres de las columnas
//                System.out.print("[");
//                for (int i = 1; i <= columnCount; i++) {
//                    System.out.print(rs.getMetaData().getColumnName(i));
//                    if (i < columnCount) System.out.print(" | ");
//                }
//                System.out.println("]");
//
//                // Mostrar los datos
//                while (rs.next()) {
//                    System.out.print("[");
//                    for (int i = 1; i <= columnCount; i++) {
//                        System.out.print(rs.getString(i));
//                        if (i < columnCount) System.out.print(" | ");
//                    }
//                    System.out.println("]");
//                }
//                rs.close();
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//
//
//            // Ejemplo de inserción (INSERT)
//            String insertSql = "INSERT INTO filmografia (id, fecha_estreno, sinopsis, titulo, tipo, pais, clasificacion) "
//                + "VALUES (5, '2024-03-24', 'Una peli extraordiaria !', 'Un titulo genial', 'Western', 'USA', 'PG-13')";
//            int rowsInserted = stmt.executeUpdate(insertSql);
//            System.out.println("Filas insertadas: " + rowsInserted);
//
//            // Ejemplo de actualización (UPDATE)
//            String updateSql = "UPDATE filmografia SET titulo = 'una peli chulisima' WHERE id = 5";
//            int rowsUpdated = stmt.executeUpdate(updateSql);
//            System.out.println("Filas modificadas: " + rowsUpdated);
//
//            // Ejemplo de eliminación (DELETE)
//            String deleteSql = "DELETE FROM filmografia WHERE id = 5";
//            int rowsDeleted = stmt.executeUpdate(deleteSql);
//            System.out.println("Filas eliminadas: " + rowsDeleted);
//
//            stmt.close();
//
//        } catch (SQLException e) {
//            System.err.println("Error al leer los datos:");
//            e.printStackTrace();
//        }
//    }
}
