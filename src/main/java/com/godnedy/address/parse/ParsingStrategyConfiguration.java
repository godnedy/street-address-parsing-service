package com.godnedy.address.parse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ParsingStrategyConfiguration {

    @Autowired
    private BeanFactory beanFactory;

    private ServiceLocatorFactoryBean myFactoryLocator() {
        final ServiceLocatorFactoryBean locator = new ServiceLocatorFactoryBean();
        locator.setServiceLocatorInterface(ParsingStrategyFactory.class);
        locator.setBeanFactory(beanFactory);
        return locator;
    }

    @Bean
    public ParsingStrategyFactory myFactory() {
        final ServiceLocatorFactoryBean locator = myFactoryLocator();
        locator.afterPropertiesSet();
        return (ParsingStrategyFactory) locator.getObject();
    }

    @Bean(name = SimpleAddressParsingStrategy.NAME)
    ParsingStrategy simpleAddressParsingStrategy() {
        return new SimpleAddressParsingStrategy();
    }

    @Bean(name = ComplexStreetParsingStrategy.NAME)
    ParsingStrategy complexStreetParsingStrategy() {
        return new ComplexStreetParsingStrategy();
    }

    @Bean(name = HouseCommaStreetParsingStrategy.NAME)
    ParsingStrategy houseCommaStreetParsingStrategy() {
        return new HouseCommaStreetParsingStrategy();
    }

    @Bean(name = SimpleHouseStreetParsingStrategy.NAME)
    ParsingStrategy houseNumberParsingStrategy() {
        return new SimpleHouseStreetParsingStrategy();
    }

    @Bean(name = StreetCommaHouseParsingStrategy.NAME)
    ParsingStrategy streetCommaHouseParsingStrategy() {
        return new StreetCommaHouseParsingStrategy();
    }

    @Bean(name = StreetNumberHouseSuffixParsingStrategy.NAME)
    ParsingStrategy streetNumberHouseNumberSuffixParsingStrategy() {
        return new StreetNumberHouseSuffixParsingStrategy();
    }

}
