package com.devbugger.jdt.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class NameServiceImpl implements NameService {

    private NameRepository nameRepository;

    @Autowired
    public NameServiceImpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public Name findOne(Long id) {
        return nameRepository.findOne(id);
    }

    @Override
    public List<Name> findAll() {
        return nameRepository.findAll();
    }

}
