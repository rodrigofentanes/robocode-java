package df;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Doofy - a robot by (Carlos Rodrigo Araújo Fentanes)
 */
public class Doofy extends AdvancedRobot
{
	double mapWidth;
	double mapHeight;
	double moveAmount;
	int enemyNumber;
	Enemy[] enemyList;
	int countRadar =-1;

	public void run() {
		// Cores do robo
		setBodyColor(new Color(216, 242, 250));
		setGunColor(new Color(79, 191, 213));
		setRadarColor(new Color(68, 123, 213));
		setBulletColor(Color.cyan);
		setScanColor(Color.red);

		// Definindo limite do mapa.
		mapWidth = getBattleFieldWidth();
		mapHeight = getBattleFieldHeight();
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		//Verifica quantidade de inimigos
		enemyNumber = getOthers();

		//instanciando obj Enemy
		enemyList = new Enemy[enemyNumber];

		// Loop principal do robo
		while(true) {
			setAhead(moveAmount);
			setTurnRadarRight(360);
			setTurnGunRight(90);
			setTurnLeft(10);
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if(countRadar>=enemyNumber-1){
			countRadar = -1;
		}
		countRadar = countRadar + 1;

		registryRadarInfo(enemyList, countRadar, e.getName(), e.getDistance(), e.getEnergy());
	}

	public void onHitByBullet(HitByBulletEvent event) {
		out.println("im hit");
	}

	public void registryRadarInfo (Enemy[] obj, int i, String name, double distance, double energy){
		obj[i] = new Enemy();
		obj[i].setName(name);
		obj[i].setDistance(distance);
		obj[i].setEnergy(energy);
	}

	public void onHitWall(HitWallEvent event) {
		double bearingDegrees = event.getBearing();
		out.println("Ouch, I hit a wall bearing " + bearingDegrees + " degrees.");

	}

	public void onWin(WinEvent e) {
		for (int i = 0; i < 50; i++) {
			turnRight(30);
			turnLeft(30);
		}
	}
}
