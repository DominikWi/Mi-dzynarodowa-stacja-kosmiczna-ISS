package database.daoimpl;

import database.dao.IssLocationDao;
import database.dao.PeopleInSpaceDao;
import database.entity.PeopleInSpace;
import database.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        peopleInSpace.setName("Jan");
        peopleInSpace.setSurname("Kowalski");

        peopleInSpaceDao.save(peopleInSpace);

        PeopleInSpace saved = peopleInSpaceDao.findById(peopleInSpace.getId());

        assertNotNull(saved);
        assertEquals(peopleInSpace.getId(), saved.getId());
        assertEquals(peopleInSpace.getName(), saved.getName());
        assertEquals(peopleInSpace.getSurname(), saved.getSurname());

    }
}
