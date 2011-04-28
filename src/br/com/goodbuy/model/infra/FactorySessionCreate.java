package br.com.goodbuy.model.infra;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class FactorySessionCreate implements ComponentFactory<SessionFactory> {

	public SessionFactory getInstance() {
		return new Configuration().configure().buildSessionFactory();
	}

}
