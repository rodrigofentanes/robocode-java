package df;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Doofy - a robot by (Carlos Rodrigo Araújo Fentanes)
 */
public class Doofy extends AdvancedRobot
{
    //DOOFY -----------------------------------------------------------
    double mapWidth;
    double mapHeight;
    int numberOfEnemies;
    Enemy[] enemyList;
    int countRadar;
    String hereIAm;
    String myZone;
    String mostCloserEnemy;
    boolean fullVector;
    boolean existence;
    //DOOFY **************************************************************

    //WALLS -----------------------------------------------------------
    boolean peek; // dê uma espiada e nao vire caso veja um robo.
    double moveAmount;
    //WALLS **************************************************************

    public void run() {
        //DOOFY -----------------------------------------------------------
        // Cores do robo
        setBodyColor(new Color(216, 242, 250));
        setGunColor(new Color(79, 191, 213));
        setRadarColor(new Color(68, 123, 213));
        setBulletColor(Color.cyan);
        setScanColor(Color.red);
        // Definindo limite do mapa.
        mapWidth = getBattleFieldWidth();
        mapHeight = getBattleFieldHeight();
        //Verifica quantidade de inimigos.
        numberOfEnemies = getOthers();
        //instanciando obj Enemy.
        enemyList = new Enemy[numberOfEnemies];
        enemyList[0] = null;
        //inicia countRadar.
        countRadar = -1;
        //inicializar fullVector
        fullVector = false;
        //inicializar objeto
//        for (int i=0;i<=numberOfEnemies-1;i++){
//            enemyList[i].setName(null)=;
//            enemyList[i].setDistance(0);
//            enemyList[i].setEnergy(0);
//        }
//        Enemy.printAllObj(enemyList,numberOfEnemies);

        //DOOFY **************************************************************

        //WALLS -----------------------------------------------------------
        // Utiliza a funcao nativa do Java para determinar qual o tamanho maximo da tela.
        moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
        // Initialize peek to false
        peek = false;
        //WALLS **************************************************************

        while(true) {
            setTurnRadarRight(3800); //manter radar girando
            hereIAm = Referential.whereAmI(getX(),getY(), mapWidth, mapHeight); //define se o robo está no meio, embaixo, acima, direita ou esquerda.
            if (hereIAm == "middle"){ //caso esteja no meio, gire.
                spiningBehavior();
            }else {
                wallingBehavior(); //caso esteja em qualquer lugar que não seja o meio, espreite pelas laterais.
            }
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        //reseta existence
        existence = false;
        //verifica se o objeto já existe no array
        existence = Enemy.verifyExistence(enemyList, countRadar,numberOfEnemies, e.getName());
        out.println("EXISTENCE --------------- "+existence);
        out.println("ACTUAL ENEMY --------------- "+e.getName());
        if(!existence){
            //atualiza o contador do radar(ponteiro).
            out.println("ANTERIOR POINTER --------------- "+countRadar);
            countRadar = Enemy.enemyArrayPosition(countRadar, numberOfEnemies);
            enemyList[countRadar] = Enemy.fillEnemyArray(enemyList, countRadar,numberOfEnemies, e.getName(), e.getDistance(), e.getEnergy());
            String enemy = enemyList[countRadar].getName();
            out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO ARRAY POSITION "+countRadar);
            out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO ENAMY NAME"+enemy);
        }
        if (countRadar==numberOfEnemies-1){
            mostCloserEnemy = Enemy.checkMostCloser(enemyList, numberOfEnemies,moveAmount);
            out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX MOST CLOSE"+mostCloserEnemy);
        }

    }
























    public void onHitRobot(HitRobotEvent e) {
        // If he's in front of us, set back up and turn left a bit.
        if (e.getBearing() > -90 && e.getBearing() < 90) {
            setTurnLeft(40);
            back(120);
            reverseSpiningBehavior();
        } // else he's in back of us, so set ahead and turn left a bit.
        else {
            setTurnLeft(40);
            ahead(120);
            reverseSpiningBehavior();
        }
    }

    public void onHitByBullet(HitByBulletEvent event) {
        myZone = Referential.whatIsMyZone(getX(),getY(),mapWidth,mapHeight);
        if (myZone=="red"){
            turnRight(90);
            setTurnLeft(40);
            ahead(200);
        }else {
            reverseSpiningBehavior();
        }
    }

    public void onHitWall(HitWallEvent event) {
    }

    public void onWin(WinEvent e) {
        //dancar um pagodinho quando vencer!
        for (int i = 0; i < 50; i++) {
            setTurnRadarRight(3800);
            turnRight(40);
            back(100);
            turnLeft(-80);
            ahead(100);
            back(100);
            turnRight(80);
            ahead(100);
        }
    }
    //DOOFY BEHAVIORS -----------------------------------------------------------
    public void spiningBehavior (){
        setTurnLeft(180);
        setAhead(200);
        execute();
    }

    public void reverseSpiningBehavior (){
        setTurnRight(120);
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
        // Move up the wall.
        ahead(moveAmount/4);
        // Don't look now.
        peek = false;
        // Turn to the next wall.
        turnRight(90);
    }
    //DOOFY BEHAVIORS **************************************************************


    //DOOFY DOCKER TO OWN CLASS -----------------------------------------------------------

    //DOOFY DOCKER TO OWN CLASS **************************************************************
}
