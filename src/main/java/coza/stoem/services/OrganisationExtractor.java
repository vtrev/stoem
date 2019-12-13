package coza.stoem.services;

public class OrganisationExtractor {

    private String organisation;
    private String cellphone;
    private String location;
    private String feedCount;

    public OrganisationExtractor(String data){
        String[] datalist = data.replace("+", " ").split("&");
        this.organisation = datalist[0].replace("organisation=", "");
        this.cellphone = datalist[1].replace("cell=", "");
        this.location = datalist[2].replace("location=", "");
        this.feedCount = datalist[3].replace("feeding=", "");
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getLocation() {
        return location;
    }

    public String getFeedCount() {
        return feedCount;
    }
}
