/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author stahc1596
 */
public class Player {
    
    private float x;
    private float y;
    
    private float elapsed;
    
    private Animation<TextureRegion> run;
    private TextureRegion stand;
    private TextureAtlas atlas;
    
    private float dx;
    private float dy;
    
    private Rectangle bounds;
    
    public Player(float x, float y){
        this.x = x;
        this.y = y;
        
        this.dx = 0;
        this.dy = 0;
        
        this.elapsed = 0;
        this.atlas = new TextureAtlas("packed/player.atlas");
        this.stand = atlas.findRegion("stand");
        run = new Animation(1f/10f, atlas.findRegions("run"));
        
        this.bounds = new Rectangle(x, y, stand.getRegionWidth(), stand.getRegionHeight());
    }
    
    public void update(float deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            this.dx = 3;
            this.elapsed = this.elapsed + deltaTime;
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            this.elapsed = this.elapsed + deltaTime;
            this.dx = -3;
        }else{
            this.dx = 0;
            this.elapsed = 0;
        }
        
        this.x = this.x + this.dx;
        
        this.bounds.setX(this.x);
        this.bounds.setY(this.y);
    }
    
    public void fixCollision(Rectangle block){
        if(bounds.overlaps(block)){
            float width = Math.max(bounds.x, block.x) - Math.min(bounds.x, block.x);
            float height = Math.max(bounds.y, block.y) - Math.min(bounds.y, block.y);
            if(width <= height){
                if(this.x < block.x){
                    this.x = this.x - width;
                }else{
                    this.x = this.x + width;
                }
            }else{
                if(this.y < block.y){
                    this.y = this.y - height;
                }else{
                    this.y = this.y + height;
                }
            }
            bounds.setX(this.x);
            bounds.setY(this.y);
        }
    }
    
    public void render(SpriteBatch batch){
        //Standing
        if(this.dx == 0){
            batch.draw(stand, x, y);
        }else if(this.dx > 0){
            batch.draw(run.getKeyFrame(elapsed, true), x, y);
        }else if(this.dx < 0){
            batch.draw(run.getKeyFrame(elapsed, true), x, y);
        }
    }
}
