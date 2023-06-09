package com.example.oose_23_3_back.managementcontrol.control;

import com.example.oose_23_3_back.managementcontrol.entity.Bicycle;
import com.example.oose_23_3_back.managementcontrol.service.RentalOfficeService;
import com.example.oose_23_3_back.managementcontrol.entity.RentalOffice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RentalOfficeControl {
    private final RentalOfficeService rentalOfficeService;

    @PostMapping("/rentalOfficeInsert")
    public String rentalOfficeCreate(@RequestBody RentalOffice rentalOffice) {
        if (!rentalOfficeService.idVerification(rentalOffice.getRentalOfficeNum())) {
            return "id";
        }

        this.rentalOfficeService.rentalOfficeCreate(rentalOffice);
        return "success";
    }

    @GetMapping("/rentalOfficeFindAll")
    public List<RentalOffice> rentalOfficeFindAll() {
        return rentalOfficeService.rentalOfficeFindAll();
    }

    @GetMapping("/test/{id}")
    public RentalOffice test(@PathVariable Long id) {
        return rentalOfficeService.rentalOfficeFindById(id);
    }
}
