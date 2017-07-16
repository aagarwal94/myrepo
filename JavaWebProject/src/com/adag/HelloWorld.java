package com.adag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.axet.vget.vhs.YouTubeParser.VideoDownload;
import com.youtube.VideoInfo;

public class HelloWorld extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String urlString = request.getParameter("xvideosurl");
		String videoUrl = null;
		RequestDispatcher rd = null;

		if (urlString != null && urlString.length() > 0) {
			videoUrl = XvideosDownloader.getVideoUrl(urlString);
			rd = request.getRequestDispatcher("download.jsp");
			request.setAttribute("videoUrl", videoUrl);
			rd.forward(request, response);
		}

		urlString = request.getParameter("youtubeurl");

		if (urlString != null && urlString.length() > 0) {

			String sourceUrl = getServletContext().getRealPath("/");
			List<VideoDownload> videosUrl = YouTubeGrabber
					.getVideoUrl(urlString);
			List<VideoInfo> videoInfos = new ArrayList<VideoInfo>();

			for (VideoDownload videodownload : videosUrl) {
				VideoInfo videoinfo = new VideoInfo(videodownload.stream,
						videodownload.url);
				if (videodownload.stream instanceof com.github.axet.vget.vhs.YouTubeInfo.StreamCombined) {
					videoInfos.add(videoinfo);
				}
			}

			request.setAttribute("videosUrl", videoInfos);
			request.setAttribute("videoName",
					YouTubeGrabber.videoInfo.getTitle());
			request.setAttribute("thumbnail",
					YouTubeGrabber.videoInfo.getIcon());

			rd = request.getRequestDispatcher("downloadYouTube.jsp");
			rd.forward(request, response);

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}