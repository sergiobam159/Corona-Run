package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleSorter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.omg.PortableInterceptor.NON_EXISTENT;

public class Enemigo extends InputAdapter {
    Texture img;
    ShapeRenderer renderer;
    SpriteBatch batch;
    Viewport viewport;
    Rectangle rectangle;
    Vector2 posicion;
    boolean vivo = true;
    float random;
    int tipo;
    PantallaJuego pantalla;


    public Enemigo(Viewport viewport, int tipo) {
        this.viewport = viewport;

        this.tipo = tipo;
        switch (tipo) {
            case 1:
                img = new Texture("murcielago.png");
                break;
            case 2:
                img = new Texture("corona.png");
                break;
            case 3:
                img = new Texture("virusCloud.png");
                break;
            case 4:
                img = new Texture("corona.png");
                break;


        }
        /*
        if(tipo==1) {
            img = new Texture("murcielago.png");
        }else{
            img = new Texture("corona.png");
        }*/

        posicion = new Vector2(Math.round((Math.random() * ((300 - 90) + 1)) + 90), Math.round((Math.random() * ((700 - 400) + 1)) + 400));
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
        rectangle = new Rectangle();

    }

    //variable aleatorio para seleccion de enemigo
    public void render(float delta, float aleatorio) {

        if (posicion.y < -40) {
            posicion.y = Math.round((Math.random() * ((700 - 400) + 1)) + 400);

           posicion.x = aleatorio;
        } else {

            //velocidad del juego

            posicion.y -= (delta *( 180+(6*(50-pantalla.segundos))));
        }

        batch.setProjectionMatrix(viewport.getCamera().combined);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        rectangle = new Rectangle(posicion.x, posicion.y, img.getWidth(), img.getHeight());

        batch.begin();
        batch.draw(img, posicion.x, posicion.y);
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.CLEAR);
        renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        renderer.end();

    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void dispose() {
        img.dispose();
        batch.dispose();
        renderer.dispose();

    }

    public void setPosicion(float x, float y) {

        this.posicion.x = x;
        this.posicion.y = y;

    }


    public void setPantalla(PantallaJuego pantalla) {
        this.pantalla =pantalla;

    }

}








