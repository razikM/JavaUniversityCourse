package homework7;

public class Radio implements ElectricityConsumer{

    public void playMusic(){
        System.out.println("Radio is playing");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}
