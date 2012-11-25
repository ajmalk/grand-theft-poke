package edu.gatech.CS2340.GrandTheftPoke.client;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(1024, 768);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new GTPoke();
	}
}