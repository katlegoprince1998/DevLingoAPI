package com.codewoorld.DevLingoAPI.controller;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import com.codewoorld.DevLingoAPI.service.LingoService;
import dto.LingoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LingoController {
    private final LingoService service;

    @PostMapping("/create")
    public String create(@RequestBody LingoDto dto) {
        return service.create(dto);
    }

    @GetMapping("/get/{name}" )
    public List<Lingo> lingos(@PathVariable("name") String name) {
        return service.getAllData(name);
    }
}
