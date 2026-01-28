package organization;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrgComponent {

    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrgComponent component) {
        this.children.add(component);
    }

    @Override
    public void remove(OrgComponent component) {
        this.children.remove(component);
    }

    @Override
    public OrgComponent getChild(int index) {
        return this.children.get(index);
    }

    @Override
    public double getTotalSalary() {
        double sum = 0.0;
        for (OrgComponent child : children) {
            sum += child.getTotalSalary(); // recursion happens here
        }
        return sum;
    }

    @Override
    protected String toXml(int indentLevel) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent(indentLevel))
                .append("<department name=\"")
                .append(escapeXml(name))
                .append("\">\n");

        for (OrgComponent child : children) {
            sb.append(child.toXml(indentLevel + 1)); // recursion happens here
        }

        sb.append(indent(indentLevel))
                .append("</department>\n");

        return sb.toString();
    }

    private String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}

