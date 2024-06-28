package hongikhospital.example.hongikhospital.DTO;

import hongikhospital.example.hongikhospital.domain.Department;
import hongikhospital.example.hongikhospital.domain.Hospital;
import lombok.Builder;

import java.util.List;

public record HospitalReqDto (
        String name,
        AddressDto address,
        List<Department> departmentList
){
    @Builder
    public Hospital from(){
        return Hospital.builder()
                .name(this.name)
                .address(this.address.from())
                .departmentList(this.departmentList)
                .build();
    }
}