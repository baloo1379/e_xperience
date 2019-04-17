package pl.baloo.e_xperience.api;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.baloo.e_xperience.model.Repo;
import pl.baloo.e_xperience.service.RepoService;

import java.lang.reflect.Array;
import java.util.*;

@RequestMapping("api")
@RestController
public class RepoController {

    private final RepoService repoService;

    @Autowired
    public RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping
    public Repo getLatestModifiedRepo() {
        List<Repo> allRepos = repoService.selectAllRepos();
        return Collections.min(allRepos);
    }
}
