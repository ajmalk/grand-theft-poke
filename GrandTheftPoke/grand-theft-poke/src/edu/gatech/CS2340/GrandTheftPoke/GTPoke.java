package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.TownFactoryImplementation;
import edu.gatech.CS2340.GrandTheftPoke.screens.*;

public class GTPoke extends Game {
	GlobalItemReference items;
	
    @Override
    public void create(){
    	items = new GlobalItemReference();
        setScreen(getSplashScreen());
    }

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	
	public Screen getSplashScreen(){
        return new SplashScreen( this );
    }
	
	public Screen getMainMenuScreen(){
        return new MainMenu(this);
    }
	
	public Screen getNameScreen(){
        return new Name(this);
    }
	
	public Screen getMarketPlaceDemoScreen(){
        return new MarketPlaceItemDemo(this);
    }
	
	public Screen getSkillPointsScreen(){
        return new SkillPoints(this);
    }
	
	public Screen getStarterPokemonScreen(){
        return new StarterPokemon(this);
    }
	
	public Screen getMarketScreen(){
        return new Market(this);
    }
	
	public Town getCurrentTown(){
        return new TownFactoryImplementation(items).makePalletTown();
    }
}
