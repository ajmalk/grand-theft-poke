package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {
	public static void main(String[] args) {

		Settings settings = new Settings();
		settings.maxWidth = 4096;
		settings.maxHeight = 4096;
		settings.pot = true;
		// settings.rotation = true;
		TexturePacker2
				.process(
						settings,
						"..//grand-theft-poke-android//assets//images//textures//images//",
						"..//grand-theft-poke-android//assets//images//textures//packed",
						"gtpoke");

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "grand-theft-poke";
		cfg.useGL20 = true;
		cfg.width = 1024;
		cfg.height = 768;
		cfg.resizable = false;

		new LwjglApplication(new GTPoke(), cfg);
	}
}
