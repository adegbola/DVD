/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kelsey
 */
public class DVDDaoTest {
    DVDDao dao=new DVDDaoFileImpl();
    public DVDDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        List<DVD>dvdList=dao.getAllDVDS();
        for(DVD dvd: dvdList){
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDDao.
     */
    @Test
    public void testAddGetDVD() throws Exception {
        DVD dvd=new DVD("Thor");
        dvd.setReleaseDate("2008");
        dvd.setMpaaRating("R");
        dvd.setDirectorName("John");
        dvd.setStudio("Marvel");
        dvd.setUserRating("Good");
        dao.addDVD(dvd.getTitle(), dvd);
        
        DVD fromdao=dao.getDVD(dvd.getTitle());
        assertEquals(dvd,fromdao);
    }

    /**
     * Test of getAllDVDS method, of class DVDDao.
     */
    @Test
    public void testGetAllDVDS() throws Exception {
          DVD dvd1=new DVD("Thor");
        dvd1.setReleaseDate("2008");
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("John");
        dvd1.setStudio("Marvel");
        dvd1.setUserRating("Good");
        dao.addDVD(dvd1.getTitle(), dvd1);
        
          DVD dvd2=new DVD("Iron Man");
        dvd2.setReleaseDate("2001");
        dvd2.setMpaaRating("C");
        dvd2.setDirectorName("Joh");
        dvd2.setStudio("Marvel");
        dvd2.setUserRating("Good");
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        assertEquals(2,dao.getAllDVDS().size());
    }


    /**
     * Test of removeDVD method, of class DVDDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
          DVD dvd1=new DVD("Thor");
        dvd1.setReleaseDate("2008");
        dvd1.setMpaaRating("R");
        dvd1.setDirectorName("John");
        dvd1.setStudio("Marvel");
        dvd1.setUserRating("Good");
        dao.addDVD(dvd1.getTitle(), dvd1);
        
          DVD dvd2=new DVD("Iron Man");
        dvd2.setReleaseDate("2001");
        dvd2.setMpaaRating("C");
        dvd2.setDirectorName("Joh");
        dvd2.setStudio("Marvel");
        dvd2.setUserRating("Good");
        dao.addDVD(dvd2.getTitle(), dvd2);
        
        dao.removeDVD(dvd1.getTitle());
        
        assertEquals(1,dao.getAllDVDS().size());
        assertNull(dao.getDVD(dvd1.getTitle()));
        
        dao.removeDVD(dvd2.getTitle());
        
        assertEquals(0,dao.getAllDVDS().size());
        assertNull(dao.getDVD(dvd2.getTitle()));
    }

    /**
     * Test of editDVD method, of class DVDDao.
     */
    @Test
    public void testEditDVD() throws Exception {
    }

   
    
}
