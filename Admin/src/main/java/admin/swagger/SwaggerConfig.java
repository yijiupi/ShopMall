package admin.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		// assuming the API lives at something like http://myapp/api
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*api.*"); 
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TITLE").description("DESCRIPTION")
				.termsOfServiceUrl("http://terms-of-services.url").license("LICENSE")
				.licenseUrl("http://url-to-license.com").build();
	}

}
