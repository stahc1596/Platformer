/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platformer;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author stahc1596
 */
public class World {
    private Rectangle[] blocks;
    private ShapeRenderer shape;
    
    public World(){
        blocks = new Rectangle[2];
        blocks[0] = new Rectangle(300, 150, 20, 100);
        blocks[1] = new Rectangle(700, 300, 100, 20);
        shape = new ShapeRenderer();
    }
    
    public void render(){
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i < blocks.length; i++){
            shape.rect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
        }
        shape.end();
    }
    
    public Rectangle[] getBlocks(){
        return blocks;
    }
}
