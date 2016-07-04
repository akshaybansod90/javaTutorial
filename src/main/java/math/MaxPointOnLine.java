package math;


import java.util.*;

/**
 * Created by Akshay on 6/20/2016.
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointOnLine {
     static class Point2D {
         private int x;
         private int y;
         private int id;

        Point2D() {
            x = 0;
            y = 0;
        }

        Point2D(int a, int b) {
            this.id = (int) Math.abs(Math.random()*10000);
            x = a;
            y = b;
        }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;

             Point2D point2D = (Point2D) o;

             if (x != point2D.x) return false;
             if (y != point2D.y) return false;
             return id == point2D.id;

         }

         @Override
         public int hashCode() {
             int result = x;
             result = 31 * result + y;
             result = 31 * result + id;
             return result;
         }

         public boolean eq(Point2D point2D) {
             if (x != point2D.x) return false;
             return y == point2D.y;
         }
     }

    static class Line {
        double yCoefficient;
        double xCoefficient;
        double constant;

        public Line(double yCoefficient, double xCoefficient, double constant) {
            if (yCoefficient != 0.0) {
                this.yCoefficient = 1;
                this.xCoefficient = xCoefficient / yCoefficient;
                this.constant = constant / yCoefficient;
            } else {
                this.yCoefficient = 0.0;
                this.xCoefficient = 1;
                if (xCoefficient == 0.0) {
                    throw new IllegalArgumentException("Not a line");
                }
                this.constant = constant / xCoefficient;
            }
            if (this.constant == 0.0) {
                this.constant= 0.0;
            }
        }

        public Line(Point2D a, Point2D b) {
            this(b.x - a.x, a.y - b.y,((b.y - a.y) * a.x + (a.x - b.x) * a.y));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            if (Double.compare(line.yCoefficient, yCoefficient) != 0) return false;
            if (Double.compare(line.xCoefficient, xCoefficient) != 0) return false;
            return Double.compare(line.constant, constant) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(yCoefficient);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(xCoefficient);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(constant);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public static int maxPoints(Point2D[] point2Ds) {

        if (point2Ds.length <=2) {
            return point2Ds.length;
        }

        Map<int[],Integer> coordinates = new HashMap();
        for (Point2D point2D : point2Ds) {
            int[] coordinate = new int[]{point2D.x,point2D.y};
            Integer count = coordinates.get(coordinate);
            if (count==null){
                count=0;
            }
            coordinates.put(new int[]{point2D.x,point2D.y},++count);
        }

        if (coordinates.size() == 1) {
            return coordinates.get(new int[]{point2Ds[0].x,point2Ds[0].y});
        }

        Map<Line, Set<Point2D>> lineMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < point2Ds.length; i++) {
            for (int j = i+1; j < point2Ds.length; j++) {
                if (point2Ds[i].eq(point2Ds[j])){
                    continue;
                }
                Line line = new Line(point2Ds[i], point2Ds[j]);
                Set<Point2D> pointsOnMap = lineMap.get(line);
                if (pointsOnMap == null) {
                    pointsOnMap = new HashSet<>();
                }
                pointsOnMap.add(point2Ds[i]);
                pointsOnMap.add(point2Ds[j]);
                lineMap.put(line, pointsOnMap);
                if (max <= pointsOnMap.size()) {
                    max = pointsOnMap.size();
                }
            }
        }
        return max;
    }



}
