package com.mishin870.sdgui.data;

import java.util.ArrayList;
import java.util.List;

public class Chapters {
	public static List<Chapter> chapters = new ArrayList<Chapter>();
	
	public static void addChapter(String name, String img) {
		Chapter chapter = new Chapter(name, img);
		chapters.add(chapter);
	}
	
	public static Chapter get(int i) {
		return chapters.get(i);
	}
	
	public static void update(int i, String name, String img) {
		Chapter chapter = chapters.get(i);
		chapter.name = name;
		chapter.img = img;
	}
	
	public static void remove(int i) {
		chapters.remove(i);
	}
	
	public static class Chapter {
		public String name, img;
		
		public Chapter(String name, String img) {
			this.name = name;
			this.img = img;
		}
		
	}
	
}