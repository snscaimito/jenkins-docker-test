package com.devbugger.jdt.name;

import com.devbugger.jdt.JenkinsDockerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JenkinsDockerTest.class)
public class NameServiceTest {

    @Autowired
    private NameService nameService;

    @Test
    public void findOne() throws Exception {
        Name name = nameService.findOne(1L);
        assertThat("Should not be empty", name.getName(), is("jenkins"));
    }

    @Test
    public void findAll() throws Exception {
        List<Name> names = nameService.findAll();
        assertThat("Should contain 6 elements", names.size(), is(6));
    }
}
