import org.junit.*;

public class SoundSystemTest {
    public SoundSystemTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setAndGet() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(40, soundSystem.getSpeaker1().getWatts());
        Assert.assertEquals(60, soundSystem.getSpeaker1().getSPL());
        Assert.assertEquals(40, soundSystem.getSpeaker2().getWatts());
        Assert.assertEquals(60, soundSystem.getSpeaker2().getSPL());


        Speaker speaker1 = new Speaker(60, 80);
        soundSystem.setSpeaker1(speaker1);
        Assert.assertEquals(60, soundSystem.getSpeaker1().getWatts());
        Assert.assertEquals(80, soundSystem.getSpeaker1().getSPL());

        Speaker speaker2 = new Speaker(20, 20);
        soundSystem.setSpeaker2(speaker2);
        Assert.assertEquals(20, soundSystem.getSpeaker2().getWatts());
        Assert.assertEquals(20, soundSystem.getSpeaker2().getSPL());

        speaker1 = new Speaker(80, 30);
        speaker2 = new Speaker(30, 50);

        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(80, soundSystem2.getSpeaker1().getWatts());
        Assert.assertEquals(30, soundSystem2.getSpeaker1().getSPL());
        Assert.assertEquals(30, soundSystem2.getSpeaker2().getWatts());
        Assert.assertEquals(50, soundSystem2.getSpeaker2().getSPL());

    }

    @Test
    public void totalWatts() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(80, soundSystem.getTotalWatts());
        Speaker speaker1 = new Speaker(50, 50);
        Speaker speaker2 = new Speaker(50, 50);
        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(100, soundSystem2.getTotalWatts());
        speaker1 = new Speaker(50, 50);
        speaker2 = new Speaker(100, 100);
        SoundSystem soundSystem3 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(150, soundSystem3.getTotalWatts());
    }

    @Test
    public void dangerous() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertFalse(soundSystem.isDangerous());
        Speaker speaker1 = new Speaker(150, 50);
        Speaker speaker2 = new Speaker(150, 150);
        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertTrue(soundSystem2.isDangerous());
        speaker1 = new Speaker(150, 130);
        speaker2 = new Speaker(150, 130);
        SoundSystem soundSystem3 = new SoundSystem(speaker1, speaker2);
        Assert.assertFalse(soundSystem3.isDangerous());
        speaker1 = new Speaker(150, 140);
        speaker2 = new Speaker(150, 30);
        SoundSystem soundSystem4 = new SoundSystem(speaker1, speaker2);
        Assert.assertTrue(soundSystem4.isDangerous());
        speaker1 = new Speaker(150, 131);
        speaker2 = new Speaker(150, 131);
        SoundSystem soundSystem5 = new SoundSystem(speaker1, speaker2);
        Assert.assertTrue(soundSystem5.isDangerous());
    }

    @Test
    public void averageRate() {
        SoundSystem soundSystem = new SoundSystem();
        Assert.assertEquals(2.0, soundSystem.getAverageRating(), 0.01);
        Speaker speaker1 = new Speaker(100, 50);
        Speaker speaker2 = new Speaker(25, 50);
        SoundSystem soundSystem2 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(3.0, soundSystem2.getAverageRating(), 0.01);
        speaker1 = new Speaker(70, 50);
        speaker2 = new Speaker(85, 50);
        SoundSystem soundSystem3 = new SoundSystem(speaker1, speaker2);
        Assert.assertEquals(3.5, soundSystem3.getAverageRating(), 0.01);

    }
}
