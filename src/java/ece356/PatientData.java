/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ece356;
import java.sql.Timestamp;
import java.util.*;
/**
 *
 * @author behrozsaadat
 */
public class PatientData extends UserData{
    String city;
    String state;
    int numberOfReviews;
    Timestamp lastReviewDate;
    FriendShipStatus friendShipStatusWithLoggedInUser;
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Date getLastReviewDate() {
        return lastReviewDate;
    }

    public void setLastReviewDate(Timestamp lastReviewDate) {
        this.lastReviewDate = lastReviewDate;
    }

    public FriendShipStatus getFriendShipStatusWithLoggedInUser() {
        return friendShipStatusWithLoggedInUser;
    }

    public void setFriendShipStatusWithLoggedInUser(FriendShipStatus friendShipStatusWithLoggedInUser) {
        this.friendShipStatusWithLoggedInUser = friendShipStatusWithLoggedInUser;
    }
    
    
}
