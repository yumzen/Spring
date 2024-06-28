package hongikhospital.example.hongikhospital.service;

import hongikhospital.example.hongikhospital.DTO.HospitalReqDto;
import hongikhospital.example.hongikhospital.DTO.HospitalResDto;
import hongikhospital.example.hongikhospital.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hongikhospital.example.hongikhospital.repository.HospitalRepository;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    public HospitalResDto create(HospitalReqDto reqDto){
        Hospital hospital = reqDto.from();

        Hospital savedHospital = hospitalRepository.save(hospital);

        return HospitalResDto.of(savedHospital);
    }
}
