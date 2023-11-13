package com.libertymutual.claimsmanagement.entities;

// BaseEntity.java
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@MappedSuperclass
public abstract class BaseEntity {

    /**
     * Unique identifier for the claim.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Policy number associated with the claim.
     */
    @Column(name = "policy_number", nullable = false)
    protected String policyNumber;

    /**
     * Full name of the customer making the claim.
     */
    @Column(name = "customer_name", nullable = false)
    protected String customerName;

    /**
     * Date when the claim process is initiated.
     */
    @Column(name = "claim_start_date", nullable = false)
    protected LocalDate claimStartDate;

    /**
     * Estimated amount of the claim.
     */
    @Column(name = "estimated_amount", nullable = false)
    protected BigDecimal estimatedAmount;

    /**
     * Reason for the claim, described in a single line.
     */
    @Column(name = "claim_reason", nullable = false)
    protected String claimReason;

    /**
     * Detailed description of the incident leading to the claim.
     */
    @Column(name = "incident_description", nullable = false, length = 500)
    protected String incidentDescription;

    /**
     * Date of the incident or event leading to the claim.
     */
    @Column(name = "incident_date")
    protected LocalDate incidentDate;

    /**
     * Additional details regarding the claim, if any.
     */
    @Column(name = "additional_details", length = 1000)
    protected String additionalDetails;

}
