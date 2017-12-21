/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author stahc1596
 */
public class MainGame implements Screen{

    private MyGdxGame game;
    private Player p1;
    private World world;
    
    public MainGame(MyGdxGame game){
        this.game = game;
        p1 = new Player(100, 100);
        world = new World();
    }
    
    @Override
    public void show() {
        
    }

    @Override
    public void render(float deltaTime) {
        //Update player
        p1.update(deltaTime);
        
        for(Rectangle block: world.getBlocks());
        SpriteBatch batch = game.getBatch();
        //Draw player
        Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
        world.render();
        
        batch.begin();
        p1.render(batch);
	batch.end();
    }

    @Override
    public void resize(int width, int height) {
        
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
