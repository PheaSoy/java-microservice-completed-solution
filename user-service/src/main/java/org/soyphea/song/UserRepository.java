package org.soyphea.song;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {


    List findBySingerName(String singerName);
    Optional<User> findByName(String name);
}
