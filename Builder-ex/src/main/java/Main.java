public class Main {
    public static void main(String[] args) {
        // Build a gaming computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);

        Computer gamingComputer = director.constructComputer();
        System.out.println("=== Gaming Computer ===");
        System.out.println(gamingComputer);

        // Build an office computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.setBuilder(officeBuilder);

        Computer officeComputer = director.constructComputer();
        System.out.println("=== Office Computer ===");
        System.out.println(officeComputer);
    }
}