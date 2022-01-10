import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        Speaker sp3 = new Speaker(200, 200);
        Speaker sp4 = new Speaker(200, 200);

        Brand brand2 = new Brand();
        brand2.setName("Samsung");

        sp3.setBrand(brand2);
        sp4.setBrand(brand2);

        SoundSystem system2 = new SoundSystem();
        system2.setSpeaker1(sp3);
        system2.setSpeaker2(sp4);

        //list with two sound systems
        List<SoundSystem> systems = new ArrayList<>();
        systems.add(system);
        systems.add(system2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("binary.dat"))) {
            oos.writeObject(systems);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("binary.dat"))) {
            List<SoundSystem> readSystems = (List<SoundSystem>) oos.readObject();
            System.out.println(readSystems);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
