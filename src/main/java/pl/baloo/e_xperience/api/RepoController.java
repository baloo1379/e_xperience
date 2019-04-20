package pl.baloo.e_xperience.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import pl.baloo.e_xperience.model.Repo;
import pl.baloo.e_xperience.service.RepoService;

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
    public ResponseEntity<Repo> getLatestModifiedRepo() {
        List<Repo> allRepos = repoService.selectAllRepos();
        Repo result = Collections.min(allRepos);
        if(result.getName().equals("message")) return new ResponseEntity<>(result, HttpStatus.SERVICE_UNAVAILABLE);
        else return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler({RestClientException.class})
    public ResponseEntity<Map<String, String>> handleException() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "Service unavailable");
        responseBody.put("message", "Communication error");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(responseBody);
    }
}
