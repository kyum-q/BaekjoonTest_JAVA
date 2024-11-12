import java.util.*;
import java.awt.*;

class Solution {
    Set<Node> list = new HashSet<>();

    public int solution(String dirs) {
        Point current = new Point(0, 0);
        char[] chars = dirs.toCharArray();
        for (char c : chars) {
            Point next;
            switch (c) {
                case 'U':
                    next = new Point(current.x, current.y + 1);
                    break;
                case 'D':
                    next = new Point(current.x, current.y - 1);
                    break;
                case 'R':
                    next = new Point(current.x + 1, current.y);
                    break;
                default:
                    next = new Point(current.x - 1, current.y);
                    break;
            }

            if (next.x >= -5 && next.x <= 5 && next.y >= -5 && next.y <= 5) {
                Node node = new Node(current, next);
                list.add(node);
                current = next;
            }
        }

        return list.size();
    }

    public static class Node {
        Point start;
        Point end;

        public Node(Point start, Point end) {
            // start가 항상 작은 좌표를 가지도록 설정하여 방향과 상관없이 경로를 동일하게 저장
            if (start.x < end.x || (start.x == end.x && start.y < end.y)) {
                this.start = start;
                this.end = end;
            } else {
                this.start = end;
                this.end = start;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(start, node.start) && Objects.equals(end, node.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
