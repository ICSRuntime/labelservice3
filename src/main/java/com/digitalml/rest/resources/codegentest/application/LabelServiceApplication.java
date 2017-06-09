package com.digitalml.rest.resources.codegentest.application;

import com.digitalml.rest.resources.codegentest.resource.LabelServiceResource;
import com.digitalml.rest.resources.codegentest.resource.ResourceLoggingFilter;					
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Configuration;

import java.util.EnumSet;
import javax.servlet.DispatcherType;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;


public class LabelServiceApplication extends Application<LabelServiceConfiguration> {

	public static void main(final String[] args) throws Exception {
		new LabelServiceApplication().run(args);
	}
	
	@Override
	public void initialize(final Bootstrap<LabelServiceConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final LabelServiceConfiguration configuration, final Environment environment) {

		//separate logging setup to enable use of external logback xml
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		context.reset();
		ContextInitializer initializer = new ContextInitializer(context);
		try {
			initializer.autoConfig();
		} catch (JoranException e) {
		}

		final LabelServiceResource resource = new LabelServiceResource();
		final LabelServiceHealthCheck healthCheck = new LabelServiceHealthCheck();
		
		environment.servlets().addFilter("ResourceLoggingFilter", new ResourceLoggingFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);

	}
}

final class LabelServiceConfiguration extends Configuration {
}

final class LabelServiceHealthCheck extends HealthCheck {

	public LabelServiceHealthCheck() {
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}