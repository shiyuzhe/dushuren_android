package com.hulai.dushuren.mvp.model.bean;

/**
 * 作者:shiyuzhe on 2018/7/20 17:31
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class LectureBean {
    private String lectureid;
    private String lecturebrief;

    public LectureBean(String lectureid, String lecturebrief) {
        this.lectureid = lectureid;
        this.lecturebrief = lecturebrief;
    }

    public String getLectureid() {
        return lectureid == null ? "" : lectureid;
    }

    public void setLectureid(String lectureid) {
        this.lectureid = lectureid;
    }

    public String getLecturebrief() {
        return lecturebrief == null ? "" : lecturebrief;
    }

    public void setLecturebrief(String lecturebrief) {
        this.lecturebrief = lecturebrief;
    }
}

