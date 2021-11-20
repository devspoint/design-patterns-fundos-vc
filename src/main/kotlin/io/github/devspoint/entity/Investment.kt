package io.github.devspoint.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.time.LocalDate

@Entity
data class Investment(
    @Id @GeneratedValue    
    var id: String? = null,
    var companyCnpj: String? = null,
    var companyName: String? = null,
    var companyValuation: Double = 0.0.toDouble(),
    var sector: SectorEnum? = null,
    var value: Double = 0.0.toDouble(),
    var startDate: LocalDate? = null
) {
    enum class SectorEnum {
        FINTECH, HEALTHTECH, FOODTECH, RETAILTECH, AGTECH, LOGTECH, MARTECH
    }
}