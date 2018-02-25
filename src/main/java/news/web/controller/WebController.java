package news.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import news.comm.model.Article;
import news.comm.model.Slide;
import news.comm.service.DataServiceI;

@Controller
public class WebController {

	@Autowired
	DataServiceI dataService;

	@RequestMapping(value = { "/", "/index.html" }, method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		List<Slide> slides = dataService.getHome();
		model.put("slides", slides);
		return "index";
	}

	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article(@RequestParam("id") int id, Map<String, Object> model) {
		Article a = dataService.getArticle(id);
		if (a != null) {
			model.put("title", a.getTitle());
			model.put("url", a.getUrl());
			model.put("urlTex", a.getUrlText());
			model.put("content", a.getContent());
			return "article";
		} else {
			model.put("status", "500");
			model.put("error", "not found");
			return "error";
		}
	}
}
