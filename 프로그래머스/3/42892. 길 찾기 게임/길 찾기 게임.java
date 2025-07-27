import java.util.*;

class Solution {
    private static class Node {
        int idx, x, y;
        Node left, right;
        
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
    
    private void buildBinaryTree(Node[] nodes) {
        // 0번째는 무조건 루트
        Node root = nodes[0];
        
        for(int i = 1; i < nodes.length; i++) {
            Node parent = root;
            Node now = nodes[i];
            
            while (true) {
                if (now.x < parent.x) {
                    if (parent.left == null) {
                        parent.left = now;
                        parent = parent.left;
                        break;
                        
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = now;
                        parent = parent.right;
                        break;
                        
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
    }
    
    private ArrayList<Integer> preorderedList = new ArrayList<>();
    private void preorder(Node root) {
        if (root != null) {
            preorderedList.add(root.idx);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    private ArrayList<Integer> postorderedList = new ArrayList<>();
    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            postorderedList.add(root.idx);
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // y좌표 기준으로 내림차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            return o2.y - o1.y;
        });
        
        // 이진트리로 만들기
        buildBinaryTree(nodes);
        
        //전위 순회
        preorder(nodes[0]);
        int[] pre = preorderedList.stream().mapToInt(Integer::intValue).toArray();
        
        //후위 순회
        postorder(nodes[0]);
        int[] post = postorderedList.stream().mapToInt(Integer::intValue).toArray();
        
        int[][] answer = {pre, post};
        return answer;
    }
}

// (8,6), (3,5), (11,5), (5,3), (13,3), (1,3), (7,2), (2,2), (6,1)