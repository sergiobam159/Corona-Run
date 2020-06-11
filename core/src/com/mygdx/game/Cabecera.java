package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Cabecera extends InputAdapter {

    Texture img,vida,brillo;
    Rectangle rectangle;
    Vector2 posision, posicionVida1,posicionVida2,posicionVida3;
    ShapeRenderer renderer;
    SpriteBatch batch;
    Viewport viewport;
Felix felix;

    public Cabecera(Viewport viewport) {
        this.viewport = viewport;
        img = new Texture("CORONA-RUN-chato.png");
vida = new Texture("papelpequeño.png");
brillo = new Texture("glow.png");
posicionVida1= new Vector2(20,295);
        posicionVida2= new Vector2(52,295);
        posicionVida3= new Vector2(84,295);
        posision = new Vector2(20, 320);
      //  rectangle = new Rectangle(posision.x, posision.y, img.getWidth(), img.getHeight());
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
    }

    public void render(float delta) {

        batch.setProjectionMatrix(viewport.getCamera().combined);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        switch (felix.vidas){
            case 0:
                break;
            case 1:
                batch.begin();
                batch.draw(brillo,posicionVida1.x+5,posicionVida1.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida1.x,posicionVida1.y);
                batch.end();
                break;
            case 2:
                batch.begin();
                batch.draw(brillo,posicionVida1.x+5,posicionVida1.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida1.x,posicionVida1.y);
                batch.end();
                //2
                batch.begin();
                batch.draw(brillo,posicionVida2.x+5,posicionVida2.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida2.x,posicionVida2.y);
                batch.end();
                break;
            case 3:
                //1
                batch.begin();
                batch.draw(brillo,posicionVida1.x+5,posicionVida1.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida1.x,posicionVida1.y);
                batch.end();
                //2
                batch.begin();
                batch.draw(brillo,posicionVida2.x+5,posicionVida2.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida2.x,posicionVida2.y);
                batch.end();
                //3
                batch.begin();
                batch.draw(brillo,posicionVida3.x+5,posicionVida3.y-3);
                batch.end();

                batch.begin();
                batch.draw(vida,posicionVida3.x,posicionVida3.y);
                batch.end();
                break;
        }


//TT
        batch.begin();
        batch.draw(img, posision.x, posision.y);
        batch.end();


    }

    public void dispose(){
        img.dispose();
        batch.dispose();
        renderer.dispose();
        vida.dispose();
    }

}
