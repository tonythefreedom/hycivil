package org.artoolkitx.arx.arsquaretracking;

import android.os.Parcel;
import android.os.Parcelable;

public class Point3d implements Parcelable {
    public double x;
    public double y;
    public double z;

    public Point3d(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;

    }
    public Point3d(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    protected Point3d(Parcel in) {
        x = in.readDouble();
        y = in.readDouble();
        z = in.readDouble();
    }

    public static final Creator<Point3d> CREATOR = new Creator<Point3d>() {
        @Override
        public Point3d createFromParcel(Parcel in) {
            return new Point3d(in);
        }

        @Override
        public Point3d[] newArray(int size) {
            return new Point3d[size];
        }
    };

    public double distance(Point3d dest)
    {
        double diff_square_sum = (this.x - dest.x) * (this.x - dest.x) * (this.x - dest.x);
        diff_square_sum = Math.sqrt(diff_square_sum);
        if (Double.isNaN(diff_square_sum))
        {
            diff_square_sum = 0.0;
        }
        return diff_square_sum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(x);
        parcel.writeDouble(y);
        parcel.writeDouble(z);
    }
}
