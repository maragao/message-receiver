package org.zapto.aragao.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zapto.aragao.jms.ReceiverProducer;

@WebServlet(urlPatterns = "/ebroker/*")
public class ReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	protected ReceiverProducer receiverProducer;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		receiverProducer.enviarMensagem("Mensagem do Ebroker: " + request.getParameter("payload"));
	}
}
