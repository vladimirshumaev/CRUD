package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Phone;

import java.util.List;

public interface PhoneService {
    public void addPhone(Phone phone);

    public void removePhone(int id);

    public void updatePhone(Phone phone);

    public Phone getPhoneById(int id);

    public List<Phone> listPhones();
}
