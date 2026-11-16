package Visitor;

import java.util.ArrayList;
import java.util.List;

// 1. Interfaz Visitor: Declara un método de visita por cada clase concreta
interface Visitor {
    String visitDot(Dot d);
    String visitCircle(Circle c);
    String visitRectangle(Rectangle r);
    String visitCompoundGraphic(CompoundShape cs);
}

// 2. Interfaz Element (Shape): Define el método accept(Visitor)
interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor v);
}

// 3. Elementos Concretos: Implementan accept() delegando al método específico del visitante
class Dot implements Shape {
    private int id;
    private int x;
    private int y;

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Dibujando Punto #" + id + " en (" + x + ", " + y + ")");
    }

    @Override
    public String accept(Visitor v) {
        // Double Dispatch: le pasa 'this' (tipo Dot) al visitante
        return v.visitDot(this);
    }
}

class Circle extends Dot {
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    public int getRadius() { return radius; }

    @Override
    public void draw() {
        System.out.println("Dibujando Círculo #" + getId() + " con radio " + radius);
    }

    @Override
    public String accept(Visitor v) {
        return v.visitCircle(this);
    }
}

class Rectangle implements Shape {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Dibujando Rectángulo #" + id + " (" + width + "x" + height + ")");
    }

    @Override
    public String accept(Visitor v) {
        return v.visitRectangle(this);
    }
}

class CompoundShape implements Shape {
    private int id;
    public List<Shape> children = new ArrayList<>();

    public CompoundShape(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public void add(Shape shape) {
        children.add(shape);
    }

    @Override
    public void move(int x, int y) {
        for (Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void draw() {
        System.out.println("Dibujando Gráfico Compuesto #" + id + " con " + children.size() + " elementos.");
    }

    @Override
    public String accept(Visitor v) {
        return v.visitCompoundGraphic(this);
    }
}

// 4. Visitante Concreto: Encapsula la lógica de exportación XML fuera de las figuras
class XMLExportVisitor implements Visitor {

    public String export(Shape... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        for (Shape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visitDot(Dot d) {
        return "<dot>\n" +
               "    <id>" + d.getId() + "</id>\n" +
               "    <x>" + d.getX() + "</x>\n" +
               "    <y>" + d.getY() + "</y>\n" +
               "</dot>";
    }

    @Override
    public String visitCircle(Circle c) {
        return "<circle>\n" +
               "    <id>" + c.getId() + "</id>\n" +
               "    <x>" + c.getX() + "</x>\n" +
               "    <y>" + c.getY() + "</y>\n" +
               "    <radius>" + c.getRadius() + "</radius>\n" +
               "</circle>";
    }

    @Override
    public String visitRectangle(Rectangle r) {
        return "<rectangle>\n" +
               "    <id>" + r.getId() + "</id>\n" +
               "    <x>" + r.getX() + "</x>\n" +
               "    <y>" + r.getY() + "</y>\n" +
               "    <width>" + r.getWidth() + "</width>\n" +
               "    <height>" + r.getHeight() + "</height>\n" +
               "</rectangle>";
    }

    @Override
    public String visitCompoundGraphic(CompoundShape cs) {
        StringBuilder sb = new StringBuilder();
        sb.append("<compound_graphic>\n");
        sb.append("    <id>").append(cs.getId()).append("</id>\n");
        for (Shape shape : cs.children) {
            String obj = shape.accept(this);
            // Indenta el XML interno para mantener la jerarquía visual
            obj = "    " + obj.replace("\n", "\n    ");
            sb.append(obj).append("\n");
        }
        sb.append("</compound_graphic>");
        return sb.toString();
    }
}

// 5. Application (Cliente): Crea las figuras, instancia el visitante y ejecuta la exportación
public class MainVisitor {
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape subCompound = new CompoundShape(5);
        subCompound.add(new Dot(6, 0, 0));
        compoundShape.add(subCompound);

        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println("--- Exportando estructura heterogénea a XML ---");
        System.out.println(exportVisitor.export(circle, compoundShape));
    }
}