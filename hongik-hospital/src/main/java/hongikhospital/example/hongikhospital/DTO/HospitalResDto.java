package hongikhospital.example.hongikhospital.DTO;


import hongikhospital.example.hongikhospital.domain.Address;
import hongikhospital.example.hongikhospital.domain.Department;
import hongikhospital.example.hongikhospital.domain.Hospital;
import lombok.Builder;

import java.util.List;

@Builder
public record HospitalResDto (
        Long hospitalId,
        String name,
        Address address,
        List<Department> departmentList
){
    public static HospitalResDto of(Hospital hospital){
        return HospitalResDto.builder()
                .hospitalId(hospital.getId())
                .name(hospital.getName())
                .address(hospital.getAddress())
                .departmentList(hospital.getDepartmentList())
                .build();
    }
}
