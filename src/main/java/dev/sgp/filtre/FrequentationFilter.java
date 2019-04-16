package dev.sgp.filtre;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiterWebService;

public class FrequentationFilter implements Filter {

	private FilterConfig config = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.config = filterConfig;
		config.getServletContext().log("FrequentationFilter initialized");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();
		config.getServletContext().log(path + " : " + (after - before));
		VisiteWeb v = new VisiteWeb();
		v.setChemain(path);
		v.setTempsExecution((int) (after - before));
		v.setId(Integer.parseInt(UUID.randomUUID().toString()));
		VisiterWebService.sauvegarderVisite(v);
		
	}

	@Override
	public void destroy() {
		
		
	}

	
	
}
