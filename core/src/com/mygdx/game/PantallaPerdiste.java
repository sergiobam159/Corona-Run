package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class PantallaPerdiste  implements Screen{

    public static final float WIDTH = 480.0f;
    public static final float HEIGH = 360.0f;
    Game game;
    SpriteBatch batch;
    ShapeRenderer renderer;
    Viewport viewport;
    Rectangle rectangle2;
Texture img;
    public PantallaPerdiste(Game game) {this.game=game;}
    @Override
    public void show() {
        viewport = new StretchViewport(WIDTH,HEIGH);
        rectangle2 = new Rectangle(100,100,50,50);

        renderer = new ShapeRenderer();
        img = new Texture("menuInicial512x768.png");

    }

    @Override
    public void render (float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void dispose() {

    }

}
