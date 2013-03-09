/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http.handlers;

import ganesh.common.response.Message.ErrorMessage;
import ganesh.common.response.Response;
import ganesh.db.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _LoginHandler implements _MyHandler {

	private static final long serialVersionUID = -8789409316228537279L;

	@Override
	public void handle(String target, HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		Thread.currentThread().setName("Ganesh Login Thread");

		Response resp = new Response(response);

		//Bacalhau
		resp.addListItem("grupos", new Usuario());

		resp.setMessage(new ErrorMessage("Usuário/Senha inválido"));
		resp.writeResponse();
	}

}
