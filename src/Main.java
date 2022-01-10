import java.io.*;

public class Main {

    public static void main(String[] args) {
        Speaker sp1 = new Speaker(100, 100);
        Speaker sp2 = new Speaker(100, 100);

        Brand brand = new Brand();
        brand.setName("Sony");

        sp1.setBrand(brand);
        sp2.setBrand(brand);

        SoundSystem system = new SoundSystem();
        system.setSpeaker1(sp1);
        system.setSpeaker2(sp2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("binary.dat"))) {
            oos.writeObject(system);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("binary.dat"))) {
            SoundSystem s = (SoundSystem) oos.readObject();
            System.out.println(s);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
