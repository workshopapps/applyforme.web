package com.hydraulic.applyforme.controller;

//<<<<<<< HEAD
//=======
//import com.hydraulic.applyforme.model.domain.Country;
//>>>>>>> 85d46d3654f56e17b948fda682b7e825e37a1d85
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(
        value = "cover-letter",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        consumes = { MediaType.APPLICATION_JSON_VALUE }
)
public class CoverLetterController {

    @GetMapping("/entries")
    public List<Object> findAll() {
        return Collections.EMPTY_LIST;
    }

}
