package io.github.devspoint.service

import io.github.devspoint.entity.Investment
import io.github.devspoint.handles.exceptions.StartupInvalidException
import io.github.devspoint.repository.InvestmentRepository
import javax.enterprise.context.ApplicationScoped
import java.time.LocalDate

@ApplicationScoped
class InvestmentService(
    private val investmentRepository : InvestmentRepository
) {

    fun save(investment: Investment): Investment {
        // FINTECH
        if(investment.sector == Investment.SectorEnum.FINTECH) {
            if(investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    if(investment.value >= 500000 && investment.value <= 2000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 500 thousand to 2 millions dollars for this valuation")
                }
                throw StartupInvalidException("FinTech should be operating for more than 2 years for this Valuation")
            }
            if(investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 2000000 && investment.value <= 6000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 2 to 6 millions dollars for this valuation")
                }
                throw StartupInvalidException("FinTech should be operating for more than 2 years for this Valuation")
            }
            if(investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                    if(investment.value >= 6000000 && investment.value <= 10000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 6 to 10 millions dollars for this valuation")
                }
                throw StartupInvalidException("FinTech should be operating for more than 3 years for this Valuation")
            }
            throw StartupInvalidException("Valuation Not Allowed for FinTech, valuation should be between 10 to 60 millions dollars")
        }
        // HEALTHTECH
        if(investment.sector == Investment.SectorEnum.HEALTHTECH) {
            if(investment.companyValuation >= 3000000 && investment.companyValuation <= 8000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    if(investment.value >= 200000 && investment.value <= 600000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 200 to 600 thousand dollars for this valuation")
                }
                throw StartupInvalidException("HealthTech should be operating for more than 1 year for this Valuation")
            }
            if(investment.companyValuation > 8000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 600000 && investment.value <= 2000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 600 thousand to 2 millions dollars for this valuation")
                }
                throw StartupInvalidException("HealthTech should be operating for more than 1 year for this Valuation")
            }
            if(investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 1000000 && investment.value <= 3000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 1 to 3 millions dollars for this valuation")
                }
                throw StartupInvalidException("HealthTech should be operating for more than 2 year for this Valuation")
            }
            throw StartupInvalidException("Valuation Not Allowed for HealthTech, valuation should be between 3 to 60 millions dollars")
        }
        // FOODTECH
        if(investment.sector == Investment.SectorEnum.FOODTECH) {
            if(investment.companyValuation >= 10000000 && investment.companyValuation <= 15000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(1))) {
                    if(investment.value >= 600000 && investment.value <= 1200000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 600 thousand to 1.2 millions thousand dollars for this valuation")
                }
                throw StartupInvalidException("FoodTech should be operating for more than 1 year for this Valuation")
            }
            if(investment.companyValuation > 15000000 && investment.companyValuation <= 40000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(2))) {
                    if(investment.value >= 1000000 && investment.value <= 4000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 1 to 4 millions thousand dollars for this valuation")
                }
                throw StartupInvalidException("FoodTech should be operating for more than 2 year for this Valuation")
            }
            if(investment.companyValuation > 40000000 && investment.companyValuation <= 60000000) {
                if(investment.startDate!!.isBefore(LocalDate.now().minusYears(3))) {
                    if(investment.value >= 2000000 && investment.value <= 6000000) {
                        return investmentRepository.save(investment)
                    }
                    throw StartupInvalidException("Value to invest should be between 2 to 6 millions thousand dollars for this valuation")
                }
                throw StartupInvalidException("FoodTech should be operating for more than 3 year for this Valuation")
            }
            throw StartupInvalidException("Valuation Not Allowed for FoodTech, valuation should be between 10 to 60 millions dollars")
        }
        throw StartupInvalidException("Sector not allowed to invest")
    }    

}