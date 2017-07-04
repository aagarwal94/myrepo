package com.adag.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractAllImages {
	
    public static ArrayList<ImageObject> getAllImages(String webUrl) throws Exception {

    	ArrayList<ImageObject> imagesArray = new ArrayList<ImageObject>();
        
    	Document doc = Jsoup.connect(webUrl).get();  
        Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
        
        for (Element image : images) {  
     
        	ImageObject imageObject = new ImageObject(image.attr("src"),image.attr("height"), image.attr("width"), image.attr("alt"));
            System.out.println("src : " + image.attr("src"));  
            System.out.println("height : " + image.attr("height"));  
            System.out.println("width : " + image.attr("width"));  
            System.out.println("alt : " + image.attr("alt"));  
            imagesArray.add(imageObject);
        
        }
        return imagesArray;
    }
    
    
    private static void downloadImage(String url, String imgSrc) throws IOException {
        BufferedImage image = null;
        try {
            if (!(imgSrc.startsWith("http"))) {
                url = url + imgSrc;
            } else {
                url = imgSrc;
            }
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = "C:/Users/Machine2/Desktop/CTE/Java-WebsiteRead/" + imgSrc + "";
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
}
