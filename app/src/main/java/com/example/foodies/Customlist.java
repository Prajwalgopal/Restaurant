package com.example.foodies;

import java.io.Serializable;

public class Customlist implements Serializable {    // This is my model class

    String name;
    String Location;
    String Ratings;
    String intro;
    String address;
    String tele;
    String email;
    String desc;
    String url;
    String id;
    String image1;
    String image2;
    String image3;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public Customlist( String name, String location, String ratings, String intro, String address, String tele, String email, String desc, String url, String id, String image1, String image2, String image3) {
        this.name = name;
        this.Location = location;
        this.Ratings = ratings;
        this.intro = intro;
        this.address = address;
        this.tele = tele;
        this.email = email;
        this.desc=desc;
        this.url=url;
        this.id=id;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRatings() {
        return Ratings;
    }

    public void setRatings(String ratings) {
        Ratings = ratings;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
