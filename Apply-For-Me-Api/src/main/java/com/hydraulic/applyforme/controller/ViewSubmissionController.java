package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.DeleteManySubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.service.ViewSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        value = "submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ViewSubmissionController {

    private final ViewSubmissionService viewSubmissionService;


    @GetMapping("/entries")
    public List<Submission> findAll(@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageNumber){
        return viewSubmissionService.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<Submission> findAll(){
        return viewSubmissionService.findAll();
    }

    @GetMapping("/detail/{id}")
    public Submission findOne(@PathVariable(name = "id") Long id){
        return viewSubmissionService.findOne(id);
    }

    @PostMapping("/save")
    public Submission save(@Validated @RequestBody SubmissionDto body){
        return viewSubmissionService.save(body);
    }

    @PutMapping("/update/{id}")
    public Submission update(@Validated @RequestBody SubmissionDto body, @PathVariable(name = "id") Long id){
        return viewSubmissionService.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return viewSubmissionService.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManySubmissionDto body){
        return viewSubmissionService.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll(){
        return viewSubmissionService.deleteAll();
    }

//    @GetMapping("/entries")
//    public ResponseEntity<Collection<Submission>> getAll() {
////       new ResponseEntity<>(viewSubmissionService.getAllApplicationSubmissions(), HttpStatus.OK);
//        return ResponseEntity.ok(viewSubmissionService.getAllApplicationSubmissions());
//    }
}
