/**
 * 
 */
package com.booking.hotel.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import io.swagger.annotations.Api;

/**
 * @author magantilavakumar
 *
 */
@Configuration
@Api(value = "Basic Application Configurations")
public class MessageSourceConfig {

	@Bean
	@Qualifier(value = "errorMessageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:errorMessages");
		bundleMessageSource.setDefaultEncoding("UTF-8");
		return bundleMessageSource;
	}
}
