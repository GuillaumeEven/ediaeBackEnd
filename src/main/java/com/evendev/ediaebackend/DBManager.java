/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evendev.ediaebackend;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author sensei
 */
public class DBManager {
    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();
    private static final String USERNAME = DOTENV.get("DB_USERNAME", "root");
    private static final String PASSWORD = DOTENV.get("DB_PASSWORD", "");
    private static final String URL = DOTENV.get("DB_URL", "jdbc:mysql://localhost:3306/netflix");

    public Connection getConnection() {
        return connect();
    }

    public static Connection connect() {

        try {
            // Créer la connexion à la base de données
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connecté à la base de données avec succès!");

            return conn;

        } catch (SQLException e) {
            System.err.println("Erreur lors de la connection à la base de données!");
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connexion fermée avec succès.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion.");
                e.printStackTrace();
            }
        }
    }

}
