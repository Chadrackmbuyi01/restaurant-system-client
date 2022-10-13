/* Restaurant.java
   Entity for the Restaurant
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 29 March 2022
 */
package za.ac.cput.domain;

public class Restaurant {
    private String restRegNumber;
    private String restName;
    private String restAddress;

    // private constructor required
    private Restaurant (Builder builder){
        this.restRegNumber = builder.restRegNumber;
        this.restName = builder.restName;
        this.restAddress = builder.restAddress;

    }


    public String getRestRegNumber() {
        return restRegNumber;
    }

    public void setRestRegNumber(String restRegNumber) {
        this.restRegNumber = restRegNumber;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAddress() {
        return restAddress;
    }

    public void setRestAddress(String restAddress) {
        this.restAddress = restAddress;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restRegNumber=" + restRegNumber +
                ", restName='" + restName + '\'' +
                ", restAddress='" + restAddress + '\'' +
                '}';
    }

    public static class Builder{

        private String restRegNumber;
        private String restName;
        private String restAddress;

        public Builder setRestRegNumber(String restId) {
            this.restRegNumber = restId;
            return this;
        }

        public Builder setRestName(String restName) {
            this.restName = restName;
            return this;
        }

        public Builder setRestAddress(String restAddress) {
            this.restAddress = restAddress;
            return this;
        }

        public Builder copy(Restaurant restaurant){
            this.restRegNumber = restaurant.restRegNumber;
            this.restName = restaurant.restName;
            this.restAddress = restaurant.restAddress;
            return this;
        }
        public Restaurant build(){
            return new Restaurant(this);
        }
    }

}
