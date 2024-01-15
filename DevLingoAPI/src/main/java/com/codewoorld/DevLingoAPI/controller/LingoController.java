package com.codewoorld.DevLingoAPI.controller;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import com.codewoorld.DevLingoAPI.service.LingoService;
import dto.LingoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LingoController {
    private final LingoService service;
    @GetMapping("/")
    public String index(Principal principal) {
        return "Hello " + principal.getName() + "!";
    }

    @PostMapping("/create")
    public String create(@RequestBody LingoDto dto) {
        return service.create(dto);
    }

    @GetMapping("/get/{name}" )
    public List<Lingo> lingos(@PathVariable("name") String name) {
        return service.getAllData(name);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
    @GetMapping("/search")
    public Page<Lingo> search(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String community,
                              @RequestParam(required = false) String year_created,
                              @RequestParam(required = false) String created_by,
                              @RequestParam(required = false) String usage,
                              @RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "5") Integer size

    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.search(name, community, year_created, created_by, usage, pageable);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") String id, @RequestBody LingoDto dto) {
        return service.update(id, dto);
    }

    @GetMapping("/get")
    public List<Lingo> get(){
        return service.get();
    }
  }
