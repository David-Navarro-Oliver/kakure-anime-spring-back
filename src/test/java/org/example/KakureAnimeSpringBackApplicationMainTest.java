package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.mockStatic;

class KakureAnimeSpringBackApplicationMainTest {

    @Test
    void mainShouldDelegateToSpringApplicationRun() {
        String[] args = {"--spring.main.web-application-type=none"};

        try (MockedStatic<SpringApplication> springApplication = mockStatic(SpringApplication.class)) {
            KakureAnimeSpringBackApplication.main(args);

            springApplication.verify(() -> SpringApplication.run(KakureAnimeSpringBackApplication.class, args));
        }
    }
}
