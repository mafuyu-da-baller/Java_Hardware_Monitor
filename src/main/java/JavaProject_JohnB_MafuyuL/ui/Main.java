package JavaProject_JohnB_MafuyuL.ui;

public class Main {
    public static void main(String[] args) {
        //Create PCPart array for access in other classes
        PCPart[] myPC = new PCPart[4];
        myPC[0] = new GPU();
        myPC[1] = new CPU();
        myPC[2] = new RAM();
        myPC[3] = new Storage();
        myPC[4] = new Fan();

        MenuWrapper menu = new MenuWrapper(myPC);

        menu.start(myPC);
    }
}