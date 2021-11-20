package io.github.devspoint.repository

import io.github.devspoint.entity.Investment
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class InvestmentRepository {

    fun save(investment : Investment): Investment {
        return investment
    }

}