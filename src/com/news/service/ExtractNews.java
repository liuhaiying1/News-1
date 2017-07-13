package com.news.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.news.model.News;

public class ExtractNews {

	private List<String> urls;
	private WebClient client;

	public ExtractNews() {
		urls = new ArrayList<String>();
		client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setDownloadImages(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setThrowExceptionOnScriptError(false);
		getUrls();
	}

	public News extract(String url) {
		try {
			HtmlPage fpage = client.getPage(url);
			List<DomElement> divs = fpage.getElementsByTagName("div");
			HtmlElement div = null;
			for (DomElement e : divs) {
				if (e.getAttribute("class").equals("news-list")) {
					div = (HtmlElement) e;
					break;
				}
			}
			HtmlElement div2 = div.getElementsByTagName("div").get(1);

			String img = div2.getElementsByTagName("div").get(0).getElementsByTagName("img").get(0).getAttribute("src");
			img = img.replace("//img",
					"http://read.HTML5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://img");

			String title = div2.getElementsByTagName("div").get(0).getElementsByTagName("a").get(0)
					.getAttribute("title");
			String preview = null;

			HtmlPage contentPage = div2.getElementsByTagName("div").get(0).getElementsByTagName("a").get(0).click();
			try {
				preview = div2.getElementsByTagName("div").get(1).getElementsByTagName("div").get(2).asText();
			} catch (Exception e) {

			}

			List<DomElement> divs2 = contentPage.getElementsByTagName("div");

			HtmlElement contentDiv = null;
			HtmlElement infoDiv = null;
			for (DomElement e : divs2) {
				if(e.getAttribute("class").equals("article-info")){
					infoDiv = (HtmlElement)e;
				}
					
				else if (e.getAttribute("class").equals("article-content")) {
					contentDiv = (HtmlElement) e;
					break;
				}
			}

			Iterable<HtmlElement> ps = contentDiv.getElementsByTagName("p");
			List<String> pss = new ArrayList<String>();
			for (HtmlElement p : ps) {
				if(p.asText().contains("界面新闻"))
					continue;
				if(p.asXml().contains("player.html"))
					continue;
				pss.add(p.asXml().replaceAll("//img",
						"http://read.HTML5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://img"));

			}
			String keyword = contentPage.getElementByName("keywords").getAttribute("content");
			String[] keywords = keyword.split(",");
			List<String> keys = Arrays.asList(keywords);
			
			String author="";
			String date="";
			if(infoDiv!=null){
				author = infoDiv.getElementsByAttribute("span","class","author").get(0).asText();
				date = infoDiv.getElementsByAttribute("span","class","date").get(0).asText();
			}
			
			News news = new News(img, title, preview, pss.toString(), keys.toString(), author.replaceAll("·", ""), date);
			return news;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void run(List<News> newsList) {
		ExtractNews e = new ExtractNews();
		for (String s : e.urls) {
			News news = e.extract(s);
			newsList.add(news);
		}
	}
	
	
	private void getUrls() {
		try {
			HtmlPage page = client.getPage("http://www.jiemian.com/");
			List<DomElement> elements = page.getElementsByTagName("ul");
			List<HtmlElement> lis = elements.get(0).getElementsByTagName("li");
			HtmlElement shuju = lis.get(14);
			lis = lis.subList(1, 12);
			List<HtmlElement> lis2 = elements.get(5).getElementsByTagName("li");
			List<HtmlElement> lis3 = lis2.subList(0, 9);
			List<HtmlElement> lis4 = lis2.subList(10, 15);
			List<HtmlElement> list = new ArrayList<HtmlElement>();

			list.addAll(lis);
			list.add(shuju);
			list.addAll(lis3);
			list.addAll(lis4);

			for (HtmlElement e : list) {
				String url = e.getElementsByTagName("div").get(0).getElementsByTagName("a").get(0).getAttribute("href");
				urls.add(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ExtractNews e = new ExtractNews();
		e.extract("http://www.jiemian.com/lists/105.html");
	}

}
