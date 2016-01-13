package com.kx.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import rdvmedecins.config.DomainAndPersistenceConfig;

/**
 * Created by KX on 13/01/2016.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.kx.web"})
@Import(DomainAndPersistenceConfig.class)
public class Appconfig {
}
