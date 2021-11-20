package io.github.devspoint.controller

import io.github.devspoint.entity.Investment
import io.github.devspoint.service.InvestmentService
import javax.ws.rs.Path
import javax.ws.rs.POST

@Path("/investments")
class InvestmentController(
    private val investmentService: InvestmentService
) {

    @POST
    fun create(investment: Investment) : Investment {
        return this.investmentService.save(investment)
    }    
 
}