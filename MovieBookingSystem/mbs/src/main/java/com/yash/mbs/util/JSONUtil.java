package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.yash.mbs.domain.Screen;




public class JSONUtil {

	List<Screen> screenList = null;

	public JSONUtil() {
		screenList = new ArrayList<Screen>();
	}

	public int writeScreenToList(Screen screen) {
		screenList.add(screen);
		Gson gson = new GsonBuilder().create();
		try {
			String jsonInString = gson.toJson(screenList);
			FileWriter fw = new FileWriter("src/main/resources/Json/Screen.json");
			fw.write(jsonInString);
			fw.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}

		return screenList.size();
	}

	public List<Screen> readListOfScreen () {
		Gson gson = new GsonBuilder().create();
		FileReader fr;
		try {
			fr = new FileReader("src/main/resources/Json/Screen.json");
			BufferedReader bufferedReader = new BufferedReader(fr);
			String jsonfromString = bufferedReader.readLine();
			if (jsonfromString != null) {
				screenList = gson.fromJson(jsonfromString, new TypeToken<List<Screen>>() {
				}.getType());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenList;

	}

	public boolean updateListOfScreens(List<Screen> screenList){
		Gson gson = new GsonBuilder().create();
		try {
			String jsonInString = gson.toJson(screenList);
			FileWriter fw = new FileWriter("src/main/resources/Json/Screen.json");
			fw.write(jsonInString);
			fw.close();
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	
	public Screen getScreenObject(String screenName) {
		screenList = readListOfScreen();
		Screen requiredScreen = null;
		for (Screen screen : screenList) {
			if (screen.getScreenName().equalsIgnoreCase(screenName)) {
				requiredScreen = screen;
			}
		}
		return requiredScreen;
	}
	
}
