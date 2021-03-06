package com.association.controller.servlets;

import com.association.controller.services.ServiceArticle;
import com.model.bean.Article;
import com.model.persistence.PersistenceServiceProvider;
import com.model.persistence.services.ArticlePersistence;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = { "/List", "/List/*" })
public class ListArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ServletContext context;
	
	private ServiceArticle serviceAr;
	public ListArticle() {
		super();
		serviceAr = new ServiceArticle();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		//si il y a une demande d'ajout d article dans le panier
		if (articleAjoute(request)) {
			int id = Integer.parseInt(request.getParameter("article"));
			Article article = serviceAr.load(id);
			
			//si l'article n'est pas trouvé on renvoi une page erreur
			if (article == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND,
						"La page entrée n'est pas valide ");
				return;
			//on ajoute l article au panier
			} else {
				HttpSession session = request.getSession();
				ArrayList<Article> articles = (ArrayList<Article>) session
						.getAttribute("orderInProcess");

				if (articles == null) {
					articles = new ArrayList<>();
					session.setAttribute("orderInProcess", articles);
				}

				articles.add(article);
				request.setAttribute("added", id);
			}
		}

		List<Article> articles = serviceAr.loadAll();
		RequestDispatcher rd;
		request.setAttribute("articles", articles);
		rd = context.getRequestDispatcher("/WEB-INF/Articles.jsp");
		rd.include(request, response);

	}

	private boolean articleAjoute(HttpServletRequest request) {
		return request.getParameter("article") != null;
	}
}
