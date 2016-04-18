package com.devbugger.jdt.web;

import com.devbugger.jdt.name.Name;
import com.devbugger.jdt.name.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/name")
public class NameController {

    private NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Name one(@PathVariable("id") Long id) {
        return nameService.findOne(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Name> all() {
        return nameService.findAll();
    }
}
