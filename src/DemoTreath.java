import java.util.ArrayList;
import java.util.Random;

public class DemoTreath {

    Info info;
    int contador = 1;

    public DemoTreath(){
        info = new Info();
        addRandomsNumbers();
        showRandomsNumbers();
        deleteRandomsNumbers();
    }

    private void createRandomsNumbers(){
        Random random = new Random();
        int randomN = 0;
        randomN = random.nextInt(700 - 10 + 1) + 10;
        info.addNumnber(randomN);
    }

    private void addRandomsNumbers(){
        boolean running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(running){
                    createRandomsNumbers();
                    sleep(200);
                }
            }
        });
        thread.start();
    }

    private void deleteRandomsNumbers(){
        boolean running = true;
        Random random = new Random();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(running){
                    info.deleteNumnber(random.nextInt(info.getNumbers().size() - 0 + 1) + 0);
                    sleep(900);
                }
            }
        });
        thread.start();
    }

    private void showRandomsNumbers(){
        boolean running = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> numbers = null;
                while(running){
                    numbers = info.getNumbers();
                    for (Integer n: numbers) {
                        System.out.println("  " + n + "-->" + contador);
                        contador++;
                    }
                    sleep(300);
                }
            }
        });
        thread.start();
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
