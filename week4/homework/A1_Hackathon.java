class Participant {
    private final String name;
    private final String teamName;
    private final boolean registered;

    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }
}

public class A1_Hackathon {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        for (int i = 0; i < names.length; i++) {
            Participant participant = teamNames[i].isEmpty()
                    ? new Participant(names[i])
                    : new Participant(names[i], teamNames[i]);
            participant.printStatus();
        }
    }
}