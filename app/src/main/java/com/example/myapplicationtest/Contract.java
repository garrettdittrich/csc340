package com.example.myapplicationtest;

import java.util.Calendar;

public class Contract {
    public Calendar scheduleDate;
    public String scheduleTime;
    public Double paymentAmount;
    public Boolean activeStatus;
    public String gym;
    public String winner;
    public String loser;
    public String proposer;
    public String potentialPartner;

    public Contract(){

    }
    public Calendar getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Calendar scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getPotentialPartner() {
        return potentialPartner;
    }

    public void setPotentialPartner(String potentialPartner) {
        this.potentialPartner = potentialPartner;
    }
}
