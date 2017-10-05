package com.popland.pop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import sun.rmi.runtime.Log;


/**
 * Created by hai on 31/07/2017.
 */

public class Player extends Sprite {
    private Vector2 velocity = new Vector2();
    private float speed = 60 * 2, gravity = 60 * 1.8f;

    Player(Sprite sprite){
        super(sprite);
    }

    @Override
    public void draw(Batch batch) {// called over and over again during rendering
        update(Gdx.graphics.getDeltaTime());//time between frame update
        super.draw(batch);
    }

    public void update(float delta){
        // object go down straight at immutable velocity
        velocity.y -= gravity*delta;
        //clamp velocity
        if(velocity.y > speed){
            velocity.y = speed;
        }else if(velocity.y < speed){
            velocity.y = - speed;
        }

        setX(getX() + velocity.x*delta);
        setY(getY() + velocity.y*delta);
    }
}
