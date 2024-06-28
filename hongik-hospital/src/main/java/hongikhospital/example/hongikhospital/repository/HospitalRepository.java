package hongikhospital.example.hongikhospital.repository;

import hongikhospital.example.hongikhospital.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository  extends JpaRepository<Hospital, Long> {
}
