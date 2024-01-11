package com.codewoorld.DevLingoAPI.service;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import dto.LingoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LingoService {
    String create(LingoDto dto);

    List<Lingo> getAllData(String name);

    String delete(String id);

    Page<Lingo> search(String name, String community, String yearCreated, String createdBy, String usage, Pageable pageable);

    String update(String id, LingoDto dto);

    List<Lingo> get();
}
