/**
 *
 */
package br.com.edu.dependency.injection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;

import br.com.edu.dependency.injection.datasource.FakeDataSource;
import br.com.edu.dependency.injection.repositories.EnglishGreetingRepository;
import br.com.edu.dependency.injection.repositories.impl.EnglishGreetingRepositoryImpl;
import br.com.edu.dependency.injection.service.I18nEnglishGreetingService;
import br.com.edu.dependency.injection.service.I18nPortugueseGreetingService;
import br.com.edu.dependency.injection.service.PrimaryBeanGreetingService;
import br.com.edu.dependency.injection.service.PropertyGreetingService;
import br.com.edu.dependency.injection.service.SetterGreetingService;

/**
 * Define um configurador para os bean.
 *
 * @author eduardo
 *
 */
@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:bean-configuration.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${di.username}") final String username,
            @Value("${di.password}") final String password, @Value("${di.jdbcurl}") final String jdbcUrl) {
        // Variavel de ambiente com o nom DI_USERNAME tbm pode ser lida. Terá prioridade
        // maior do que o arquivo de properties !

        // através do programs arguments:
        // --di.password=PwdFromCmdLine

        // Podemos usar o próprio application.properties, então nao precisará criar novo
        // arquivo ou anotar a classe com o @PropertySource

        final FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({ "dog", "default" })
    @Bean("petService")
    PetService dogPetService(final PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile({ "cat" })
    @Bean("petService")
    PetService catPetService(final PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    public I18nEnglishGreetingService i18nService(final EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({ "PT", "default" })
    @Bean("i18nService")
    public I18nPortugueseGreetingService i18nPortugueseGreetingService() {
        return new I18nPortugueseGreetingService();
    }

    // Definido no xml
//	@Bean
//	ConstructorGreetingService constructorGreetingService() {
//		return new ConstructorGreetingService();
//	}

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

    @Primary
    @Bean
    PrimaryBeanGreetingService primaryBeanGreetingService() {
        return new PrimaryBeanGreetingService();
    }

}
