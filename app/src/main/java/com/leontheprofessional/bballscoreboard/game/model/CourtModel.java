package com.leontheprofessional.bballscoreboard.game.model;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class CourtModel {
    public double courtLatitude;
    public double courtLongitude;
    public String courtName;
    public String courtAddress;

    public CourtModel(double courtLatitude, double courtLongitude, String courtName) {
        this.courtLatitude = courtLatitude;
        this.courtLongitude = courtLongitude;
        this.courtName = courtName;
    }

    public CourtModel(double courtLatitude, double courtLongitude, String courtName, String courtAddress) {
        this.courtLatitude = courtLatitude;
        this.courtLongitude = courtLongitude;
        this.courtName = courtName;
        this.courtAddress = courtAddress;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }

    public double getCourtLatitude() {
        return courtLatitude;
    }

    public void setCourtLatitude(double courtLatitude) {
        this.courtLatitude = courtLatitude;
    }

    public double getCourtLongitude() {
        return courtLongitude;
    }

    public void setCourtLongitude(double courtLongitude) {
        this.courtLongitude = courtLongitude;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }
}
