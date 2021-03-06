package com.association.controller.servlets;

import com.association.controller.services.ServiceLogin;
import com.core.Tools;
import com.model.bean.Adherent;
import com.model.bean.Pays;
import com.model.persistence.PersistenceServiceProvider;
import com.model.persistence.services.AdherentPersistence;
import com.model.persistence.services.PaysPersistence;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * Servlet implementation class SignUp
 */
@WebServlet(urlPatterns={"/SignUp","/SignUp/*"})
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ServletContext context;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		request.setAttribute("paysAll", getAllPays());
		RequestDispatcher rd =null;
		rd = context.getRequestDispatcher("/WEB-INF/CreationCompte.jsp");
		rd.include(request, response);
	}

	/**
	 * validation de l'enregistrement d'un utilisateur
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdherentPersistence serviceAdh = PersistenceServiceProvider.getService(AdherentPersistence.class);
		PaysPersistence servicePays= PersistenceServiceProvider.getService(PaysPersistence.class);
		Adherent adherent = new Adherent();
		String nom = null;
		String password = null;
		String passwordConfirm = null;
		String prenom = null;
		String adresse = null;
		String codePostal = null;
		String ville = null;
		String login = null;
		com.model.bean.Pays pays = null;
		Enumeration<String> parameters = request.getParameterNames();

		//on reccupère touts les parametres
		while(parameters.hasMoreElements()){
			String param = parameters.nextElement();
			switch (param) {
			case "nom":
				nom = request.getParameter("nom");
				break;
			case "prenom":
				prenom = request.getParameter("prenom");
				break;
			case "codePostal":
				codePostal = request.getParameter("codePostal");
				break;
			case "ville":
				ville = request.getParameter("ville");
				break;
			case "login":
				login = request.getParameter("login");
				break;
			case "adresse":
				adresse = request.getParameter("adresse");
				break;
			case "password":
				password = Tools.md5(request.getParameter("password"));
				break;
			case "passwordConfirm":
				passwordConfirm = Tools.md5(request.getParameter("passwordConfirm"));
				break;	
			case "pays":
				try{
					pays = servicePays.load(Integer.parseInt(request.getParameter("pays")));
				}catch (Exception e) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "La page entrée n'est pas valide ");
					return;
				}
				break;
			default:
				//si un paramètre n'est pas bon, l'utilisateur à modifier le formulaire ou n'a pas utilié la page voulu
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "La page entrée n'est pas valide ");
				return;
			}	
		}
		//verification que les paramètres obligatoires sont bien rentrés et que les deux passwords sont les mêmes
		if( login == null || nom == null || prenom == null || password == null || !password.equals(passwordConfirm) ) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "La page entrée n'est pas valide ");
			return;
		}

		ServiceLogin serviceLogin = new ServiceLogin();
		
		//si le login est deja utilise par un autre utilisateur on renvoi le formulaire prérempli
		if(serviceLogin.isExist(login)){
			request.setAttribute("error", "Le login est déjà utilisé par un autre utilisateur");
			request.setAttribute("nom",nom);
			request.setAttribute("prenom",prenom);
			request.setAttribute("adresse",adresse);
			request.setAttribute("ville",ville);
			request.setAttribute("codePostal",codePostal);
			request.setAttribute("paysAll", getAllPays());

            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/CreationCompte.jsp");
			rd.include(request, response);
			return;
		}
		
		//enregistrement de l'utilisateur dans la base
		adherent.setPays(pays);
		adherent.setAdAdresse(adresse);
		adherent.setAdCodepostal(codePostal);
		adherent.setAdLogin(login);
		adherent.setAdNom(nom);
		adherent.setAdPrenom(prenom);
		adherent.setAdVille(ville);
		adherent.setAdPassword(password);
		serviceLogin.insert(adherent);
		
		request.getSession().setAttribute("adherent", adherent);
		response.sendRedirect( request.getContextPath() + "/Accueil" );
	}
	
	/**
	 * 
	 * @return tous les pays de la base de données
	 */
	public List<Pays> getAllPays(){
		PaysPersistence service = PersistenceServiceProvider.getService(PaysPersistence.class);
		return service.loadAll();
	}

}
