import org.junit.*;

public class SpeakerTest {
    public SpeakerTest() {

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
        Speaker speaker = new Speaker(50, 50);
        Assert.assertEquals(50, speaker.getSPL());
        Assert.assertEquals(50, speaker.getWatts());
        speaker.setWatts(60);
        Assert.assertEquals(60, speaker.getWatts());
        speaker.setSPL(45);
        Assert.assertEquals(45, speaker.getSPL());
    }

    @Test
    public void testGetRate1() {
        Speaker speaker = new Speaker(40, 50);
        Assert.assertEquals(2, speaker.getRating());
        speaker.setWatts(90);
        Assert.assertEquals(4, speaker.getRating());
        speaker.setWatts(79);
        Assert.assertEquals(3, speaker.getRating());
        speaker.setWatts(60);
        Assert.assertEquals(3, speaker.getRating());
    }

    @Test
    public void testGetRate2() {
        Speaker speaker = new Speaker(30, 150);
        Assert.assertEquals(2, speaker.getRating());
        speaker.setWatts(29);
        Assert.assertEquals(1, speaker.getRating());
        speaker.setWatts(100);
        Assert.assertEquals(5, speaker.getRating());

    }

}
