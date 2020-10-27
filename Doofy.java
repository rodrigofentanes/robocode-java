package df;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Doofy - a robot by (Carlos Rodrigo Araújo Fentanes)
 */
public class Doofy extends AdvancedRobot
{
	boolean peek;
	double mapWidth;
	double mapHeight;
	double moveAmount;
	int numb;
	Enemy[] enemyList;
	String aleatoryName;
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
		numb = getOthers();
		enemyList = new Enemy[numb];
		for (int i=0;i<numb;i++){
			enemyList[i] = new Enemy();
			enemyList[i].setName("XXXXT");
			enemyList[i].setDistance(999999);
			enemyList[i].setEnergy(999999);
			out.println("Obj"+i+"iniciado");
		}
		out.println("Wid = "+mapWidth+"\nHei = "+mapHeight+"\nMax = "+moveAmount+""+"\nNumb = "+numb+"\nTam Lista = "+enemyList.length+"");

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
		if(countRadar==4){
			countRadar = -1;
		}
		//out.println("\nCountInit: " + countRadar);
		countRadar = countRadar +1;
		String enemyName = e.getName();
		double enemyDistance = e.getDistance();
		double enemyPower = e.getEnergy();
		double x = getX();
		double y = getY();
		//out.println(enemyName + "\nPower: " + enemyPower + "\nDistancia:" + enemyDistance + "\nX:" + x + "\nY:" + y + "\nCountRadar:" + countRadar +"\n\n");

		enemyList[countRadar].setName(enemyName);
		enemyList[countRadar].setDistance(enemyDistance);
		enemyList[countRadar].setEnergy(enemyPower);

		out.println(enemyList[countRadar].getName()+"");
		out.println(enemyList[countRadar].getDistance()+"");
		out.println(enemyList[countRadar].getEnergy()+"\n"+countRadar+"\n\n");


//		for (int i=0;i<enemyList.length;i++){
//			if(enemyList[enemyList.length-1].getName()!="XXXXT"){
//				out.println("array cheio");
//				for (int j=0;j<enemyList.length;j++){
//					enemyList[j].setName("XXXXT");
//					enemyList[j].setDistance(999999);
//					enemyList[j].setEnergy(999999);
//					out.println("Obj"+j+"esvaziado");
//				}
//			}
//			if(enemyList[i].getName() == "XXXXT"){
//				enemyList[i].setName(enemyName);
//				enemyList[i].setDistance(enemyDistance);
//				enemyList[i].setEnergy(enemyPower);
//				out.println(enemyList[i].getName()+"Karine");
//				out.println(enemyList[i].getDistance()+"Karine");
//				out.println(enemyList[i].getEnergy()+"Karine"+i+"\n\n");
//			}
//		}

		/** Criar e preencher um array para poder calcular qual melhor estratégia a se seguir.
		 * 	Calcular quantos estão próximos.
		 * 	ql o mais próximo
		**/

	}

	public void onHitByBullet(HitByBulletEvent event) {
		out.println("im hit");
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
