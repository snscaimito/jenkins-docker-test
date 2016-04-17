package com.devbugger.jdt.web;

import com.devbugger.jdt.JenkinsDockerTest;
import com.devbugger.jdt.name.Name;
import com.devbugger.jdt.name.NameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JenkinsDockerTest.class)
@WebAppConfiguration
public class NameControllerTest {

    private MockMvc mvc;

    @Autowired
    private NameService nameService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getOne() throws Exception {
        Name name = nameService.findOne(1L);
        mvc.perform(MockMvcRequestBuilders.get("/name/"+name.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name", is(name.getName())))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/name/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}