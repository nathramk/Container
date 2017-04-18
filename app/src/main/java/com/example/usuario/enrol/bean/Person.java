package com.example.usuario.enrol.bean;

/**
 * Created by Usuario on 16/04/2017.
 */

public class Person {

    private int id;
    private String name;
    private String lastNameF;
    private String lastNameM;
    private String address;
    private String sex;

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

    public String getLastNameF() {
        return lastNameF;
    }

    public void setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person(int id, String name, String lastNameF, String lastNameM, String address, String sex) {
        this.id = id;
        this.name = name;
        this.lastNameF = lastNameF;
        this.lastNameM = lastNameM;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return  name + " " + lastNameF + " " + lastNameM;
    }
}
