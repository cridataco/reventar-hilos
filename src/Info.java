import java.util.ArrayList;

public class Info {

    private ArrayList<Integer> numbers;
    boolean used = false;

    public Info (){
        numbers = new ArrayList<>();
    }

    public synchronized void addNumnber(int number){
        try {
            while (!used) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        used = true;
        numbers.add(number);
        notify();
        used = false;
    }

    public void deleteNumnber(int position){
        numbers.remove(position);
    }

    public ArrayList<Integer> getNumbers() {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (Integer n: numbers) {
            tmp.add(n);
        }
        return tmp;
    }
}
