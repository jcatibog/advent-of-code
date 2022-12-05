package net.catibog.advent_of_code.y2022.day4;

public class SectionAssignment {
    private int start;
    private int end;
    public SectionAssignment(String assignment) {
        String[] assignments = assignment.split("-");
        start = Integer.parseInt(assignments[0]);
        end = Integer.parseInt(assignments[1]);
    }

    public boolean contains(SectionAssignment o) {
        return this.start <= o.start && this.end >= o.end;
    }

    public boolean overlaps(SectionAssignment o) {
        boolean isOverlapped = (o.start >= this.start && o.start <= this.end) ||
            (o.end >= this.start && o.end <= this.end);
        System.out.println(String.format("%s\t%s\toverlaps: %b", this, o, isOverlapped));
        return isOverlapped;
    }

    @Override
    public String toString() {
        return String.format("SectionAssignment[start=%d, end=%d]", this.start, this.end);
    }
}
