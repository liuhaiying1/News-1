package com.news.service;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.news.model.Video;

public class ExtractVideo {
	private WebClient client;
	private List<String> urls;
	private List<Video> videoList;

	public ExtractVideo() {
		urls = new ArrayList<String>();
		videoList = new ArrayList<Video>();
		client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setDownloadImages(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);
		client.getOptions().setThrowExceptionOnScriptError(false);
		getUrls();
	}

	public String extract(String url) {

		try {
			HtmlPage page = client.getPage(url);
			HtmlElement div = (HtmlElement) page.getElementById("gddflvplayer");
			String video = div.getElementsByTagName("video").get(0).getAttribute("src");

			return video;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void getUrls() {
		try {
			HtmlPage page = client.getPage("http://www.jiemian.com/video/lists/index_1-pjax.html");

			HtmlElement videoDiv = (HtmlElement) page.getElementById("video");
			List<HtmlElement> elementList = videoDiv.getElementsByAttribute("div", "class", "news-img");

			for (HtmlElement e : elementList) {
				String url = e.getElementsByTagName("a").get(0).getAttribute("href");
				urls.add(url);
				String img = e.getElementsByTagName("img").get(0).getAttribute("src");
				String title = e.getElementsByTagName("img").get(0).getAttribute("alt");
				Video video = new Video();
				video.setImg(img);
				video.setTitle(title);
				videoList.add(video);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void run(List<Video> videoList) {
		ExtractVideo ev = new ExtractVideo();

		for (int i = 0; i < ev.urls.size(); i++) {
			String video = ev.extract(ev.urls.get(i));
			ev.videoList.get(i).setContent(video);
			videoList.add(ev.videoList.get(i));
		}

	}

	public static void main(String args[]) {
		List<Video> list = new ArrayList<Video>();
		ExtractVideo.run(list);
	}

}
