package com.hulai.dushuren.mvp.model.bean;

/**
 * Created by Administrator on 2018/3/15.
 */

public class ReadMeBean {
    /**
     * success : true
     * message : null
     * object : {"audiourl":"http://video.dushuren123.com/lecture384229084.mp3","brief":"            刘苏里的自我介绍            ","contenturl":"http://dushuren123.com/bookmov/video/content32.html","id":1358177437,"publishtime":1521008645809,"shareurl":"","teacherid":715182173,"teachername":"刘苏里","title":"总述","videourl":"http://video.dushuren123.com/lecture384229084.mp4"}
     */


    /**
     * audiourl : http://video.dushuren123.com/lecture384229084.mp3
     * brief :             刘苏里的自我介绍
     * contenturl : http://dushuren123.com/bookmov/video/content32.html
     * id : 1358177437
     * publishtime : 1521008645809
     * shareurl :
     * teacherid : 715182173
     * teachername : 刘苏里
     * title : 总述
     * videourl : http://video.dushuren123.com/lecture384229084.mp4
     */

    private String audiourl;
    private String brief;
    private String contenturl;
    private int id;
    private long publishtime;
    private String shareurl;
    private int teacherid;
    private String teachername;
    private String title;
    private String videourl;

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

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        if (!(o instanceof ReadMeBean)) return false;
        ReadMeBean that = (ReadMeBean) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
