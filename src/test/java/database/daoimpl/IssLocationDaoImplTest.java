package database.daoimpl;

import database.dao.IssLocationDao;
import database.entity.IssLocation;
import database.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IssLocationDaoImplTest {

    private IssLocationDao issLocationDao = new IssLocationDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM ISS_LOCATION")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test

        void save() {
        IssLocation issLocation = new IssLocation();
        issLocation.setDate(LocalDateTime.now());
        issLocation.setLongitude(6.15);
        issLocation.setLatitude(10.10);

        issLocationDao.save(issLocation);

        IssLocation saved = issLocationDao.findById(issLocation.getId());

        assertNotNull(saved);
        assertEquals(issLocation.getId(), saved.getId());
        assertEquals(issLocation.getLatitude(), saved.getLatitude());
        assertEquals(issLocation.getLongitude(), saved.getLongitude());

    }


}
