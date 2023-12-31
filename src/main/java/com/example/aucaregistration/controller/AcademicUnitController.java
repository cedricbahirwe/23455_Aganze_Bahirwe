package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.AcademicUnit;
import com.example.aucaregistration.service.AcademicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/academicUnits",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class AcademicUnitController {

    private final AcademicUnitService academicUnitService;

    @Autowired
    public AcademicUnitController(AcademicUnitService academicUnitService) {
        this.academicUnitService = academicUnitService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveAcademicUnit(@RequestBody AcademicUnit academicUnit) {
        if (academicUnit != null) {
            try {
                AcademicUnit newUnit = academicUnitService.saveAcademicUnit(academicUnit);
                return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<AcademicUnit>> getAcademicUnits() {
        List<AcademicUnit> academicUnits = academicUnitService.getAcademicUnits();
        return ResponseEntity.ok(academicUnits);
    }

    @DeleteMapping(value = "/{academicUnitId}")
    public ResponseEntity<?> deleteCourseDefinition(@PathVariable Long academicUnitId) {
        try {
            academicUnitService.deleteAcademicUnit(academicUnitId);
            return new ResponseEntity<>("Academic Unit Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
