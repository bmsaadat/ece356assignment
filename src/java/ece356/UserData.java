package ece356;

public class UserData {
    
    String userName;
    String passwordHash;
    String passwordSalt;
    String firstName;
    String middleInitial;
    String lastName;
    String emailAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String value) {
        userName = value;
    }
    
    public String getPasswordHash(){
        return passwordHash;
    }
    
    public void setPasswordHash(String value){
        passwordHash = value;
    }
    
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}