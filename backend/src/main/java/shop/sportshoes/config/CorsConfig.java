package shop.sportshoes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    /* Config del CORS (Cross-Origin Resource Sharing) en la App para poder utilizarla con React en el puerto 5173 */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173") // Permitir solo solicitudes desde http://localhost:5173
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                        .allowedHeaders("*"); // Permitir todas las cabeceras
            }

            @Override
            //Ruteo para acceder al directorio de imagenes desde la url del servicio
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/images/**")
                        .addResourceLocations("file:./images/");
            }
        };
    }
}