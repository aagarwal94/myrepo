package com.youtube;

import java.net.URL;

import com.adag.YouTubeGrabber;
import com.github.axet.vget.vhs.YouTubeInfo.StreamInfo;

public class VideoInfo {
	
    private StreamInfo stream;

    private URL url;
	
    private String filename;
    
  

	@Override
	public String toString() {
		return "VideoInfo [stream=" + stream + ", url=" + url + ", filename="
				+ filename + "]";
	}


	public VideoInfo(StreamInfo stream2, URL url) {
        this.stream = stream2;
        this.setUrl(url);
        this.filename = YouTubeGrabber.videoInfo.getTitle() +"."+firstWord(stream2.toString());
    }
    
	public static String firstWord(String input) {
	    return input.split(" ")[0]; // Create array of words and return the 0th word
	}

   
    public StreamInfo getStream() {
		return stream;
	}

	public void setStream(StreamInfo stream) {
		this.stream = stream;
	}

    public URL getUrl() {
		return url;
	}


	public VideoInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setUrl(URL url) {
		this.url = url;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}
     
}

