package com.example.asteroidsgame;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Asteroid<move_speed> extends AbstractGameElement {
    public   double move_speed;
    public double rotationalMovement;
    public int x;
    public int y;
    public double size;

    public Asteroid(int x, int y, double s,double l) {

        super(new Polygon(s, 0.0, s * Math.cos(Math.PI * 2 / 5), -1 * s * Math.sin(Math.PI * 2 / 5),
                        -1 * s * Math.cos(Math.PI / 5), -1 * s * Math.sin(Math.PI * 4 / 5),
                        -1 * s * Math.cos(Math.PI / 5), s * Math.sin(Math.PI * 4 / 5),
                        s * Math.cos(Math.PI * 2 / 5), s * Math.sin(Math.PI * 2 / 5)),
                x, y);
        Random rnd = new Random();
        this.size=s;
        this.move_speed=l;

        super.getCharacter().setRotate(rnd.nextInt(360));
        /* int accelerationAmount = 1 + rnd.nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        } */
        this.rotationalMovement = 0.5 - rnd.nextDouble();
    }
    /* public double get_size(){
        double S = this.size;
        return S;
    } */

    public  void move () {
        double changeX = Math.cos(Math.toRadians(this.getCharacter().getRotate()));
        double changeY = Math.sin(Math.toRadians(this.getCharacter().getRotate()));

        this.getCharacter().setTranslateX(getCharacter().getTranslateX() + changeX*this.move_speed);
        this.getCharacter().setTranslateY(this.getCharacter().getTranslateY() + changeY*this.move_speed);
    }
    public double getSize(){
        return this.size;
    }
    public double Move_speed_up(){
        this.move_speed+=0.3;
        return this.move_speed;
    }

    public boolean collide(AbstractGameElement other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
