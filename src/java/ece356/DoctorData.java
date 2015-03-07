/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ece356;
import java.util.*;
/**
 *
 * @author behrozsaadat
 */
public class DoctorData extends UserData{
    String gender;
    ArrayList<String> specializationList;
    ArrayList<WorkAddressData> workAddressList;
    ArrayList<ReviewData> reviewList;
    int yearsLicensed;
    int averageRating;
    int numberOfReviews;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(ArrayList<String> specializationList) {
        this.specializationList = specializationList;
    }

    public ArrayList<WorkAddressData> getWorkAddressList() {
        return workAddressList;
    }

    public void setWorkAddressList(ArrayList<WorkAddressData> workAddressList) {
        this.workAddressList = workAddressList;
    }

    public int getYearsLicensed() {
        return yearsLicensed;
    }

    public void setYearsLicensed(int yearsLicensed) {
        this.yearsLicensed = yearsLicensed;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public ArrayList<ReviewData> getReviewList() {
        return reviewList;
    }
    
    public void setReviewList(ArrayList<ReviewData> reviewList) {
        this.reviewList = reviewList;
    }   
}
