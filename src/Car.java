

import java.util.Random;

public class Car implements Runnable {
    /** khai bao ten xe dua*/
    public String name;

    public Car(String name){
        this.name = name;

    }
    int DISTANCE = Main.DISTANCE;
    int STEP =Main.STEP;

    @Override
    public void run() {
        //Khoi tao diem start
        int runDistance =0;
        //khoi tao thoi gian bat dau cuoc dua
        long startTime = System.currentTimeMillis();
        // kiem tra chung nao con chua ket thuc quang duong thi xe con tiep tuc chay
        while (runDistance< Main.DISTANCE){
            try{
                int speed = (new Random().nextInt(20));
                runDistance+= speed;
                String log = "|";
                int percentTravel =(runDistance*100)/DISTANCE;
                for (int i = 0; i <DISTANCE ; i+= STEP) {
                    if(percentTravel>= i+STEP){
                        log += "=";
                    }else if (percentTravel>= i && percentTravel < i+STEP){
                        log+= "o";
                    }else {
                        log+= "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;

            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }


}
