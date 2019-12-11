package coza.stoem;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Transaction {

    private String restaurant;
    private String organisation;
    private String phone;
    LocalDateTime date;
    private String details;
    private int feedCount;

    public Transaction(HashMap details){
        this.restaurant = (String) details.get("restaurant");
        this.organisation = (String) details.get("organisation");
        this.phone =(String) details.get("phone");
        this.date = LocalDateTime.now();
        this.details = (String) details.get("details");
        this.feedCount = Integer.valueOf((String)details.get("feedCount"));
    }

}
