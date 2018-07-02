package com.barclay.theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main controller
 *
 * @author zdz
 * @create 2018-07-02-15:08
 */

public class Controller {

    public static void main(String[] args) {
        int totalNumOfSeats = 0;

        System.out.println("Enter number of rows for a theatre layout:");
        Scanner scanner = new Scanner(System.in);
        List<Row> rows = new ArrayList<>();
        List<Section> sections;
        int numOfRows = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of seats in each section seperated by space for each row: ");
        for (int i = 0; i < numOfRows; i++) {
            sections = new ArrayList<>();
            Row row = new Row();
            row.setRowId(i + 1);
            String line = scanner.nextLine();
            String[] arrayOfSeatCounts = line.split(" ");
            for (int j = 0; j < arrayOfSeatCounts.length; j++) {
                Section section = new Section();
                section.setSectionId(j + 1);
                section.setNumOfSeats(Integer.parseInt(arrayOfSeatCounts[j]));
                totalNumOfSeats = totalNumOfSeats + Integer.parseInt(arrayOfSeatCounts[j]);
                sections.add(section);

            }

            row.setSections(sections);
            rows.add(row);

        }

        System.out.println("Please enter ticket requests:" + "\n" + "Please type \"end\" when done.");

        List<Party> patrons = new ArrayList<>();
        while (true) {
            String line1 = scanner.nextLine();
            if (line1.equals("end")) {
                break;
            }
            String[] char1 = line1.split(" ");

            Party Party = new Party();
            Party.setCustomerName(char1[0]);
            Party.setRequestedSeats(Integer.parseInt(char1[1]));
            patrons.add(Party);
        }
        scanner.close();

        System.out.println("\nOutput:");
        for (Party Party : patrons) {
            int count = 0;
            for (Row row : rows) {
                count++;

                for (Section section : row.getSections()) {
                    int seats = section.getNumOfSeats();

                    if (Party.getRequestedSeats() > 0 && seats == Party.getRequestedSeats() && count <= 2) {

                        System.out.println("\n" + Party.getCustomerName() + " Row " + row.getRowId() + " Section "
                                + section.getSectionId());
                        section.setNumOfSeats(section.getNumOfSeats() - Party.getRequestedSeats());
                        totalNumOfSeats = totalNumOfSeats - Party.getRequestedSeats();
                        Party.setRequestedSeats(0);
                    }

                }
            }
            for (Row row : rows) {
                for (Section section : row.getSections()) {
                    int seats = section.getNumOfSeats();
                    if (Party.getRequestedSeats() > 0 && seats >= Party.getRequestedSeats()) {
                        System.out.println(Party.getCustomerName() + " Row " + row.getRowId() + " Section "
                                + section.getSectionId());
                        section.setNumOfSeats(section.getNumOfSeats() - Party.getRequestedSeats());
                        totalNumOfSeats = totalNumOfSeats - Party.getRequestedSeats();
                        Party.setRequestedSeats(0);
                    }

                }
            }
            if (Party.getRequestedSeats() > 0 && totalNumOfSeats >= Party.getRequestedSeats()) {
                System.out.println(Party.getCustomerName() + " Call to split party.");
            } else if (Party.getRequestedSeats() > 0 && totalNumOfSeats < Party.getRequestedSeats()) {
                System.out.println(Party.getCustomerName() + " Sorry, we can't handle your party.");
            }

        }

    }
}
