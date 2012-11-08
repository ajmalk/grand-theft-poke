package edu.gatech.CS2340.GrandTheftPoke.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

public class TownTile extends Button{
		private Town myTown;

		public TownTile(Town myTown){
			super(	new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 134, 0, 150, 200)),
					new TextureRegionDrawable(new TextureRegion(GTPoke.getButtonSprite(), 0, 0, 150, 200)));
			this.myTown = myTown;
			
			
			/*Texture confirmButtonSprite = new Texture("images//icons//newball.png");
			ButtonStyle style = new ButtonStyle();
			style.up = new TextureRegionDrawable(new TextureRegion(confirmButtonSprite, 134,
					16, 18, 18));
			style.down = new TextureRegionDrawable(new TextureRegion(confirmButtonSprite,
					134, 64, 18, 18));
			style.disabled = new TextureRegionDrawable(new TextureRegion(
					confirmButtonSprite, 134, 115, 18, 18));*/
			
		}
		
		public TownTile(Town myTown, ButtonStyle myStyle){
			super(myStyle);
			this.myTown = myTown;
			
			
			/*Texture confirmButtonSprite = new Texture("images//icons//newball.png");
			ButtonStyle style = new ButtonStyle();
			style.up = new TextureRegionDrawable(new TextureRegion(confirmButtonSprite, 134,
					16, 18, 18));
			style.down = new TextureRegionDrawable(new TextureRegion(confirmButtonSprite,
					134, 64, 18, 18));
			style.disabled = new TextureRegionDrawable(new TextureRegion(
					confirmButtonSprite, 134, 115, 18, 18));*/
			
		}

		public Town getTown() {
			return myTown;
		}
}
