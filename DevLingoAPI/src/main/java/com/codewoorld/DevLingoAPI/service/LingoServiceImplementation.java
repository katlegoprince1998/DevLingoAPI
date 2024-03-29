package com.codewoorld.DevLingoAPI.service;

import com.codewoorld.DevLingoAPI.collection.Lingo;
import com.codewoorld.DevLingoAPI.exception.LingoNotFoundException;
import com.codewoorld.DevLingoAPI.repository.LingoRepository;
import dto.LingoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LingoServiceImplementation implements LingoService {
    private final LingoRepository repository;
    private MongoTemplate template;

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
        if (repository.findByName(name).isEmpty()) {
            throw new LingoNotFoundException("Lingo not found");
        }
        return repository.findByName(name);

    }

    @Override
    public String delete(String id) {
        if (repository.findById(id).isEmpty()) {
            throw new LingoNotFoundException("Lingo not found");
        }
        repository.deleteById(id);
        return "deleted";
    }

    @Override
    public Page<Lingo> search(String name, String community, String yearCreated,
                              String createdBy, String usage, Pageable pageable) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (StringUtils.hasText(name)) {
            criteriaList.add(Criteria.where("name").regex(name, "i"));
        }
        if (StringUtils.hasText(community)) {
            criteriaList.add(Criteria.where("community").regex(community, "i"));
        }
        if (StringUtils.hasText(yearCreated)) {
            try {
                criteriaList.add(Criteria.where("year_created").is(Integer.parseInt(yearCreated)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid yearCreated format. Must be an integer.");
            }
        }
        if (StringUtils.hasText(createdBy)) {
            criteriaList.add(Criteria.where("created_by").regex(createdBy, "i"));
        }
        if (StringUtils.hasText(usage)) {
            criteriaList.add(Criteria.where("usage").regex(usage, "i"));
        }

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        List<Lingo> result = template.find(query.with(pageable), Lingo.class);
        long total;

        try {
            total = template.count(query, Lingo.class);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while counting total records.", e);
        }

        return PageableExecutionUtils.getPage(result, pageable, () -> total);
    }

    @Override
    public String update(String id, LingoDto dto) {
        if (repository.findById(id).isEmpty()) {
            throw new LingoNotFoundException("Lingo not found");
        }
        Lingo lingoDb = repository.findById(id).get();

        if(Objects.nonNull(dto.getName()) && !"".equalsIgnoreCase(dto.getName())) {
            lingoDb.setName(dto.getName());
        }
        if(Objects.nonNull(dto.getCommunity()) && !"".equalsIgnoreCase(dto.getCommunity())) {
            lingoDb.setCommunity(dto.getCommunity());
        }
        if(dto.getYear_created() != null) {
            lingoDb.setYear_created(Integer.valueOf(dto.getYear_created()));
        }
        if(Objects.nonNull(dto.getCreated_by()) && !"".equalsIgnoreCase(dto.getCreated_by())) {
            lingoDb.setCreated_by(dto.getCreated_by());
        }
        if(Objects.nonNull(dto.getUsage()) && !"".equalsIgnoreCase(String.valueOf(dto.getUsage()))) {
            lingoDb.setUsage(dto.getUsage());
        }

        repository.save(lingoDb);
        return "updated";
    }

    @Override
    public List<Lingo> get() {
        if (repository.findAll().isEmpty()) {
            throw new LingoNotFoundException("Lingo not found");
        }
        return repository.findAll();
    }

}
