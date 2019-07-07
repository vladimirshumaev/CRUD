package net.proselyte.bookmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "PHONES")
public class Phone {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME_MODEL")
    private String nameModel;

    @Column(name = "PRICE")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", nameModel='" + nameModel + '\'' +
                ", price=" + price +
                '}';
    }
}
