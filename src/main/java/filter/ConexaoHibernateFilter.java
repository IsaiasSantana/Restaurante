package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import restaurante.conexao.HibernateUtil;


/**
 * Intercepta toda requisição para abrir a conexao com o banco de dados,
 * efetuando a transação, commit e o fechamento da conexão.
 * @author alkxly
 *
 */
public class ConexaoHibernateFilter implements Filter{

	private SessionFactory	sf;

	public ConexaoHibernateFilter() {

	}

	@Override
	public void destroy() {
//				System.out.println("Saindo..");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
//			System.out.println("Filtrou entrou");
		try {
			try {

				this.sf.getCurrentSession().beginTransaction();

				chain.doFilter(servletRequest, servletResponse);

				this.sf.getCurrentSession().getTransaction().commit();
				this.sf.getCurrentSession().close();

//						System.out.println("Filtro executado com sucesso");
			} catch (Throwable ex) {
				try {
					if (this.sf.getCurrentSession().getTransaction().isActive()) {
						this.sf.getCurrentSession().getTransaction().rollback();
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
				throw new ServletException(ex);
			}
		} catch (Exception e) {
			this.sf.getCurrentSession().close();    
			this.sf.getCurrentSession().beginTransaction();    
			chain.doFilter(servletRequest, servletResponse);    
			this.sf.getCurrentSession().getTransaction().commit();    
			this.sf.getCurrentSession().close();    
			this.sf.getCurrentSession().beginTransaction();    
			chain.doFilter(servletRequest, servletResponse);    
			this.sf.getCurrentSession().getTransaction().commit();    
			this.sf.getCurrentSession().close();     
		}

	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.sf = HibernateUtil.getSessionfactory();
//		System.out.println("ConexaoHibernateFilter"); 
	}

}
