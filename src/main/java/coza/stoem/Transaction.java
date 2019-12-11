package coza.stoem;

import java.time.LocalDate;

public class Transaction {

    private String restuarant;
    private String organisation;
    private LocalDate date;
    private String details;
    private int feedCount;

    public Transaction(String s){
        System.out.println(s);
    }



    //getters and setters
    public String getRestuarant() {
        return restuarant;
    }

    public void setRestuarant(String restuarant) {
        this.restuarant = restuarant;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getfeedCount() {
        return feedCount;
    }

    public void feedCount(int mounths) {
        this.feedCount = mounths;
    }




}
