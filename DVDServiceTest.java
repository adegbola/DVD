/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.service;

import DVD.dao.AuditDao;
import DVD.dao.DVDAuditDaoStubImpl;
import DVD.dao.DVDDao;
import DVD.dao.DVDDaoStubImpl;
import DVD.dto.DVD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kelsey
 */
public class DVDServiceTest {

    DVDService service;

    public DVDServiceTest() {
        AuditDao audit = new DVDAuditDaoStubImpl();
        DVDDao dao = new DVDDaoStubImpl();
        service = new DVDSericeFileImpl(dao, audit);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createDVD method, of class DVDService.
     */
    @Test
    public void testCreateDVD() throws Exception {
        DVD newDvd = new DVD("Troy");
        newDvd.setReleaseDate("2009");
        newDvd.setDirectorName("Jane");
        newDvd.setMpaaRating("A");
        newDvd.setStudio("Disney");
        newDvd.setUserRating("Awesome");
        service.createDVD(newDvd);

    }

    @Test
    public void testduplicateTitle() throws Exception {
        DVD newDvd1 = new DVD("Game");
        newDvd1.setReleaseDate("2007");
        newDvd1.setDirectorName("Jan");
        newDvd1.setMpaaRating("A");
        newDvd1.setStudio("Disney");
        newDvd1.setUserRating("Awesome");
        try {
            service.createDVD(newDvd1);
            fail("Exception not thrown");
        } catch (DVDServiceDuplicateIdException e) {
        }
    }

    @Test
    public void testdataValidation() throws Exception {
        DVD newDvd1 = new DVD("Thor");
        newDvd1.setMpaaRating("A");
        newDvd1.setReleaseDate("");
        newDvd1.setDirectorName("Jan");
        
        newDvd1.setStudio("Disney");
        newDvd1.setUserRating("Awesome");
        try {
            service.createDVD(newDvd1);
            fail("Exception not thrown");
        } catch (DVDServiceDataValidationException e) {
        }
    }
        /**
         * Test of getAllDvds method, of class DVDService.
         */
        @Test
        public void testGetAllDvds() throws Exception {
           assertEquals(1,service.getAllDvds().size());
        }

        /**
         * Test of getDVD method, of class DVDService.
         */
        @Test
        public void testGetDVD() throws Exception {
            DVD dvd=service.getDVD("Thor");
            assertNotNull(dvd);
            dvd=service.getDVD("June");
            assertNull(dvd);
        }

        /**
         * Test of removeVD method, of class DVDService.
         */
        @Test
        public void testRemoveVD() throws Exception {
            DVD dvd=service.removeVD("Thor");
            assertNotNull(dvd);
            dvd=service.removeVD("June");
            assertNull(dvd);
        }

        /**
         * Test of editDVD method, of class DVDService.
         */
        @Test
        public void testEditDVD() throws Exception {
        }

    }
