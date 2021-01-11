package database.daoimpl;

import database.dao.IssLocationDao;
import database.dao.PeopleInSpaceDao;
import database.entity.PeopleInSpace;
import database.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PeopleInSpaceDaoImplTest {

    private PeopleInSpaceDao peopleInSpaceDao = new PeopleInSpaceDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM PEOPLE_IN_SPACE")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void save() {
        PeopleInSpace peopleInSpace = new PeopleInSpace();
        peopleInSpace.setDate(LocalDateTime.now());
        peopleInSpace.setName("Jan Kowalski");


        peopleInSpaceDao.save(peopleInSpace);

        PeopleInSpace saved = peopleInSpaceDao.findById(peopleInSpace.getId());

        assertNotNull(saved);
        assertEquals(peopleInSpace.getId(), saved.getId());
        assertEquals(peopleInSpace.getName(), saved.getName());

    }

    @Test
    void findById() {
        PeopleInSpace peopleInSpace = new PeopleInSpace();
        peopleInSpace.setDate(LocalDateTime.now());
        peopleInSpace.setName("Jan Kowalski");

        peopleInSpaceDao.findById(peopleInSpace.getId());
        PeopleInSpace findedByID = peopleInSpaceDao.findById(peopleInSpace.getId());

        assertNull(findedByID);

    }

    @Test
    void findAll() {
        PeopleInSpace peopleInSpace1 = new PeopleInSpace();
        peopleInSpace1.setDate(LocalDateTime.now());
        peopleInSpace1.setName("Jan Kowalski");

        PeopleInSpace peopleInSpace2 = new PeopleInSpace();
        peopleInSpace2.setDate(LocalDateTime.now());
        peopleInSpace2.setName("Andrzej Nowak");

        peopleInSpaceDao.save(peopleInSpace1);
        peopleInSpaceDao.save(peopleInSpace2);

        List<PeopleInSpace> list = peopleInSpaceDao.findAll();

        assertNotNull(list);
        assertEquals(2, list.size());

    }

    @Test
    void deleteById() {
        PeopleInSpace peopleInSpace = new PeopleInSpace();
        peopleInSpace.setDate(LocalDateTime.now());
        peopleInSpace.setName("Jan Kowalski");

        peopleInSpaceDao.save(peopleInSpace);

        peopleInSpaceDao.deleteById(peopleInSpace.getId());

        PeopleInSpace deletedByID = peopleInSpaceDao.findById(peopleInSpace.getId());

        assertNull(deletedByID);
    }
}
