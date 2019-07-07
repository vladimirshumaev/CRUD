package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Auto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoDaoImpl implements AutoDao {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AutoDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Auto> listAutos() {
        Session session = sessionFactory.getCurrentSession();
        List<Auto> autoList = session.createQuery("from Auto").list();

        autoList.forEach((auto) -> logger.info("Auto list : " + auto));

        return autoList;
    }

    @Override
    public void removeAuto(int id) {
        Session session = sessionFactory.getCurrentSession();
        Auto auto = (Auto) session.load(Auto.class, new Integer(id));

        if (auto != null) {
            session.delete(auto);
        }
        logger.info("auto deleted successfully : " + auto);
    }

    @Override
    public void addAuto(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(auto);

        logger.info("Auto successfuly added. details : " + auto);
    }

    @Override
    public void updateAuto(Auto auto) {
        Session session = sessionFactory.getCurrentSession();
        session.update(auto);

        logger.info("Auto successfully updated");
    }

    @Override
    public Auto getAutoById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Auto auto = (Auto) session.load(Auto.class, new Integer(id));
        logger.info("Auto successfully loaded. details : " + auto);

        return auto;
    }
}
