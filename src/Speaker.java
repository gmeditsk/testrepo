import java.io.Serializable;

/**
 * Αυτή η κλάση αναπαριστά ένα ηχείο. Το ηχείο έχει δύο χαρακτηριστικά, την ισχύ (Watts) και την πίεση του ήχου (Sound
 * Pressure Level - SPL) που την μετράμε σε deciBels (dB).
 * This class represents a speaker. The speaker has two attributes, its power (Watts) and its Sound Pressure Level - SPL
 * measured in deviBels (dB).
 */
public class Speaker implements Serializable {

    private int watts;
    private int spl;

    // NEW
    Brand brand;

    // Δημιουργήστε έναν κατασκευαστή που να δέχεται ως παραμέτρους τα χαρακτηριστικά του ηχείου.
    // Create a constructor that has as parameters the speakers attributes.
    public Speaker(int watts, int spl) {
        this.watts = watts;
        this.spl = spl;
    }

    /**
     * Μέθοδος που αλλάζει τα watts του ηχείου.
     * This method should change the speaker's watts.
     */
    public void setWatts(int watts) {
        this.watts = watts;
    }

    /**
     * Μέθοδος που αλλάζει το SPL του ηχείου.
     * This method should change the speaker's SPL.
     **/
    public void setSPL(int spl) {
        this.spl = spl;

    }

    /**
     * Μέθοδος που επιστρέφει το SPL του ηχείου.
     * This method should return the speaker's SPL.
     */
    public int getSPL() {
        return this.spl;
    }

    /**
     * Μέθοδος που επιστρέφει τα Watts του ηχείου.
     * This method should return the speaker's Watts.
     */
    public int getWatts() {
        return this.watts;

    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Το ηχείο παίρνει μια βαθμολογία (1-5) ανάλογα με την ισχύ του. Αν η ισχύς είναι κάτω από 30 Watss παίρνει τον
     * βαθμό 1. Αντίστοιχα (60 -> 2, 80 -> 3, 100-> 4, >100 -> 5). Αυτή η μέθοδος επιστρέφει την βαθμολογία.
     * Each speaker is rated from 1 to 5 based on its power (watts). If its power is less than 30 watts it is rated with
     * 1. Respectively (60 -> 2, 80 -> 3, 100-> 4, >100 -> 5). This method should return the speakers rating,
     * * βαθμό 1. Αντίστοιχα
     */
    public int getRating() {
        if (this.watts < 30) {
            return 1;
        } else if (this.watts < 60) {
            return 2;
        } else if (this.watts < 80) {
            return 3;
        } else if (this.watts < 100) {
            return 4;
        } else {
            return 5;
        }

    }

    @Override
    public String toString() {
        return "Speaker{" +
                "watts=" + watts +
                ", spl=" + spl +
                ", brand=" + brand +
                '}';
    }
}
