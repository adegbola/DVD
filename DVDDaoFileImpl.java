/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Kelsey
 */
public class DVDDaoFileImpl implements DVDDao {

    private Map<String, DVD> dvds = new HashMap<>();
    LocalDate dt=LocalDate.now();
    String dtformat=dt.format(DateTimeFormatter.ofPattern("MM/dd/yyy"));
    public static final String Roster = "DVD.txt";
    public static final String Delimeter = "::";

    private void loadDVD() throws DVDDaoFilePersistenceException {
    Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(Roster)));
        } catch (FileNotFoundException e) {
            throw new DVDDaoFilePersistenceException("could not load file", e);
        }
        String currentLine;
        String[] currentToken;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentToken = currentLine.split(Delimeter);
            DVD dvd = new DVD(currentToken[0]);
            dvd.setMpaaRating(currentToken[1]);
            dvd.setReleaseDate(currentToken[2]);
            dvd.setDirectorName(currentToken[3]);
            dvd.setStudio(currentToken[4]);
            dvd.setUserRating(currentToken[5]);
            dvds.put(dvd.getTitle(), dvd);

        }
        scanner.close();
    }

    private void writeDVD() throws DVDDaoFilePersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(Roster));
        } catch (IOException e) {
            throw new DVDDaoFilePersistenceException("could not save data", e);
        }
        List<DVD> dvd = this.getAllDVDS();
        for (DVD dvdList : dvd) {
            out.println(dvdList.getTitle() + Delimeter
                    + dvdList.getMpaaRating() + Delimeter
                    + dvdList.getReleaseDate() + Delimeter
                    
                    + dvdList.getDirectorName() + Delimeter
                    + dvdList.getStudio() + Delimeter
                    + dvdList.getUserRating());
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDDaoFilePersistenceException {
        DVD newDvd = dvds.put(title, dvd);
        writeDVD();
        return newDvd;
    }

    @Override
    public List<DVD> getAllDVDS() throws DVDDaoFilePersistenceException{
        loadDVD();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoFilePersistenceException {
        loadDVD();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoFilePersistenceException {
        DVD removedDvd = dvds.remove(title);
        writeDVD();
        return removedDvd;
    }

    @Override
    public DVD editDVD(String title, DVD newDVD) throws DVDDaoFilePersistenceException {
        DVD newdvd = dvds.put(title, newDVD);
        writeDVD();
        return newdvd;
    }

}
