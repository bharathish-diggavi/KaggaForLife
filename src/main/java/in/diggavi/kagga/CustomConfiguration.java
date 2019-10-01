package in.diggavi.kagga;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CustomConfiguration {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("in.diggavi.kagga.controller.api")).build()
				.apiInfo(getApiInfo());
	}

	public ApiInfo getApiInfo() {
		@SuppressWarnings("rawtypes")
		Collection<VendorExtension> list = new ArrayList<>();

		return new ApiInfo("Manku Timmana Kagga APIs",
				"These are the APIs where we can get details of Mankutimmana Kagga", "0.1", "",
				new Contact("Bharathish", "https://diggavi.in/", "bharathish.diggavi@gmail.com"), "", "", list);
	}
}
