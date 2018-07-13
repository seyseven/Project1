public class Shell {
    public static void main(String[] args) {
        try {
            new ArrayList().get(123);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
