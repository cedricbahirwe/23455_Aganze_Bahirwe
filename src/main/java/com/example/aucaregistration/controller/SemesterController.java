package com.example.aucaregistration.controller;


import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/semesters",
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class SemesterController {

    private final SemesterService semesterService;

    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSemester(@RequestBody Semester semester) {
        if (semester != null) {
            boolean success = semesterService.saveSemester(semester);
            if (success) {
                return new ResponseEntity<>("Semester saved", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Something is wrong!", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping (value = "/")
    public ResponseEntity<List<Semester>> getSemesters() {
        List<Semester> semesters = semesterService.getSemesters();
        return ResponseEntity.ok(semesters);
    }
}
