package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Piso {
    Texture baldoza1, baldoza2;
    Rectangle rectangle;
    Vector2 posision;
    ShapeRenderer renderer;
    SpriteBatch batch;
    Viewport viewport;
    int contadorBaldoza = 0;
    boolean cambiadorBaldoza = true;

    public Piso(Viewport viewport) {
        this.viewport = viewport;
        baldoza1 = new Texture("baldozaPeque.png");
        baldoza2 = new Texture("baldozaPeque2.png");
        posision = new Vector2(0, 0);
        //  rectangle = new Rectangle(posision.x, posision.y, img.getWidth(), img.getHeight());
        batch = new SpriteBatch();
        renderer = new ShapeRenderer();
    }

    public void render(float delta) {

        batch.setProjectionMatrix(viewport.getCamera().combined);
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        if (cambiadorBaldoza && contadorBaldoza <= 15) {
            batch.begin();
            batch.draw(baldoza1, 0, 0);
            batch.end();
            contadorBaldoza++;
            if (contadorBaldoza == 16) {
                cambiadorBaldoza = !cambiadorBaldoza;
                contadorBaldoza = 0;
            }
        }
        if (!cambiadorBaldoza && contadorBaldoza <= 15) {
            batch.begin();
            batch.draw(baldoza2, 0, 0);
            batch.end();
            contadorBaldoza++;
            if (contadorBaldoza == 16) {
                cambiadorBaldoza = !cambiadorBaldoza;
                contadorBaldoza = 0;
            }

        }

    }

    public void dispose(){
        baldoza2.dispose();
        baldoza1.dispose();
        batch.dispose();
        renderer.dispose();
    }
}
