package com.adag;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.github.axet.vget.VGet;
import com.github.axet.vget.info.VGetParser;
 import com.github.axet.vget.info.VideoInfo;
import com.github.axet.vget.vhs.YouTubeInfo;
import com.github.axet.vget.vhs.YouTubeParser;
import com.github.axet.vget.vhs.YouTubeParser.VideoDownload;

public class YouTubeGrabber {

	public static VideoInfo videoInfo ; 
	public static List<VideoDownload> getVideoUrl(String url) throws IOException {
		
		VGet v = new VGet(new URL(url));
		videoInfo = v.getVideo();
		
		VGetParser user = v.parser(videoInfo.getWeb()); 
        List<VideoDownload> videos =  ((YouTubeParser) user).extractLinks((YouTubeInfo)videoInfo, new AtomicBoolean(false), new Runnable() {
             public void run() {
            }
        });
        
		return  videos ; 

	}

}
