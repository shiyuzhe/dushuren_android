package com.hulai.dushuren.mvp.model.bean;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ReaderBean {

    /**
     * brief :
     * favorite :
     * favoritedreadersum : 0
     * id : 1455146447
     * isexpert : false
     * location : null
     * name :
     * password : 123456
     * phonenumber : 18091661234
     * postaladdress : null
     * registertime : 1520941106570
     * remainingsum : 0
     */

    private String brief;
    private String favorite;
    private int favoritedreadersum;
    private int id;
    private boolean isexpert;
    private Object location;
    private String name;
    private String password;



    private String phonenumber;
    private Object postaladdress;
    private long registertime;
    private int remainingsum;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getFavoritedreadersum() {
        return favoritedreadersum;
    }

    public void setFavoritedreadersum(int favoritedreadersum) {
        this.favoritedreadersum = favoritedreadersum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsexpert() {
        return isexpert;
    }

    public void setIsexpert(boolean isexpert) {
        this.isexpert = isexpert;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Object getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(Object postaladdress) {
        this.postaladdress = postaladdress;
    }

    public long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(long registertime) {
        this.registertime = registertime;
    }

    public int getRemainingsum() {
        return remainingsum;
    }

    public void setRemainingsum(int remainingsum) {
        this.remainingsum = remainingsum;
    }
    @Override
    public String toString() {
        return "ReaderBean{" +
                "brief='" + brief + '\'' +
                ", favorite='" + favorite + '\'' +
                ", favoritedreadersum=" + favoritedreadersum +
                ", id=" + id +
                ", isexpert=" + isexpert +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", postaladdress=" + postaladdress +
                ", registertime=" + registertime +
                ", remainingsum=" + remainingsum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderBean that = (ReaderBean) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
