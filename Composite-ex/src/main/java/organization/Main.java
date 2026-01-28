package organization;

public class Main {

    public static void main(String[] args) {

        // Root department = whole organization
        OrgComponent organization = new Department("MyCompany");

        // Departments
        OrgComponent it = new Department("IT");
        OrgComponent hr = new Department("HR");
        OrgComponent sales = new Department("Sales");
        OrgComponent domesticSales = new Department("Domestic");
        OrgComponent internationalSales = new Department("International");

        // Employees
        OrgComponent alice = new Employee("Alice", 5000);
        OrgComponent bob = new Employee("Bob", 4500);
        OrgComponent carol = new Employee("Carol", 4000);
        OrgComponent dan = new Employee("Dan", 4200);
        OrgComponent eve = new Employee("Eve", 6200);

        // Build tree (same style as boxes)
        it.add(alice);
        it.add(bob);

        hr.add(carol);

        domesticSales.add(dan);
        internationalSales.add(eve);

        sales.add(domesticSales);
        sales.add(internationalSales);

        organization.add(it);
        organization.add(hr);
        organization.add(sales);

        // 1) Print total salary with a single method call
        System.out.println("Total salary: " + organization.getTotalSalary());

        // 2) Print full organizational structure in XML with a single method call
        System.out.println("\n--- Organization XML ---");
        System.out.print(organization.toXml());

        // 3) Show add/remove at runtime with a single method call
        System.out.println("\n--- Removing Bob from IT ---");
        it.remove(bob);

        System.out.println("Total salary after removal: " + organization.getTotalSalary());
        System.out.println("\n--- Organization XML after removal ---");
        System.out.print(organization.toXml());
    }
}
