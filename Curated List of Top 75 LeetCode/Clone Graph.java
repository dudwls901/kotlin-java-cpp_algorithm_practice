//https://leetcode.com/problems/clone-graph/description/
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

class Solution {
    Node[] visited = new Node[101];

    private void dfs(Node next, Node copy){
        visited[copy.val] = copy;
        for(Node n : next.neighbors){
            if(visited[n.val] == null){
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n, newNode);
            }else{
                copy.neighbors.add(visited[n.val]);
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        Arrays.fill(visited, null);
        dfs(node, copy);
        return copy;
    }
}
