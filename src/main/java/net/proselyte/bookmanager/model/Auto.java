package net.proselyte.bookmanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AUTOS")
public class Auto {
    //TODO create abstract class - Transport, with parametr weight

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AUTO_NAME")
    private String name;

    @Column(name = "AUTO_COLOR")
    private String color;

    @NotNull(message = "exception")
    @Column(name = "AUTO_POWER")
    private int power;

    @Column(name = "AUTO_WEIGHT")
    private int weight;

    @Column(name = "AUTO_PRICE")
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
