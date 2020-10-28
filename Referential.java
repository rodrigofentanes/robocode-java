package df;

public class Referential {

    private static double x;
    private static double y;
    private static double width;
    private static double height;

    public static String whereAmI(double x, double y, double width, double height){
        Referential.x = x;
        Referential.y = y;
        Referential.width = width;
        Referential.height = height;

        String position = "middle";
        int borderLimit = 80;
        if (x<=borderLimit){
            position = "left";
        }
        if ((width-x)<=borderLimit){
            position = "right";
        }
        if (y<=borderLimit){
            position = "bottom";
        }
        if ((height-y)<=borderLimit){
            position = "top";
        }
        return position;
    }

    public static String whatIsMyZone(double x, double y, double width, double height){
        Referential.x = x;
        Referential.y = y;
        Referential.width = width;
        Referential.height = height;

        String position = "green";
        int borderLimit = 10;
        if (x<=borderLimit || y<=borderLimit){
            position = "red";
        }
        if ((height-y)<=borderLimit || x<=borderLimit){
            position = "red";
        }
        if ((width-x)<=borderLimit || (height-y)<=borderLimit){
            position = "red";
        }
        if (y<=borderLimit || (width-x)<=borderLimit){
            position = "red";
        }
        return position;
    }
}

