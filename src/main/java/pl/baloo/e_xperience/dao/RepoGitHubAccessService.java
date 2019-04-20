package pl.baloo.e_xperience.dao;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.*;
import pl.baloo.e_xperience.model.Repo;

import java.util.*;

@Repository("GitHub")
public class RepoGitHubAccessService implements RepoDao {

    @Override
    public List<Repo> selectAllRepos() {
        // get data from github api
        List<Repo> tempRepoList = new ArrayList<>();
        int reposNumber = this.reposNumber();

        reposNumber = reposNumber/30 + reposNumber%30 > 1 ? 1 : 0;

        for (int i=0; i<reposNumber; i++) {
            RestTemplate restTemplate = new RestTemplate();
            final String url = "https://api.github.com/orgs/allegro/repos?page="+i;
            ResponseEntity<List<Repo>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Repo>>() {
                    });
            tempRepoList.addAll(Objects.requireNonNull(response.getBody()));
        }
        return tempRepoList;
    }

    private int reposNumber() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://api.github.com/orgs/allegro";
        Map response = restTemplate.getForObject(url, Map.class);
        return response != null ? (int) response.get("public_repos") : -1;

    }
}
