package df;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Doofy - a robot by (Carlos Rodrigo Araújo Fentanes)
 */
public class Doofy extends AdvancedRobot
{
    //DOOFY
	double mapWidth;
	double mapHeight;
	int enemyNumber;
	Enemy[] enemyList;
	int countRadar;
	String hereIAm;
	String myZone;
    //DOOFY

    //WALLS
    boolean peek; // Don't turn if there's a robot there
    double moveAmount; // How much to move
    //WALLS

	public void run() {
		//DOOFY
	    // Cores do robo
		setBodyColor(new Color(216, 242, 250));
		setGunColor(new Color(79, 191, 213));
		setRadarColor(new Color(68, 123, 213));
		setBulletColor(Color.cyan);
		setScanColor(Color.red);
		// Definindo limite do mapa.
		mapWidth = getBattleFieldWidth();
		mapHeight = getBattleFieldHeight();
		//Verifica quantidade de inimigos
		enemyNumber = getOthers();
		//instanciando obj Enemy
		enemyList = new Enemy[enemyNumber];
		//inicia countRadar
        countRadar = -1;
        //DOOFY

        //WALLS
        // Initialize moveAmount to the maximum possible for this battlefield.
        moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        // Initialize peek to false
        peek = false;
        //WALLS

		while(true) {
            setTurnRadarRight(3800);
            hereIAm = whereAmI(getX(),getY(), mapWidth, mapHeight);
            if (hereIAm != "middle"){
                wallingBehavior();
            }else {
                spiningBehavior();
            }


		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
        hereIAm = whereAmI(getX(),getY(), mapWidth, mapHeight);
        myZone = whatIsMyZone(getX(),getY(), mapWidth, mapHeight);
        out.print("\n"+getX()+" ------"+getY()+"\n");
        out.println("local: ---- "+hereIAm+"\n");
        out.println("local: ---- "+myZone+"\n");

	    countRadar = enemyArrayPosition(countRadar, enemyNumber);
		fillEnemyArray(enemyList, countRadar, e.getName(), e.getDistance(), e.getEnergy());
	}

	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
            back(100);
            reverseSpiningBehavior();
		} // else he's in back of us, so set ahead a bit.
		else {
			ahead(100);
			reverseSpiningBehavior();
		}
	}

	public void onHitByBullet(HitByBulletEvent event) {
	    reverseSpiningBehavior();
	}

	public void onHitWall(HitWallEvent event) {
	}

	public void onWin(WinEvent e) {
		for (int i = 0; i < 50; i++) {
			turnRight(30);
			turnLeft(30);
		}
	}

	//DOOFY
    public int enemyArrayPosition (int i, int j){
        if(i>=(j-1)){
            i = -1;
        }
        i = (i+1);
        return i;
    }

    public void fillEnemyArray (Enemy[] obj, int i, String name, double distance, double energy){
        obj[i] = new Enemy();
        obj[i].setName(name);
        obj[i].setDistance(distance);
        obj[i].setEnergy(energy);
    }

    public String whereAmI (double x, double y, double width, double height){
	    String position = "middle";
	    int borderLimit = 80;
	    if (x<=borderLimit){
            position = "left";
            out.print(x);
        }
        if ((width-x)<=borderLimit){
            position = "right";
            out.print((width-x));
        }
        if (y<=borderLimit){
            position = "bottom";
            out.print(y);
        }
        if ((height-y)<=borderLimit){
            position = "top";
            out.print((width-y));
        }
        return position;
    }

    public String whatIsMyZone (double x, double y, double width, double height){
        String position = "green";
        int borderLimit = 30;
        out.print("\n"+x+"----"+y+"\n");
        if (x<=borderLimit || y<=100){
            position = "red";
            out.print(x);
        }
        if ((height-y)<=borderLimit || x<=borderLimit){
            position = "red";
            out.print((width-y));
        }
        if ((width-x)<=borderLimit || (height-y)<=borderLimit){
            position = "red";
            out.print((width-x));
        }
        if (y<=borderLimit || (width-x)<=borderLimit){
            position = "red";
            out.print(y);
        }
        return position;
    }

    public void spiningBehavior (){
	    setTurnLeft(180);
	    setAhead(200);
        execute();
    }

    public void reverseSpiningBehavior (){
        setTurnRight(200);
        setAhead(300);
        execute();
    }

    public void wallingBehavior (){
        // turnLeft to face a wall.
        // getHeading() % 90 means the remainder of
        // getHeading() divided by 90.
        turnLeft(getHeading() % 90);
        // Look before we turn when ahead() completes.
        peek = true;
        // Move up the wall
        ahead(moveAmount);
        // Don't look now
        peek = false;
        // Turn to the next wall
        turnRight(90);
    }
    //DOOFY
}