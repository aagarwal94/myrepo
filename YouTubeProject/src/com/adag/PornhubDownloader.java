package com.adag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class PornhubDownloader {

	public static void main(String[] args) throws ClientProtocolException,IOException 
	{
		// Connecting to the url
		
		String downloadUrl = "https://xhamster.com/movies/4004507/bollywood_blowjob_from_indian_brunette_milf_lady.html";
		String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13";
		File outputfile = new File("F:\\Download\\xvideo.flv");

		HttpGet httpget2 = new HttpGet(downloadUrl);
		httpget2.setHeader("User-Agent", userAgent);
		String encoding = "UTF-8";

		// Creating a client to connect to the url
		
		HttpClient httpclient2 = new DefaultHttpClient();
		HttpResponse response2 = httpclient2.execute(httpget2);
		HttpEntity entity2 = response2.getEntity();
		InputStream instream2 = null;
		String str = null;
		String wholething = null;

		if (entity2 != null && response2.getStatusLine().getStatusCode() == 200) {
			long length = entity2.getContentLength();
			instream2 = entity2.getContent();

			str = getStringFromInputStream(instream2);
			
			System.out.println("String" + str);

			String regex = "video(.*?)src=(.*?)\"";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			int index = 0;

			while (matcher.find(index)) {
				wholething = matcher.group();
				index = matcher.end();
			}
		}
		System.out.println("String" + wholething);

    	wholething = wholething.replace("flv_url=", "");
		wholething = wholething.replace("&amp;", "");

		// Decoding the input stream
		String url = URLDecoder.decode(wholething);
		System.out.println("String" + wholething);

		// Saving the file in my local
		System.out.println("Starting the file download ... " );
		savingFileFromOutputStream(url,outputfile);
		System.out.println("Starting the file complete ... " );
	}

	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	private static void savingFileFromOutputStream(String url, File outputfile)
			throws IOException {

		URL Uri = new URL(url);
		if (outputfile.exists()) {
			outputfile.delete();
		}

		FileOutputStream outstream = new FileOutputStream(outputfile);
		InputStream is = Uri.openStream();
		byte[] buffer = new byte[2048];
		int count = -1;
		while ((count = is.read(buffer)) != -1) {
			outstream.write(buffer, 0, count);
		}
		outstream.flush();

	}
}