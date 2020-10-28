package df;

public class Enemy {
    private String name;
    private double distance;
    private double energy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }



    public static int enemyArrayPosition (int counter, int qtdEnemies){
        if(counter>=(qtdEnemies-1)){
            //Se cheio, volte para o primeiro vetor.
            counter = -1;
        }
        counter = (counter+1);
        return counter;
    }

    public static boolean verifyExistence (Enemy[] obj, int counter,int enemies, String name){
        obj[enemies-1] = new Enemy();
        boolean exist = false;
        //verificar da posicao counter para tras.
        for (int i=0;i<counter-1;i++){
            System.out.println("POINTER ENEMY NAME ------"+obj[i].getName());
            System.out.println("ACTUAL ENEMY NAME ------"+name);
            if(obj[i].getName()==name){
                exist = true;
            }
        }
        System.out.println("RETURN ---- "+exist);
        return exist;
    }

    public static Enemy fillEnemyArray(Enemy[] obj, int counter,int enemies, String name, double distance, double energy){
        obj[counter] = new Enemy();
        obj[counter].setName(name);
        obj[counter].setDistance(distance);
        obj[counter].setEnergy(energy);
        return obj[counter];
    }

    public static String checkMostCloser(Enemy[] obj, int qtdEnemies, double maxAmount){
        String closerEnemy = null;
        obj[qtdEnemies-1] = new Enemy();

        for (int i=0;i<qtdEnemies-1;i++){
            if(obj[i].getDistance() <= maxAmount){
                closerEnemy = obj[i].getName();
            }
        }
        return closerEnemy;
    }

}