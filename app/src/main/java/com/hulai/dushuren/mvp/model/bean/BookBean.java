package com.hulai.dushuren.mvp.model.bean;

/**
 * Created by Administrator on 2018/3/12.
 */

public class BookBean {
    /**
     * authors : 张翼成、吕琳媛、周涛
     * booklabels :
     * brief :
     * buyurl : null
     * canbuy : false
     * favoritepages :
     * favoritesum : 0
     * gooddegree : 0
     * id : 237475019
     * isreading : false
     * publisher : 四川人民出版社
     * publishtime : 1512121608247
     * readersum : 1
     * reviewsum : 0
     * subcategoryid : -1082177309
     * subcategoryname : 未分类
     * title : 《重塑：信息经济的结构》
     * topcategoryid : 192934762
     * topcategoryname : 专题
     * version : 第1版
     */

    private String authors;
    private String booklabels;
    private String brief;
    private String buyurl;
    private boolean canbuy;
    private String favoritepages;
    private int favoritesum;
    private int gooddegree;
    private int id;
    private boolean isreading;
    private String publisher;
    private long publishtime;
    private int readersum;
    private int reviewsum;
    private int subcategoryid;
    private String subcategoryname;
    private String title;
    private int topcategoryid;
    private String topcategoryname;
    private String version;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getBooklabels() {
        return booklabels;
    }

    public void setBooklabels(String booklabels) {
        this.booklabels = booklabels;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Object getBuyurl() {
        return buyurl;
    }

    public void setBuyurl(String buyurl) {
        this.buyurl = buyurl;
    }

    public boolean isCanbuy() {
        return canbuy;
    }

    public void setCanbuy(boolean canbuy) {
        this.canbuy = canbuy;
    }

    public String getFavoritepages() {
        return favoritepages;
    }

    public void setFavoritepages(String favoritepages) {
        this.favoritepages = favoritepages;
    }

    public int getFavoritesum() {
        return favoritesum;
    }

    public void setFavoritesum(int favoritesum) {
        this.favoritesum = favoritesum;
    }

    public int getGooddegree() {
        return gooddegree;
    }

    public void setGooddegree(int gooddegree) {
        this.gooddegree = gooddegree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsreading() {
        return isreading;
    }

    public void setIsreading(boolean isreading) {
        this.isreading = isreading;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public int getReadersum() {
        return readersum;
    }

    public void setReadersum(int readersum) {
        this.readersum = readersum;
    }

    public int getReviewsum() {
        return reviewsum;
    }

    public void setReviewsum(int reviewsum) {
        this.reviewsum = reviewsum;
    }

    public int getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(int subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTopcategoryid() {
        return topcategoryid;
    }

    public void setTopcategoryid(int topcategoryid) {
        this.topcategoryid = topcategoryid;
    }

    public String getTopcategoryname() {
        return topcategoryname;
    }

    public void setTopcategoryname(String topcategoryname) {
        this.topcategoryname = topcategoryname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookBean bookBean = (BookBean) o;

        return id == bookBean.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "authors='" + authors + '\'' +
                ", booklabels='" + booklabels + '\'' +
                ", brief='" + brief + '\'' +
                ", buyurl='" + buyurl + '\'' +
                ", canbuy=" + canbuy +
                ", favoritepages='" + favoritepages + '\'' +
                ", favoritesum=" + favoritesum +
                ", gooddegree=" + gooddegree +
                ", id=" + id +
                ", isreading=" + isreading +
                ", publisher='" + publisher + '\'' +
                ", publishtime=" + publishtime +
                ", readersum=" + readersum +
                ", reviewsum=" + reviewsum +
                ", subcategoryid=" + subcategoryid +
                ", subcategoryname='" + subcategoryname + '\'' +
                ", title='" + title + '\'' +
                ", topcategoryid=" + topcategoryid +
                ", topcategoryname='" + topcategoryname + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

