package edu.gatech.CS2340.GrandTheftPoke.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;

/**
 * The MarketPlaceItems
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class MarketPlaceItemDemo extends AbstractScreen {
	private MarketPlaceItem item = new MarketPlaceItem(500f, 500f);

	private Table table = new Table(game.getSkin());

	private Vector3 touchPos;

	ShapeRenderer renderer;

	@Override
	public String toString() {
		return "MarketPlaceItemDemo";
	}

	/**
	 * @param game
	 *            the game being played
	 */
	public MarketPlaceItemDemo(GTPoke game) {
		super(game);
		renderer = new ShapeRenderer();
	}

	@Override
	public void show() {
		super.show();
		table.debug();
		touchPos = new Vector3();
	}

	/**
	 * draws curves to screen
	 */
	public void drawcurves() {
		renderer.begin(ShapeType.Line);
		renderer.setColor(Color.BLACK);
		for (int i = 0; i < 1000; i++) {
			renderer.line(i - 1, item.consumption(i - 1), i,
					item.consumption(i));
			renderer.line(i - 1, item.production(i - 1), i, item.production(i));
		}
		renderer.line(item.getPrice(), 0, item.getPrice(), 1000);
		renderer.end();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			item = new MarketPlaceItem((float) Gdx.input.getX(),
					(float) Gdx.graphics.getHeight() - Gdx.input.getY());
			System.out.println("Stock: " + item.getStock() + " Price: "
					+ item.getPrice());
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			item.sell(20);
			System.out.println("Stock: " + item.getStock() + " Price: "
					+ item.getPrice());
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			item.buy(20);
			System.out.println("Stock: " + item.getStock() + " Price: "
					+ item.getPrice());
		}
		// if(!Gdx.input.isKeyPressed(Keys.RIGHT) &&
		// !Gdx.input.isKeyPressed(Keys.LEFT))
		// item.update();
		drawcurves();
		// item.drawcurves();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
