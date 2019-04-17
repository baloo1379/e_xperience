package pl.baloo.e_xperience.dao;

import pl.baloo.e_xperience.model.Repo;

import java.util.List;

public interface RepoDao {

    List<Repo> selectAllRepos();

}
