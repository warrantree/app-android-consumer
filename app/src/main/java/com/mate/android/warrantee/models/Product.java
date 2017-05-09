package com.mate.android.warrantee.models;

/**
 * Created by anujgupta on 28/04/17.
 */

public class Product {

    private String id;
    private String name;
    private String image;
    private String brand;
    private String serial_no;
    private String warranty;


    public Product(String id,String name, String image, String brand, String serial_no, String warranty) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.serial_no = serial_no;
        this.warranty = warranty;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}
