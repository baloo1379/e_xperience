package pl.baloo.e_xperience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.baloo.e_xperience.dao.RepoDao;
import pl.baloo.e_xperience.model.Repo;

import java.util.List;

@Service
public class RepoService {

    private final RepoDao repoDao;

    @Autowired
    public RepoService(@Qualifier("GitHub") RepoDao repoDao) {
        this.repoDao = repoDao;
    }

    public List<Repo> selectAllRepos() {
        return repoDao.selectAllRepos();
    }
}
