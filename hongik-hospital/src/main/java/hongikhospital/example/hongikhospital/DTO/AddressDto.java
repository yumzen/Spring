package hongikhospital.example.hongikhospital.DTO;

import hongikhospital.example.hongikhospital.domain.Address;

public record AddressDto (
    String city,
    String street,
    String zipcode
){
    public Address from() {
        return new Address(this.city, this.street, this.zipcode);
    }
}
