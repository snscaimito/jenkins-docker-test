package com.devbugger.jdt.name;

import java.util.List;

public interface NameService {

    Name findOne(Long id);

    List<Name> findAll();
}
