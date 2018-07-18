package com.lifebook.Repositories;

import com.lifebook.Model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser,Long>{
    AppUser findByUserName(String  userName);
    AppUser findUserClassByUserName(String userName);


}
