/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.embed.http;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.rewrite.handler.Rule;

public class HttpRewriteRule extends Rule {

	@Override
	public String matchAndApply(String target, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("target", target);

		if (target.equals("/") || target.startsWith("/info"))
			return "/info";

		if (target.startsWith("/debug"))
			return "/debug";

		if (target.startsWith("/program") || target.startsWith("/login") || target.equals("/404/img"))
			return target;

		return "/404";
	}
}
