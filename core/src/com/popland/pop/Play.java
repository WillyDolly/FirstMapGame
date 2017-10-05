package com.popland.pop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by hai on 31/07/2017.
 */

public class Play implements Screen {
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer renderer;
    //IsometricTiledMapRenderer renderer;
    OrthographicCamera camera;
    Player player;
    @Override
    public void show() {
        tiledMap = new TmxMapLoader().load("MapGameDemo.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        //renderer = new IsometricTiledMapRenderer(tiledMap);
        camera = new OrthographicCamera();
        player = new Player(new Sprite(new Texture("tank.jpg")));
    }

    @Override
    public void render(float delta) {//need background color - camera.viewport -> 1 stable map
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setView(camera);
        renderer.render();

        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        renderer.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        //show orginal map
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
         dispose();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }
}
