public class App {
    public static void main(String[] args) throws Exception {
        UserData data = new UserData("abc123", "John Doe", "john.doe@us.gov", 2010);
        System.out.println(data.toString());

        UserRecord record = new UserRecord("def456", "Jane Doe", "jane.doe@us.gov", 2011);
        System.out.println(record.toString());
    }
}
