package com.chars.muguildbusiness.config;


import com.chars.muguildbusiness.dto.LoginRequest;
import com.fasterxml.classmate.TypeResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class SwaggerLoginListingScanner implements ApiListingScannerPlugin {
	
	// tag::api-listing-plugin[]
	private final CachingOperationNameGenerator operationNames;

    /**
     * @param operationNames - CachingOperationNameGenerator is a component bean
     *                       that is available to be autowired
     */
    public SwaggerLoginListingScanner(CachingOperationNameGenerator operationNames) {//<9>
        this.operationNames = operationNames;
    }

	@Override
	public List<ApiDescription> apply(DocumentationContext context) {
		Set<String> tags = new HashSet<String>();
		tags.add("login-controller");
		return new ArrayList<>(
                Arrays.asList(
                        new ApiDescription(null, "/api/auth/login", "login", Collections.singletonList(
                                new OperationBuilder(operationNames)
                                        .summary("login")
                                        .tags(tags)
                                        .authorizations(new ArrayList<>())
                                        .position(1)
                                        .codegenMethodNameStem("loginPost")
                                        .method(HttpMethod.POST)
                                        .notes("This is a login method")
                                        .parameters(
                                                Arrays.asList(
                                                        new ParameterBuilder()
                                                                .description("loginRequest")
                                                                .type(new TypeResolver().resolve(LoginRequest.class))
                                                                .name("loginRequest")
                                                                .parameterType("body")
                                                                .parameterAccess("access")
                                                                .required(true)
                                                                .modelRef(new ModelRef("LoginRequest"))
                                                                .build()
                                                )
                                        ).responseMessages(responseMessages())
                                        .build()
                        ), false)));
	}
	
	/**
     * @return Set of response messages that overide the default/global response messages
     */
	private Set<ResponseMessage> responseMessages() {
		Set<ResponseMessage> responseMessages = new HashSet<ResponseMessage>();
		responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("OK")
                .responseModel(new ModelRef("AuthenticationResponse"))
                .build());
		responseMessages.add(new ResponseMessageBuilder()
                .code(401)
                .message("Unauthorized")
                .build());
		responseMessages.add(new ResponseMessageBuilder()
                .code(403)
                .message("Forbidden")
                .build());
		responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("Not Found")
                .build());

		return responseMessages;
	}

	// tag::api-listing-plugin[]
	@Override
	public boolean supports(DocumentationType delimiter) {
		return DocumentationType.SWAGGER_2.equals(delimiter);
	}

}
