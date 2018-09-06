package pack1.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtilConfig 
{
	@Autowired
	private  EntityManagerFactory  managerFactory;
	
	@Bean
	public   SessionFactory   getSessionFactory()
	{
		SessionFactory  factory=managerFactory.unwrap(SessionFactory.class);
		return  factory;
	}
}
