package agenda.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agenda.exceptions.InvalidFormatException;

import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.RepositoryContact;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryContactMock();
	}
	//valid input
	@Test
	public void test1BlackBox() {

		try {
			con = new Contact("Regina Phalange", "New York", "0712343211");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		assertTrue(rep.getContacts().size() == 4);
		assertTrue(rep.getByName("Regina Phalange").getName().equals("Regina Phalange"));
	}


	//invalid phone number
	@Test
	public void test2BlackBox() {
		try {
			con = new Contact("Chandler", "New York", "0#$%");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertTrue(true);
			assertTrue(e.getMessage().contains("Invalid phone number"));
		}
		assertTrue(rep.getContacts().size() == 3);
	}

    //invalid name
    @Test
    public void test3BlackBox() {
        try {
            con = new Contact("", "New York", "0712343211");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Empty field"));
        }
        assertTrue(rep.getContacts().size() == 3);

    }

    //invalid address
    @Test
    public void test5BlackBox() {
        try {
            con = new Contact("Joey", "", "0712343211");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Empty field"));
        }
        assertTrue(rep.getContacts().size() == 3);
    }


    @Test
    public void test6BlackBox() {
        try {
            con = new Contact("Monica", "New York", "0#$%");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Invalid phone number"));
        }
        assertTrue(rep.getContacts().size() == 3);
    }

    //bva

    @Test
    public void test7BlackBox() {
        try {
            con = new Contact("R", "Paris", "078765456");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Invalid phone number"));
        }
        assertTrue(rep.getContacts().size() == 3);

    }

    @Test
    public void test8BlackBox() {
        try {
            con = new Contact("Rachel", "Paris", "07876545688");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Invalid phone number"));
        }
        assertTrue(rep.getContacts().size() == 3);
    }

    @Test
    public void test9BlackBox() {
        assertTrue(rep.getContacts().size() == 3);
        try {
            con = new Contact("asdf", "a", "134");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
        }
        assertTrue(rep.getContacts().size() == 3);

    }

    @Test
    public void test10BlackBox() {
        assertTrue(rep.getContacts().size() == 3);
        try {
            con = new Contact("w", "Paris", "0734ert543");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertTrue(true);
            assertTrue(e.getMessage().contains("Invalid phone number"));
        }
        assertTrue(rep.getContacts().size() == 3);

    }

}
