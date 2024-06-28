package hongikhospital.example.hongikhospital.controller;

import hongikhospital.example.hongikhospital.DTO.HospitalReqDto;
import hongikhospital.example.hongikhospital.DTO.HospitalResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hongikhospital.example.hongikhospital.service.HospitalService;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping("")
    public ResponseEntity<HospitalResDto> createHospital(@RequestBody HospitalReqDto reqDto){
        return new ResponseEntity<HospitalResDto>(hospitalService.create(reqDto), HttpStatus.OK);
    }
}
