package com.caiocaminha.javadailyexpenses.core.gateway.r2dbc;

import com.caiocaminha.javadailyexpenses.core.domain.entities.UserDetails;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserDetailsRepository extends ReactiveCrudRepository<UserDetails, Long> {
}
