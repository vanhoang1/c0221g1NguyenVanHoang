package ss6_keThua.BaiTap.LopPoint2D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z=0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Point3D(float i, float j, float z) {
        super(i, j);
        this.z = z;
    }

    public Point3D() {

    }
    public void setXYZ(float x, float y, float z){
        setX(x);
        setY(y);
        setZ(z);
    }
    public float[] getXYZ(){
        return new float[]{getX(),getY(),z};
    }

    @Override
    public String toString() {
        return "XYZ là :" + Arrays.toString(getXYZ());
    }
}
