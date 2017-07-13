package com.news.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.news.model.Video;
import com.news.service.VideoService;

@Controller
public class VideoController {
	
	
	private VideoService videoService;
	@Resource
	public void setVideoService(VideoService videoService){
		this.videoService = videoService;
	}
	
	
	@RequestMapping("updateVideos.do")
	public ModelAndView updateNews() {
		System.out.println("updateVideos.do");
		videoService.updateVideos();
		System.out.println("updateVideos complete");
		ModelAndView modelAndView = new ModelAndView("video.do");
		return modelAndView;
	}
	
	@RequestMapping("showVideo.do")
	public void showPage(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("showVideo.do");
		int videoID = Integer.parseInt(req.getParameter("videoID"));
		String video = videoService.getVideoByID(videoID).getContent();
		res.sendRedirect(video);
		System.out.println("showVideo.do complete");
		
	}
	
	
	@RequestMapping("video.do")
	public ModelAndView setNews(HttpServletRequest req)
	{
		System.out.println("video.do");
		Map<String,Object> map=new HashMap<String,Object>(); 
		List<Video> videoList = videoService.getVideos();
		String account = req.getParameter("account");
    	map.put("videoList", videoList); 
    	map.put("account", account);
		return new ModelAndView("video.jsp",map);
	}
}
