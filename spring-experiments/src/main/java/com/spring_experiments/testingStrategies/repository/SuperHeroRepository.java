package com.spring_experiments.testingStrategies.repository;

import com.spring_experiments.testingStrategies.exceptions.NonExistingHeroException;
import com.spring_experiments.testingStrategies.domain.SuperHero;

import java.util.Optional;

/**
 * Provides access to superheroes' data
 * @author moises.macero
 */
public interface SuperHeroRepository {

    /**
     * Retrieves a super hero by the id.
     * If the id does not exist, a {@link NonExistingHeroException} will be thrown.
     *
     * @param id the unique id of the super hero
     * @return the SuperHero details
     */
    SuperHero getSuperHero(int id);

    /**
     * Retrieves a super hero given his super hero alias.
     *
     * @param heroName the super hero name
     * @return the SuperHero details
     */
    Optional<SuperHero> getSuperHero(String heroName);

    /**
     * Saves the super hero.
     *
     * @param superHero the details of the super hero
     */
    void saveSuperHero(SuperHero superHero);

}
