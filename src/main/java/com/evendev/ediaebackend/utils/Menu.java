/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.evendev.ediaebackend.utils;

import java.util.ArrayList;
import java.util.Scanner;	
/**
 *
 * @author sensei
 */
public class Menu {

	private Scanner scan;
	private ArrayList<String> entries;

	public Menu(ArrayList<String> entries, Scanner scan) {
		this.entries = entries;
		this.scan = scan;
	}

	public ArrayList<String> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<String> entries) {
		this.entries = entries;
	}
	
	public int askForChoice() {
		System.out.println("======================================");
		System.out.println("What do you want to do ?");
		System.out.println("======================================");
		int choice = -10;
		for (int i = 0; i < this.entries.size(); i++) {
			System.out.println(i + ". " + this.entries.get(i));
		}
		
		System.out.println("======================================");

		boolean validInput = false;
		while (!validInput) {
            System.out.println("Enter a number to choose");
            try {
                choice = Integer.parseInt(scan.nextLine());
                
                if (choice >= 0 && choice <= this.entries.size() - 1) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a value between 0 and " + (this.entries.size() - 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
            }
        }
		return choice;
	}
	


}
