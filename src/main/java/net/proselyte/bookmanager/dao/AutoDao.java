package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Auto;

import java.util.List;

public interface AutoDao {
    public List<Auto> listAutos();

    public void removeAuto(int id);

    public void addAuto(Auto auto);

    public void updateAuto(Auto auto);

    public Auto getAutoById(int id);
}
