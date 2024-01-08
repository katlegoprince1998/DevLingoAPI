package com.codewoorld.DevLingoAPI.service;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import com.codewoorld.DevLingoAPI.repository.LingoRepository;
import dto.LingoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LingoServiceImplementation implements LingoService {
    private final LingoRepository repository;

    @Override
    public String create(LingoDto dto) {
        Lingo lingo = new Lingo();
        BeanUtils.copyProperties(dto, lingo);

        try {
            Lingo savedLingo = repository.save(lingo);
            return String.valueOf(savedLingo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    @Override
    public List<Lingo> getAllData(String name) {

        return repository.findByName(name);

    }
}
