package com.taesu.fyl.authority;

import com.taesu.fyl.authority.dto.AuthorityForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kim on 2016-11-30.
 */
@Service
public class AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;
    public List<AuthorityForSelect> readAccountAuthById(String userId){
        return authorityDao.readAccountAuthById(userId);
    }

    public List<AuthorityForSelect> readAuthorities(){
        return authorityDao.readAuthorities();
    }
}
