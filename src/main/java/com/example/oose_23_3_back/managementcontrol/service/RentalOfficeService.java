package com.example.oose_23_3_back.managementcontrol.service;

import com.example.oose_23_3_back.managementcontrol.repository.RentalOfficeRepository;
import com.example.oose_23_3_back.managementcontrol.entity.RentalOffice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RentalOfficeService {
    private final RentalOfficeRepository rentalOfficeRepository;

    public void rentalOfficeCreate(RentalOffice rentalOffice) {
        this.rentalOfficeRepository.save(rentalOffice);
    }

    public List<RentalOffice> rentalOfficeFindAll() {
        return rentalOfficeRepository.findAll();
    }

    public RentalOffice rentalOfficeFindById(Long id) {
        return this.rentalOfficeRepository.findById(id).orElse(null);
    }

    public boolean isOverMaximumBicycle(RentalOffice rentalOffice) {
        return rentalOffice.getMaximumBicycle() <= rentalOffice.getBicycleList().size();
    }

    public boolean idVerification(Long id) {
        Optional<RentalOffice> bicycle = this.rentalOfficeRepository.findById(id);
        return bicycle.isEmpty();
    }
}
