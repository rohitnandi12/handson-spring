package com.spring_experiments.testingstrategies;

import com.spring_experiments.testingStrategies.controller.SuperHeroController;
import com.spring_experiments.testingStrategies.domain.SuperHero;
import com.spring_experiments.testingStrategies.exceptions.NonExistingHeroException;
import com.spring_experiments.testingStrategies.repository.SuperHeroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * This class demonstrates how to test a controller using MockMVC loading a Test Context
 *
 * @author moises.macero
 */
@AutoConfigureJsonTesters
@WebMvcTest(SuperHeroController.class)
/* inherited from WebMvcTest
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@BootstrapWith(WebMvcTestContextBootstrapper.class)
@ExtendWith(SpringExtension.class)
@OverrideAutoConfiguration(enabled = false)
@TypeExcludeFilters(WebMvcTypeExcludeFilter.class)
@AutoConfigureCache
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@ImportAutoConfiguration
**/
class SuperHeroControllerMockMvcWithContextTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SuperHeroRepository superHeroRepository;

    // This object will be initialized thanks to @AutoConfigureJsonTesters
    @Autowired
    private JacksonTester<SuperHero> jsonSuperHero;

    @Test
    void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(superHeroRepository.getSuperHero(2))
                .willReturn(new SuperHero("Rob", "Mannon", "RobotMan"));

        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/2")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
        );
    }

    @Test
    void canRetrieveByIdWhenDoesNotExist() throws Exception {
        // given
        given(superHeroRepository.getSuperHero(2))
                .willThrow(new NonExistingHeroException());

        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/2")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEmpty();
    }

    @Test
    void canRetrieveByNameWhenExists() throws Exception {
        // given
        given(superHeroRepository.getSuperHero("RobotMan"))
                .willReturn(Optional.of(new SuperHero("Rob", "Mannon", "RobotMan")));

        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/?name=RobotMan")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
        );
    }

    @Test
    void canRetrieveByNameWhenDoesNotExist() throws Exception {
        // given
        given(superHeroRepository.getSuperHero("RobotMan"))
                .willReturn(Optional.empty());

        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/?name=RobotMan")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("null");
    }

    @Test
    void canCreateANewSuperHero() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/superheroes/").contentType(MediaType.APPLICATION_JSON).content(
                        jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
                )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void headerIsPresent() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                        get("/superheroes/2")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getHeaders("X-SUPERHERO-APP")).containsOnly("super-header");
    }
}