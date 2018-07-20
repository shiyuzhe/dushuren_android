package com.hulai.dushuren.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/14.
 */

public class TeacherBean implements Serializable {

    /**
     * success : true
     * message : null
     * object : [{"audiourl":"http://video.dushuren123.com/teacher715182173.mp3","brief":"探寻大陆学术研究的边界","contenturl":"http://video.dushuren123.com/content.html","id":715182173,"name":"刘苏里","publishtime":1520997357738,"shareurl":"http://video.dushuren123.com/share.html","videourl":"http://video.dushuren123.com/teacher715182173.mp4"}]
     */
    /**
     * audiourl : http://video.dushuren123.com/teacher715182173.mp3
     * brief : 探寻大陆学术研究的边界
     * contenturl : http://video.dushuren123.com/content.html
     * id : 715182173
     * name : 刘苏里
     * publishtime : 1520997357738
     * shareurl : http://video.dushuren123.com/share.html
     * videourl : http://video.dushuren123.com/teacher715182173.mp4
     */

    private String audiourl;
    private String brief;
    private String contenturl;
    private int id;
    private String name;
    private long publishtime;
    private String shareurl;
    private String videourl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getAudiourl() {
        return audiourl;
    }

    public void setAudiourl(String audiourl) {
        this.audiourl = audiourl;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContenturl() {
        return contenturl;
    }

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

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

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherBean that = (TeacherBean) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "TeacherBean{" +
                "audiourl='" + audiourl + '\'' +
                ", brief='" + brief + '\'' +
                ", contenturl='" + contenturl + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", publishtime=" + publishtime +
                ", shareurl='" + shareurl + '\'' +
                ", videourl='" + videourl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
