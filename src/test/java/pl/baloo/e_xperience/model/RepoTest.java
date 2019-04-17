package pl.baloo.e_xperience.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RepoTest {

    @Test
    void shouldParseDate() {
        String dateString = "2011-12-03T10:15:30Z";
        ZonedDateTime date = ZonedDateTime.ofInstant(Instant.parse(dateString), ZoneOffset.UTC);
        assertEquals(dateString, date.toString());
    }

    @Test
    void shouldCreateRepo() {
        String name = "test";
        String dateString = "2018-11-20T01:36:52Z";
        ZonedDateTime date = ZonedDateTime.ofInstant(Instant.parse(dateString), ZoneOffset.UTC);
        Repo testRepo = new Repo(name, dateString);
        assertEquals(name, testRepo.getName());
        assertEquals(date, testRepo.getPushed_at());
    }

    @Test
    void shouldCompareDates() {
        Repo firstRepo = new Repo("test1", "2018-11-20T01:36:52Z");
        Repo secondRepo = new Repo("test2", "2018-11-20T02:16:52Z");
        List<Repo> testList = new ArrayList<>();
        testList.add(firstRepo);
        testList.add(secondRepo);
        assertNotNull(Collections.min(testList));
        assertEquals(secondRepo.getPushed_at(), Collections.min(testList).getPushed_at());
    }

}