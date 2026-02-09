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
}
