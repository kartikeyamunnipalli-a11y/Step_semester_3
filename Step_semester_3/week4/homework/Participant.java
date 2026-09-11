class Participant {
    String name;
    String teamName;
    boolean registered;

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
