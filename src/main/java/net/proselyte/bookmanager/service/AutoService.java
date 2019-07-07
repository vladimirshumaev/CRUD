package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Auto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AutoService {
    public List<Auto> listAutos();

    public void removeAuto(int id);

    public void addAuto(Auto auto);

    public void updateAuto(Auto auto);

    public Auto getAutoById(int id);
}
