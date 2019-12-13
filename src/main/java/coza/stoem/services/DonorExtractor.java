package coza.stoem.services;

public class DonorExtractor {


        private String restaurant;
        private String cellphone;
        private String location;
        private String feedCount;

        public DonorExtractor(String data){
            String[] datalist = data.replace("+", " ").split("&");
            this.restaurant = datalist[0].replace("restaurant=", "");
            this.cellphone = datalist[1].replace("phone=", "");
            this.location = datalist[2].replace("location=", "");
            this.feedCount = datalist[3].replace("feedCount=", "");
        }

        public String getRestaurant() {
            return restaurant;
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


