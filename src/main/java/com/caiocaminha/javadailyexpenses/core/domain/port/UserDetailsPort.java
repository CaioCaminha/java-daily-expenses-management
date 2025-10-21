package com.caiocaminha.javadailyexpenses.core.domain.port;

import com.caiocaminha.javadailyexpenses.core.domain.entities.UserDetails;

public interface UserDetailsPort {

    void upsertUser(UserDetails user);

    UserDetails getByEmail(String email);

}
