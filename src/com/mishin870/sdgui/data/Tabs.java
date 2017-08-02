package com.mishin870.sdgui.data;

import java.util.ArrayList;
import java.util.List;

public class Tabs {
	public static List<Tab> tabs = new ArrayList<Tab>();
	
	public static void addTab(String name, String img) {
		Tab tab = new Tab(name, img);
		tabs.add(tab);
	}
	
	public static Tab get(int i) {
		return tabs.get(i);
	}
	
	public static void update(int i, String name, String img) {
		Tab tab = tabs.get(i);
		tab.name = name;
		tab.img = img;
	}
	
	public static void remove(int i) {
		tabs.remove(i);
	}
	
	public static class Tab {
		public String name, img;
		
		public Tab(String name, String img) {
			this.name = name;
			this.img = img;
		}
		
	}
	
}