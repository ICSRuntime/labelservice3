package com.digitalml.rest.resources.codegentest.resource;	

import java.io.IOException;

import static net.logstash.logback.argument.StructuredArguments.value;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoggingFilter implements javax.servlet.Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			long startTime = System.nanoTime();
			chain.doFilter(request, response);
			long end = System.nanoTime();
			LOGGER.info("log message {} {} {} {} ns", value("apiname", "labelservice"), value("apiversion", "1"),
					value("apipath", ((HttpServletRequest) request).getPathInfo()), value("response-timing", (end - startTime)));
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}