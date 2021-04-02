package ss6_keThua.BaiTap.MoveablePoint;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public  MoveablePoint(){
        super();
    }
    public void setSpeed( float xSpeed, float ySpeed ){
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }
    public  float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }
    @Override
    public String toString() {
        return "MoveablePoint: XY :" + Arrays.toString(getXY())+"Speed = "+Arrays.toString(getSpeed());
    }
}
