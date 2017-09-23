/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public class DVDDaoStubImpl implements DVDDao{
    
    DVD onlyDvd;
    List<DVD>dvdList=new ArrayList<>();
    
    public DVDDaoStubImpl(){
        onlyDvd=new DVD("Game");
        onlyDvd.setMpaaRating("R");
        onlyDvd.setReleaseDate("2008");
     
        onlyDvd.setDirectorName("Kelsey");
        onlyDvd.setStudio("Marvel");
        onlyDvd.setUserRating("Good");
        dvdList.add(onlyDvd);
    
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDDaoFilePersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }

    }

    @Override
    public List<DVD> getAllDVDS() throws DVDDaoFilePersistenceException {
        return dvdList;
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoFilePersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }

    @Override
    public DVD removeDVD(String title) throws DVDDaoFilePersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }

    @Override
    public DVD editDVD(String title, DVD newDVD) throws DVDDaoFilePersistenceException {
        if(title.equals(onlyDvd.getTitle())){
            return onlyDvd;
        }else{
            return null;
        }
    }
    
}
