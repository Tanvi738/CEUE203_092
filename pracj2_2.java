public class pracj2_2 {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        } else {
            return false;
        }
    }

    public void cancel(int n) {
        seatsAvailable = Math.min(seatsAvailable + n, capacity);
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println(show.book(20));
        System.out.println(show.getSeatsAvailable());

        System.out.println(show.book(40));
        System.out.println(show.getSeatsAvailable());

        show.cancel(10);
        System.out.println(show.getSeatsAvailable());

        System.out.println(show.book(30));
        System.out.println(show.getSeatsAvailable());

        show.cancel(100);
        System.out.println(show.getSeatsAvailable());

        System.out.println(CinemaShow.getTotalBooked());
    }
}