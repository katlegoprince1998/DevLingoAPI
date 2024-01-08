package com.codewoorld.DevLingoAPI.service;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import dto.LingoDto;

import java.util.List;

public interface LingoService {
    String create(LingoDto dto);

    List<Lingo> getAllData(String name);
}
