package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneDaoImpl implements PhoneDao {
    private static final Logger logger = LoggerFactory.getLogger(PhoneDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(phone);
        logger.info("Phone succesfully added. Details : " + phone);
    }

    @Override
    public void removePhone(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone = (Phone) session.load(Phone.class, new Integer(id));

        if (phone != null) {
            session.delete(phone);
        }
        logger.info("Phone deleted. Details : " + phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(phone);

        logger.info("Phone updated. Details phone : " + phone);
    }

    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone = (Phone)session.load(Phone.class, new Integer(id));
        logger.info("Phone succesfully loaded. Details : " + phone);

        return phone;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Phone> listPhones() {
        Session session = sessionFactory.getCurrentSession();
        List<Phone> phonesList = session.createQuery("from Phone").list();

        for (Phone phone : phonesList) {
            logger.info("Phone list : " + phone);
        }

        return phonesList;
    }
}
