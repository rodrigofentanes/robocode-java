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

    public static String checkMostCloser(Enemy[] obj, int qtdEnemies, double maxAmount){
        String closerEnemy = null;
        obj[qtdEnemies-1] = new Enemy();


//        System.out.println("dentro do check obj "+obj[qtdEnemies-1]+"\n");
        for (int i=0;i<qtdEnemies-1;i++){
//            System.out.println("dentro do check obj FOR "+ obj[i].getDistance() + " aux: " + maxAmount+"\n");
            if(obj[i].getDistance() <= maxAmount){
//                System.out.println("dentro do check ENTROU"+"\n");
                closerEnemy = obj[i].getName();
            }
//            System.out.println("dentro do check closerEnemy "+closerEnemy+"\n");
        }
        return closerEnemy;
    }

    public static Enemy fillEnemyArray(Enemy[] obj, int i, String name, double distance, double energy){
        obj[i] = new Enemy();
        obj[i].setName(name);
        obj[i].setDistance(distance);
        obj[i].setEnergy(energy);
        return obj[i];
    }

}