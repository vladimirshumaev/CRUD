package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Phone;

import java.util.List;

public interface PhoneDao {
    public void addPhone(Phone phone);

    public void removePhone(int id);

    public void updatePhone(Phone phone);

    public Phone getPhoneById (int id);

    public List<Phone> listPhones();
}
