package com.decisivestudious.incessant.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.decisivestudious.incessant.Incessant;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL30 = false;
		config.height = 1080;
		config.width = 1920;
		config.fullscreen = true;
		new LwjglApplication(new Incessant(), config);
	}
}
