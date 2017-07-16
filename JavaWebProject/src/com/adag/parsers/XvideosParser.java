package com.adag.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Predicate;

public class XvideosParser {

	public static List<String> filterUrlFromXvideos(String args) throws IOException {

		String[] videoFormat = { "flv", "3gp", "mp4", "webm" };
		Document doc = Jsoup.connect(args).get();
		List<String> validlinks = new ArrayList<String>();
		
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			if (stringContainsItemFromList(link.attr("href"), videoFormat)) {
				validlinks.add(link.attr("href"));	
		  }
		}
		return validlinks;
	}

	public static boolean stringContainsItemFromList(String inputStr,String[] videoFormat) 
	{
		for (String format : videoFormat) {
			if (inputStr.toLowerCase().contains(format))
				return true;
		}
		return false;
	}

}