package com.news.dao;

import java.util.List;
import com.news.model.Video;

public interface VideoDao {
	
	public void addVideo(Video video);
	public List<Video> getVideos();
	public Video getVideoByID(int ID);
	public void clearVideos();
}	
