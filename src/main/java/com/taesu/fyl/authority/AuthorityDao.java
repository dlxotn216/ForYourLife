package com.taesu.fyl.authority;

import com.taesu.fyl.authority.dto.AuthorityForSelect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kim on 2016-11-30.
 */
@Mapper
@Component
public interface AuthorityDao {
    List<AuthorityForSelect> readAccountAuthById(String userId);
    List<AuthorityForSelect> readAuthorities();
}
