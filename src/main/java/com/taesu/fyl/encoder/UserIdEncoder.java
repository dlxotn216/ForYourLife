package com.taesu.fyl.encoder;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.taesu.fyl.account.AccountDao;
import com.taesu.fyl.account.dto.AccountForInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by kim on 2016-12-29.
 */
@Component
public class UserIdEncoder {
    @Autowired
    private PasswordEncoder passwordEncoder;
    //TODO
    //사용자 인코딩 할경우 위 인코딩으로 하면 /가 인코딩 문자열에 섞임
    //jwt or sha 등 / 가 없는 방식 필요.
    private final String SECRET = "taesu";
    private final JWTSigner signer = new JWTSigner(SECRET);
    private final JWTVerifier verifier = new JWTVerifier(SECRET);
    private final String MAP_KEY_EXPIRE = "exp";
    private final String MAP_KEY_ID = "id";

    @Autowired
    private AccountDao accountDao;

    private static final String key = "TESTKEY";

    private String generate(String userId, String email){
        return userId+"/"+key+"/"+email;
    }

    public String createToken(AccountForInsert account) {

        final HashMap<String, Object> claims = new HashMap<>();
        claims.put(MAP_KEY_ID, account.getUserEmail());
        claims.put(MAP_KEY_EXPIRE, System.currentTimeMillis() + 86400000L);

        return signer.sign(claims);
    }
    public String encodingUserId(String userId, String email){
        return passwordEncoder.encode(generate(userId, email));
    }

    public Boolean isMatched(String origin, String encoded){
        return origin.equals(encoded);
    }


}
