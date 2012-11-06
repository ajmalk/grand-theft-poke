package edu.gatech.CS2340.GrandTheftPoke;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import edu.gatech.CS2340.GrandTheftPoke.screens.*;

public class GTPoke extends Game {

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
	
    @Override
    public void create(){
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
}
