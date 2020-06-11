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
import com.badlogic.gdx.ApplicationListener;

public class Felix extends InputAdapter {

    Texture img, img2;
    Rectangle rectangle;
    Vector2 posision;
    ShapeRenderer renderer;
    SpriteBatch batch;
    Viewport viewport;
    int vidas = 3;
    boolean pasitos = false;
    boolean estado;
    int contadorpasitos;
int puntaje;

    public Felix(Viewport viewport) {
        this.viewport = viewport;
        img = new Texture("pasoDerechoCarritoM.png");
        img2 = new Texture("pasoIzquierdoCarritoM.png");
        posision = new Vector2(150, 0);
        rectangle = new Rectangle(posision.x, posision.y, img.getWidth(), img.getHeight());
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
    }

    public void render(float delta) {
        handleInput(delta);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);
        renderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        renderer.end();
    /*batch.begin();
    batch.draw(img,posision.x,posision.y);
    batch.end();
*/

        if (pasitos && contadorpasitos <= 10) {
            batch.begin();
            batch.draw(img, posision.x, posision.y);
            batch.end();
            contadorpasitos++;
            if (contadorpasitos == 11) {
                pasitos = !pasitos;
                contadorpasitos = 0;
            }
        }
        if (!pasitos && contadorpasitos <= 10) {
            batch.begin();
            batch.draw(img2, posision.x, posision.y);
            batch.end();
            contadorpasitos++;
            if (contadorpasitos == 11) {
                pasitos = !pasitos;
                contadorpasitos = 0;
            }

        }


    }


    public void handleInput(float delta) {
        if (Gdx.input.isTouched()) {
            if (Gdx.input.getX()>viewport.getScreenWidth()/2) {
                if (posision.x <= 350) {
                    posision.x += delta * 360;
                    rectangle.x += delta * 360;

                }
            }
            //izquierda
            if (Gdx.input.getX()<viewport.getScreenWidth()/2) {
                if (posision.x >= 90) {
                    posision.x -= delta * 360;
                    rectangle.x -= delta * 360;
                }
            }


        }
    }

    /*
public void handleInput(float delta) {
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        if (posision.x <= 350) {
            posision.x += delta * 360;
            rectangle.x += delta * 360;

        }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        if (posision.x >= 90) {
            posision.x -= delta * 360;
            rectangle.x -= delta * 360;
        }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
        posision.y += delta * 180;
        rectangle.y += delta * 180;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
        posision.y -= delta * 180;
        rectangle.y -= delta * 180;
    }
}
*/
    public void dispose() {
        img.dispose();
        batch.dispose();
        renderer.dispose();
    }

    public void setState(boolean estado) {
        this.estado = estado;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    public void setPuntaje(int puntos) {this.puntaje=puntos;}


}