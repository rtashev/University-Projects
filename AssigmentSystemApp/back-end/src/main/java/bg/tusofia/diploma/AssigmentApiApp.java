package bg.tusofia.diploma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AssigmentApiApp extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(AssigmentApiApp.class);
	}

	public static void main(String[] args){
		SpringApplication.run(AssigmentApiApp.class, args);
	}
	
//	@Bean  
//	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
//	    return hemf.getSessionFactory();  
//	}   
}
