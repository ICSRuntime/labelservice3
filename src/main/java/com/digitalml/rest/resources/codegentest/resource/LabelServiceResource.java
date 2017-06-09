package com.digitalml.rest.resources.codegentest.resource;
        	
import java.lang.IllegalArgumentException;
import java.security.AccessControlException;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import io.dropwizard.jersey.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.lang.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
	
// Customer specific imports

// Service specific imports
import com.digitalml.rest.resources.codegentest.service.LabelServiceService;
	
import com.digitalml.rest.resources.codegentest.service.LabelServiceService.NewOperation1ReturnStatusDTO;
import com.digitalml.rest.resources.codegentest.service.LabelServiceService.NewOperation1ReturnDTO;
import com.digitalml.rest.resources.codegentest.service.LabelServiceService.NewOperation1InputParametersDTO;
	
import com.digitalml.rest.resources.codegentest.*;
	
	/**
	 * Service: LabelService
	 * 120
	 *
	 * @author admin
	 * @version 1
	 *
	 */
	

	@Path("/")
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public class LabelServiceResource {
		
	private static final Logger LOGGER = LoggerFactory.getLogger(LabelServiceResource.class);
	
	@Context
	private SecurityContext securityContext;

	@Context
	private javax.ws.rs.core.Request request;

	@Context
	private HttpServletRequest httpRequest;

	private LabelServiceService delegateService;

	private String implementationClass = "com.digitalml.rest.resources.codegentest.service.LabelService.LabelServiceServiceDefaultImpl";

	public void setImplementationClass(String className) {
		implementationClass = className;
	}

	public void setImplementationClass(Class clazz) {
		if (clazz == null)
			throw new IllegalArgumentException("Parameter clazz cannot be null");

		implementationClass = clazz.getName();
	}
		
	private LabelServiceService getCurrentImplementation() {

		Object object = null;
		try {
			Class c = Class.forName(implementationClass, true, Thread.currentThread().getContextClassLoader());
			object = c.newInstance();

		} catch (ClassNotFoundException exc) {
			LOGGER.error(implementationClass + " not found");
			return null;

		} catch (IllegalAccessException exc) {
			LOGGER.error("Cannot access " + implementationClass);
			return null;

		} catch (InstantiationException exc) {
			LOGGER.error("Cannot instantiate " + implementationClass);
			return null;
		}

		if (!(object instanceof LabelServiceService)) {
			LOGGER.error(implementationClass + " is not an instance of " + LabelServiceService.class.getName());
			return null;
		}

		return (LabelServiceService)object;
	}
	
	{
		delegateService = getCurrentImplementation();
	}
	
	public void setSecurityContext(SecurityContext securityContext) {
		this.securityContext = securityContext;
	}


	/**
	Method: _NewOperation_1

	Non-functional requirements:
	*/
	
	@GET
	public javax.ws.rs.core.Response _NewOperation_1(
		@QueryParam("LabelRequest")@NotEmpty String LabelRequest) {

		NewOperation1InputParametersDTO inputs = new LabelServiceService.NewOperation1InputParametersDTO();
		// Prepare and check all input parameters

		inputs.setLabelRequest(LabelRequest);
	
		try {
			NewOperation1ReturnDTO returnValue = delegateService._NewOperation_1(securityContext, inputs);

			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

			javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.ok(mapper.writeValueAsString(returnValue));
			return builder.build();
			

		} catch (IllegalArgumentException e) {

			javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(417).entity(e.getMessage());
			return builder.build();

		} catch (AccessControlException e) {

			javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(304).entity(e.getMessage());
			return builder.build();
		} catch (JsonProcessingException e) {
			javax.ws.rs.core.Response.ResponseBuilder builder = javax.ws.rs.core.Response.status(500).entity(e.getMessage());
			return builder.build();
		} finally {
		}
	}
	

}