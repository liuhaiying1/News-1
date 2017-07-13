package com.news.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.news.dao.VideoDao;
import com.news.model.Video;

@Service
public class VideoService {

	@Resource
	private VideoDao videoDao;

	public void updateVideos() {
		videoDao.clearVideos();
		List<Video> videoList = new ArrayList<Video>();
		ExtractVideo.run(videoList);
		for (Video v : videoList) {
			videoDao.addVideo(v);
		}
		System.out.println("update videoList!");
		
	}

	public List<Video> getVideos() {
		return videoDao.getVideos();
	}
	public Video getVideoByID(int ID){
		return videoDao.getVideoByID(ID);
	}

}
