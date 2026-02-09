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
                    System.out.println("No filmografia found with id: 6");
                }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
            throw new RuntimeException("Database error while reading filmografia.", e);
        }

        System.out.println("We'll add the next movie:");
        Filmografia newFilmo = new Filmografia(
            "The Matrix",
            java.sql.Date.valueOf("1999-03-31"),
            "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            4,
            1
        );

        try {
            filmografiaDao.insert(newFilmo);
            System.out.println("Movie inserted successfully!");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while inserting the filmografia.", e);
            throw new RuntimeException("Database error while inserting filmografia.", e);
        }

        System.out.println("And now we can see it exists:");
        try {
            System.out.println("Test of filmo.findAll");
            List<Filmografia> filmos = filmografiaDao.findAll();
            for (Filmografia filmo : filmos) {
                System.out.println(filmo);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
            throw new RuntimeException("Database error while reading filmografia.", e);
        }


        System.out.println("--------------------------");
        System.out.println("        UPDATE            ");
        System.out.println("--------------------------");

        System.out.println("Now we'll update the movie we've just created");

        newFilmo.settitulo("The Matrix Reloaded");
        System.out.println(newFilmo.toString());
        try {
            filmografiaDao.update(newFilmo);
            System.out.println("Movie updated successfully!");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while updating the filmografia.", e);
            throw new RuntimeException("Database error while updating filmografia.", e);
        }


        System.out.println("--------------------------");
        System.out.println("        DELETE            ");
        System.out.println("--------------------------");

        System.out.println("So much movies created, let's delete all of those with id >= 6 ");
        try {
            List<Filmografia> filmos = filmografiaDao.findAll();
            for (Filmografia filmo : filmos) {
                if (filmo.getid() >= 6) {
                    filmografiaDao.delete(filmo.getid());
                    System.out.println("Deleted movie with id: " + filmo.getid());
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while deleting the filmografia.", e);
            throw new RuntimeException("Database error while deleting filmografia.", e);
        }

        System.out.println("And now we can see the movie has been deleted:");
        try {
            System.out.println("Test of filmo.findAll");
            List<Filmografia> filmos = filmografiaDao.findAll();
            for (Filmografia filmo : filmos) {
                System.out.println(filmo);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
            throw new RuntimeException("Database error while reading filmografia.", e);
        }

        DBManager.disconnect(connection);
        AbandonedConnectionCleanupThread.checkedShutdown();
        // System.out.println("And now we can see the title has been updated:");
        // try {
        //     System.out.println("Test of filmo.findAll");
        //     List<Filmografia> filmos = filmografiaDao.findAll();
        //     for (Filmografia filmo : filmos) {
        //         System.out.println(filmo);
        //     }
        // } catch (SQLException e) {
        //     LOGGER.log(Level.SEVERE, "Something went wrong while reading the filmografia.", e);
        //     throw new RuntimeException("Database error while reading filmografia.", e);
        // }




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
