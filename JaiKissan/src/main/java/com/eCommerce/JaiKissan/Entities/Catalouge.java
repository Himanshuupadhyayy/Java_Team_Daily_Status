package com.eCommerce.JaiKissan.Entities;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;

@Entity
public class Catalouge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
     private String cName;
     private String discription;

     private String image;

     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "catalouge")
     private List<Crop> crop;

    public Catalouge() {
    }

    public Catalouge(int cId, String cName, String discription, String image, List<Crop> crop) {
        this.cId = cId;
        this.cName = cName;
        this.discription = discription;
        this.image = image;
        this.crop = crop;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Crop> getCrop() {
        return crop;
    }

    public void setCrop(List<Crop> crop) {
        this.crop = crop;
    }

    @Override
    public String toString() {
        return "Catalouge{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", discription='" + discription + '\'' +
                ", image='" + image + '\'' +
                ", crop=" + crop +
                '}';
    }
}
