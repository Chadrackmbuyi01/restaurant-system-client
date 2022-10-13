package za.ac.cput.factory;

import za.ac.cput.domain.Owner;

public class OwnerFactory {

    //creating objects
    public static Owner createOwner(int ownerId, String ownerName){

        return new Owner.Builder().setOwnerId(ownerId)
                .setOwnerName(ownerName)
                .build();

    }


}
