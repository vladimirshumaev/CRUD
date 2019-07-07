package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.AutoDao;
import net.proselyte.bookmanager.model.Auto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    AutoDao autoDao;

    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }

    @Override
    @Transactional
    public List<Auto> listAutos() {
        return this.autoDao.listAutos();
    }

    @Override
    @Transactional
    public void removeAuto(int id) {
        this.autoDao.removeAuto(id);
    }

    @Override
    @Transactional
    public void addAuto(Auto auto) {
        this.autoDao.addAuto(auto);
    }

    @Override
    @Transactional
    public void updateAuto(Auto auto) {
        this.autoDao.updateAuto(auto);
    }

    @Override
    @Transactional
    public Auto getAutoById(int id) {
        return this.autoDao.getAutoById(id);
    }

}
