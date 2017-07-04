package com.adag.image;

public class ImageObject {

	private String imageSrc;
	private String height;
	private String width;
	private String alt;

	public ImageObject(String imageSrc, String height, String width, String alt) {
		super();
		this.imageSrc = imageSrc;
		this.height = height;
		this.width = width;
		this.alt = alt;
	}
	
	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		imageSrc = imageSrc;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@Override
	public String toString() {
		return "ImageObject [imageSrc=" + imageSrc + ", height=" + height
				+ ", width=" + width + ", alt=" + alt + "]";
	}

	
}
