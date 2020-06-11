package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

public class MyGdxGame extends Game {

	@Override
	public void create () {


		setScreen(new PantallaJuego(this));
	}


	/*SpriteBatch batch;
	Texture img;
	Texture  baldoza1,baldoza2;
	int contadorBaldoza=0;
	boolean cambiadorBaldoza=true;
	Viewport viewport;
	Felix felix;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	baldoza1 = new Texture("pisoBaldoza1.png");
		baldoza2 = new Texture("pisoBaldoza2.png");
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}*/
}
