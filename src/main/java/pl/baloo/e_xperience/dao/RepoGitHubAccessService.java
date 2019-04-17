package pl.baloo.e_xperience.dao;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.baloo.e_xperience.model.Repo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository("GitHub")
public class RepoGitHubAccessService implements RepoDao {

    @Override
    public List<Repo> selectAllRepos() {
        // get data from github api
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://api.github.com/orgs/allegro/repos";
        ResponseEntity<List<Repo>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Repo>>(){});

        return response.getBody();
    }
}
