package com.future.test;

import java.util.Date;

/**
 * @author guorui
 * @create 2022-06-16-17:19
 */
public class RqInfo {
    private Date rq;
    private String week;
    private int dayYearSeq;

    public RqInfo() {
    }

    public RqInfo(Date rq, String week, int dayYearSeq) {
        this.rq = rq;
        this.week = week;
        this.dayYearSeq = dayYearSeq;
    }

    public Date getRq() {
        return rq;
    }

    public void setRq(Date rq) {
        this.rq = rq;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getDayYearSeq() {
        return dayYearSeq;
    }

    public void setDayYearSeq(int dayYearSeq) {
        this.dayYearSeq = dayYearSeq;
    }
}
