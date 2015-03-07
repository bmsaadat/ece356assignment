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
    int licenseYear;
    List<String> specialization;
    List<WorkAddressData> workAddresses;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLicenseYear() {
        return licenseYear;
    }

    public void setLicenseYear(int licenseYear) {
        this.licenseYear = licenseYear;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<String> specialization) {
        this.specialization = specialization;
    }

    public List<WorkAddressData> getWorkAddresses() {
        return workAddresses;
    }

    public void setWorkAddresses(List<WorkAddressData> workAddresses) {
        this.workAddresses = workAddresses;
    }
    
    
}
