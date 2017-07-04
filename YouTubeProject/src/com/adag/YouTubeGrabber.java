package com.adag;

import java.io.File;
import java.net.URL;

import com.github.axet.vget.VGet;
import com.github.axet.vget.info.VideoInfo;


public class YouTubeGrabber {
 
    public static void main(String[] args) {
        try {
            String url = "https://vimeo.com/217601611";
            String path = "F:\\Download\\";
            VGet v = new VGet(new URL(url), new File(path));
            VideoInfo videoInfo =  v.getVideo();
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

