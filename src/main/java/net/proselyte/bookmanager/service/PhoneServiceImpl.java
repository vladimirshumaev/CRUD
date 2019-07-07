package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.PhoneDao;
import net.proselyte.bookmanager.model.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneDao phoneDao;

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    @Transactional
    public void addPhone(Phone phone) {
        this.phoneDao.addPhone(phone);
    }

    @Override
    @Transactional
    public void removePhone(int id) {
        this.phoneDao.removePhone(id);
    }

    @Override
    @Transactional
    public void updatePhone(Phone phone) {
        this.phoneDao.updatePhone(phone);
    }

    @Override
    @Transactional
    public Phone getPhoneById(int id) {
        return this.phoneDao.getPhoneById(id);
    }


    @Override
    @Transactional
    public List<Phone> listPhones() {
        return this.phoneDao.listPhones();
    }

}
