package organization;

public class Employee extends OrgComponent {

    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double getTotalSalary() {
        return salary; // leaf: just its own salary
    }

    @Override
    protected String toXml(int indentLevel) {
        return indent(indentLevel) +
                "<employee name=\"" + escapeXml(name) + "\" salary=\"" + salary + "\"/>\n";
    }

    @Override
    public void add(OrgComponent component) {
        throw new UnsupportedOperationException("Not supported in leaf (Employee).");
    }

    @Override
    public void remove(OrgComponent component) {
        throw new UnsupportedOperationException("Not supported in leaf (Employee).");
    }

    @Override
    public OrgComponent getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf (Employee).");
    }

    private String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
