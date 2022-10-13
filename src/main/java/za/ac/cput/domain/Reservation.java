package za.ac.cput.domain;
/*
 *Reservation.java
 * VuyolwethuKalolo
 * 214015637
 * 06-04-2022
 */

public class Reservation {

    private int reserveId;
    private String reserveName;

    // Constructor

    private Reservation(Builder builder) {
        this.reserveId = builder.reserveId;
        this. reserveName= builder.reserveName;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }



    public static class Builder {
        private int reserveId ;
        private String reserveName;


        public Builder setReserveId(int reserveId) {
            this.reserveId= reserveId;
            return this;
        }

        public Builder setReserveName(String reserveName) {
            this.reserveName =reserveName ;
            return this;
        }

        public Builder copy(Reservation reservation) {

            this.reserveId = reservation.reserveId;
            this.reserveName = reservation.reserveName;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }

}
