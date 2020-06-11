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

public class PantallaJuego implements Screen{

    public static final float WIDTH = 480.0f;
    public static final float HEIGH = 360.0f;

    SpriteBatch batch;

    Texture  titulo;
    int contadorBaldoza=0;
    boolean cambiadorBaldoza=true;



Music music= Gdx.audio.newMusic(Gdx.files.internal("Defense Line.mp3"));
    Game game;
    Rectangle rectangle2;
    ShapeRenderer renderer;
BitmapFont tiempo, puntaje;
int segundos=50;
int puntos=0;
    long startTime = 0;

    BitmapFont font;
    Felix felix;
    Piso piso;
    Cabecera cabecera;
    Provision provision;

    Enemigo enemigo1, enemigo2, enemigo3,enemigo4;
    Provision provision1,provision2,provision3,provision4;
boolean vivo = true;
    OrthographicCamera camera;
    Viewport viewport;
    float randomx,randomy;



    public PantallaJuego(Game game) {this.game=game;}

    @Override
    public void show() {
        music.play();
        //camera = new OrthographicCamera();
        viewport = new StretchViewport(WIDTH,HEIGH);
        rectangle2 = new Rectangle(100,100,50,50);

        renderer = new ShapeRenderer();
        font = new BitmapFont();
        font.getData().setScale(2);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        batch = new SpriteBatch();
        startTime = TimeUtils.millis();
        tiempo = new BitmapFont();
        tiempo.getData().setScale(2);
        tiempo.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        puntaje = new BitmapFont();
        puntaje.getData().setScale(2);
        puntaje.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        piso = new Piso(viewport);
        felix = new Felix(viewport);
        felix.setState(true);
        felix.setVidas(3);
        cabecera = new Cabecera(viewport);
cabecera.felix=felix;




        enemigo1 = new Enemigo(viewport,1);
        enemigo2= new Enemigo(viewport,2);
        enemigo3= new Enemigo(viewport,3);
        enemigo4= new Enemigo(viewport,4);
        enemigo1.setPantalla(this);
        enemigo2.setPantalla(this);
        enemigo3.setPantalla(this);
        enemigo4.setPantalla(this);
        provision1 = new Provision(viewport,1);
        provision2= new Provision(viewport,2);
        provision3= new Provision(viewport,3);
        provision4= new Provision(viewport,4);
        provision1.setPantalla(this);
        provision2.setPantalla(this);
        provision3.setPantalla(this);
        provision4.setPantalla(this);
     //puntuacion    xd= "nada";
       // Gdx.input.setInputProcessor(felix);



    }



    @Override
    public void render (float delta) {

        viewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        batch.setProjectionMatrix(viewport.getCamera().combined);


        if (TimeUtils.timeSinceMillis(startTime) > 1000) {
            startTime = TimeUtils.millis();
            segundos--;
        }


        piso.render(delta);


        /**COMPROBADOR CONTACTO ENTRE ENEMIGOS RECONTRA RUDIMENTARIO WTF **/
          randomx = Math.round((Math.random() * ((350 - 90) + 1)) + 90);
        enemigo1.render(delta, randomx);
        randomx = Math.round((Math.random() * ((350 - 90) + 1)) + 90);
        enemigo2.render(delta, randomx);

        if (enemigo1.rectangle.overlaps(enemigo2.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            enemigo1.posicion.x= randomx;
        }

        randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
        enemigo3.render(delta, randomx);

        if (enemigo2.rectangle.overlaps(enemigo3.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            enemigo2.posicion.x= randomx;
        }

        if (enemigo1.rectangle.overlaps(enemigo3.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            enemigo1.posicion.x= randomx;
        }
        enemigo4.render(delta, randomx);
        if (enemigo1.rectangle.overlaps(enemigo4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            enemigo1.posicion.x= randomx;
        }


        /**COMPROBADOR CONTACTO ENTRE provisiones RECONTRA RUDIMENTARIO WTF **/
        randomx = Math.round((Math.random() * ((350 - 90) + 1)) + 90);
        provision1.render(delta, randomx);
        randomx = Math.round((Math.random() * ((350 - 90) + 1)) + 90);
        provision2.render(delta, randomx);

        if (provision1.rectangle.overlaps(provision2.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision1.posicion.x= randomx;
        }

        randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
        provision3.render(delta, randomx);

        if (provision2.rectangle.overlaps(provision3.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision2.posicion.x= randomx;
        }

        if (provision1.rectangle.overlaps(provision3.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision1.posicion.x= randomx;
        }
        provision4.render(delta, randomx);
        if (provision1.rectangle.overlaps(provision4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision1.posicion.x= randomx;
        }
/**SUPERPOSICION ENEMIGO PROVISION ~~CRINGE~~ **/
        if (provision1.rectangle.overlaps(enemigo1.rectangle)||provision1.rectangle.overlaps(enemigo2.rectangle)||provision1.rectangle.overlaps(enemigo3.rectangle)||provision1.rectangle.overlaps(enemigo4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision1.posicion.x= randomx;
        }
        if (provision2.rectangle.overlaps(enemigo1.rectangle)||provision2.rectangle.overlaps(enemigo2.rectangle)||provision2.rectangle.overlaps(enemigo3.rectangle)||provision2.rectangle.overlaps(enemigo4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision2.posicion.x= randomx;
        }
        if (provision3.rectangle.overlaps(enemigo1.rectangle)||provision3.rectangle.overlaps(enemigo2.rectangle)||provision3.rectangle.overlaps(enemigo3.rectangle)||provision3.rectangle.overlaps(enemigo4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision3.posicion.x= randomx;
        }
        if (provision4.rectangle.overlaps(enemigo1.rectangle)||provision4.rectangle.overlaps(enemigo2.rectangle)||provision4.rectangle.overlaps(enemigo3.rectangle)||provision4.rectangle.overlaps(enemigo4.rectangle)){
            randomx = Math.round((Math.random() * ((350- 90) + 1)) + 90);
            provision4.posicion.x= randomx;
        }
        /**********/

        felix. render(delta);
        cabecera.render(delta);
        batch.begin();
        tiempo.draw(batch,""+ segundos,224,317);
        batch.end();
        batch.begin();
        puntaje.draw(batch,""+ puntos,424,317);
        batch.end();





      /*  batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
/**/
/** DAÑO ENEMIGOS**/
        if(felix.rectangle.overlaps(enemigo1.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
enemigo1.setPosicion(enemigo1.posicion.x,randomy);
            felix.vidas=felix.vidas-1;


        }
        if(felix.rectangle.overlaps(enemigo2.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            enemigo2.setPosicion(enemigo2.posicion.x,randomy);
            felix.vidas=felix.vidas-1;


        }
        if(felix.rectangle.overlaps(enemigo3.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            enemigo3.setPosicion(enemigo3.posicion.x,randomy);
            felix.vidas=felix.vidas-1;


        }
        if(felix.rectangle.overlaps(enemigo4.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            enemigo4.setPosicion(enemigo4.posicion.x,randomy);
            felix.vidas=felix.vidas-1;


        }

/** PUNTOS PROVISIONES **/

        if(felix.rectangle.overlaps(provision1.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            provision1.setPosicion(provision1.posicion.x,randomy);
            puntos+=1;


        }
        if(felix.rectangle.overlaps(provision2.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            provision2.setPosicion(provision2.posicion.x,randomy);
            puntos+=1;


        }
        if(felix.rectangle.overlaps(provision3.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            provision3.setPosicion(provision3.posicion.x,randomy);
            puntos+=1;


        }
        if(felix.rectangle.overlaps(provision4.rectangle)){
            randomy = Math.round((Math.random() * ((800 - 500) + 1)) + 500);
            provision4.setPosicion(provision4.posicion.x,randomy);

            puntos+=1;

        }







        if(segundos==0){
    game.setScreen(new PantallaJuego(game));
    music.dispose();
}
        if(felix.vidas==-1){
                felix.setState(false);

            }


        if(!felix.estado){ //REINICIAR
           // game.setScreen(new PantallaPerdiste(game));
            game.setScreen(new PantallaJuego(game));
            music.dispose();

        }

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
        batch.dispose();
        font.dispose();
        renderer.dispose();
        felix.dispose();
        cabecera.dispose();
        enemigo1.dispose();

        enemigo2.dispose();
        enemigo3.dispose();
        enemigo4.dispose();
        music.dispose();
    }

}
