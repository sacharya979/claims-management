package com.libertymutual.claimsmanagement.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "pet_insurance_claims")
public class PetInsurance extends GeneralInsurance {

    /**
     * Type of the animal involved in the claim (e.g., dog, cat).
     */
    @Column(name = "animal_type", nullable = false)
    private String animalType;

    /**
     * Breed of the animal involved in the claim.
     */
    @Column(name = "breed_of_animal", nullable = false)
    private String breedOfAnimal;

    // Getters and setters
}
