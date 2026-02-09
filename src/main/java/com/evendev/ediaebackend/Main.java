/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.evendev.ediaebackend;

import com.evendev.ediaebackend.daos.FilmografiaDao;
import com.evendev.ediaebackend.models.Filmografia;
import com.evendev.ediaebackend.utils.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        DBManager dbManager = new DBManager();
        Connection connection = dbManager.getConnection();
        FilmografiaDao filmografiaDao;

        filmografiaDao = new FilmografiaDao(connection);

        System.out.println("=================================");
        System.out.println("        FILMOGRAFIA              ");
        System.out.println("=================================");

        // Test of read one and read all
        System.out.println("--------------------------");
        System.out.println("        READ              ");
        System.out.println("--------------------------");

        try {
            System.out.println("Test of filmo.findAll");
            List<Filmografia> filmos = filmografiaDao.findAll();
            for (Filmografia filmo : filmos) {
                System.out.println(filmo);
            }

            System.out.println("\nTest of filmo.findById with id = 3");
            Optional<Filmografia> maybeFilmo = filmografiaDao.findById(3);
            if (maybeFilmo.isPresent()) {
                System.out.println(maybeFilmo.get());
            } else {
                System.out.println("No filmografia found with id: 3");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
            throw new RuntimeException("Database error while reading filmografia.", e);
        }

        // test of create
        System.out.println("--------------------------");
        System.out.println("        CREATE            ");
        System.out.println("--------------------------");

        System.out.println("The movie with id 6 doesn't exist :");
        try {
            System.out.println("\nTest of filmo.findById with id = 6");
                Optional<Filmografia> maybeFilmo = filmografiaDao.findById(6);
                if (maybeFilmo.isPresent()) {
                    System.out.println(maybeFilmo.get());
                } else {
                    System.out.println("No filmografia found with id: 3");
                }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
            throw new RuntimeException("Database error while reading filmografia.", e);
        }

        System.out.println("We'll add the next movie:");



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
                System.err.println("Error while closing the connection:");
                e.printStackTrace();
            }
        }
        scan.close();
        AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("Program finished.");
        */

    }
}
