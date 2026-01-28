package organization;

public abstract class OrgComponent {

    protected String name;

    public OrgComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Required: total salary with one method call (recursive in Department)
    public abstract double getTotalSalary();

    // Required: full XML print with one method call (recursive in Department)
    public String toXml() {
        // root call uses indent level 0
        return toXml(0);
    }

    protected abstract String toXml(int indentLevel);

    // Child management (transparency approach: leaf will throw exceptions)
    public abstract void add(OrgComponent component);

    public abstract void remove(OrgComponent component);

    public abstract OrgComponent getChild(int index);

    // Helper for indentation in XML
    protected String indent(int indentLevel) {
        return "  ".repeat(Math.max(0, indentLevel));
    }
}

