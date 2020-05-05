# Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060

# HOW TO RUN:
# python3 Main.py


from heapq import *


class Tree:

    class Edge:
        def __init__(self, v1, v2, cost):
            self.v1 = v1
            self.v2 = v2
            self.cost = cost

        def __str__(self):
            return "(" + str(self.v1) + ", " + str(self.v2) + ") cost: " + str(self.cost)

    def __init__(self, num_vertices):
        self.graph = [
            [-1 for column in range(num_vertices)] for row in range(num_vertices)]
        for i in range(num_vertices):
            self.graph[i][i] = 0

        self.edgeList = []
        self.size = num_vertices

    def make_edge(self, edge):
        self.edgeList.append(edge)
        self.graph[edge.v1][edge.v2] = self.graph[edge.v2][edge.v1] = edge.cost

    def make_edges(self, edges):
        for edge in edges:
            self.make_edge(edge)

    def total_cost(self):
        cost = 0
        for i in range(len(self.graph)):
            for j in range(i, len(self.graph)):
                if self.graph[i][j] > 0:
                    cost += self.graph[i][j]
        return cost

    def print_tree(self):
        print("Edge\tCost")
        for i in range(len(self.graph)):
            for j in range(i, len(self.graph)):
                if (self.graph[i][j]) > 0:
                    x = self.graph[i][j]
                    print(i, "-", j, "\t", x)


class MST:
    def __init__(self, tree):
        self.tree = tree

    def Kruskal(self):
        final = Tree(self.tree.size)
        tEdges = self.tree.edgeList

        sets = []
        for i in range(self.tree.size):
            sets.append([i])

        def find_set(x):
            for s in sets:
                for i in s:
                    if i == x:
                        return s

        def union(s1, s2):
            i = 0
            while i < len(sets):
                if sets[i] == s1 or sets[i] == s2:
                    del sets[i]
                else:
                    i += 1

            sets.append(s1 + s2)

        tEdges.sort(key=lambda x: x.cost)

        for edge in tEdges:
            s1 = find_set(edge.v1)
            s2 = find_set(edge.v2)
            if s1 != s2:
                final.make_edge(edge)
                union(s1, s2)

        final.print_tree()

    def Prim(self):
        key = [float("INF")] * self.tree.size
        prev = [None] * self.tree.size
        key[0] = 0

        visited = [False] * self.tree.size

        #prev[0] = -1
        heap = [(key[i], i) for i in range(self.tree.size)]
        heapify(heap)

        while len(heap):
            u = heappop(heap)[1]
            visited[u] = True
            for edge in self.tree.edgeList:
                if edge.v1 == u and not visited[edge.v2] and edge.cost < key[edge.v2]:
                    v = edge.v2

                elif edge.v2 == u and not visited[edge.v1] and edge.cost < key[edge.v1]:
                    v = edge.v1

                else:
                    continue

                key[v] = edge.cost

                for i in range(len(heap)):
                    if heap[i][1] == v:
                        heap[i] = (key[v], v)
                        heapify(heap)
                        break
                prev[v] = u
                print(prev)

        print("Edge\tCost")
        for i in range(1, self.tree.size):
            print(prev[i], "-", i, "\t", self.tree.graph[i][prev[i]])


class SP:
    def __init__(self, tree):
        self.tree = tree

    def Dijkstra(self):
        dist = [float("INF")] * self.tree.size
        dist[0] = 0

        prev = [None] * self.tree.size

        heap = [(dist[i], i) for i in range(self.tree.size)]
        heapify(heap)

        while len(heap):
            x = heappop(heap)
            for edge in self.tree.edgeList:
                if edge.v1 == x[1]:
                    v = edge.v2
                elif edge.v2 == x[1]:
                    v = edge.v1
                else:
                    continue

                if dist[v] > dist[x[1]] + edge.cost:
                    dist[v] = dist[x[1]] + edge.cost

                    for i in range(len(heap)):
                        if heap[i][1] == v:
                            heap[i] = (dist[v], v)
                            heapify(heap)
                            break

                    prev[v] = x[1]

        paths = genPaths(prev)
        print("Vertex\tDistance\tPath")
        for i in range(self.tree.size):
            print(i, "\t", dist[i], "\t\t", paths[i])

    def BellmanFord(self):
        dist = [float("INF")] * len(self.tree.graph)
        dist[0] = 0
        prev = [None] * self.tree.size

        for _ in range(1, self.tree.size):
            for i in self.tree.edgeList:
                if dist[i.v1] + i.cost < dist[i.v2]:
                    dist[i.v2] = dist[i.v1] + i.cost
                    prev[i.v2] = i.v1
                if dist[i.v2] + i.cost < dist[i.v1]:
                    dist[i.v1] = dist[i.v2] + i.cost
                    prev[i.v1] = i.v2

        paths = genPaths(prev)
        print("Vertex\tDistance\tPath")
        for i in range(self.tree.size):
            print(i, "\t", dist[i], "\t\t", paths[i])


def genPaths(prev):
    paths = [[x] for x in range(len(prev))]

    for i in range(len(prev)):
        while paths[i][-1] != 0:
            paths[i].append(prev[paths[i][-1]])

    for i in range(len(paths)):
        paths[i].reverse()

    return paths


def main():
    tree = testTree1

    print("1. Minimum Spanning Tree")
    print("2. Shortest Path")
    uinput = int(input("Enter '1' or '2' to select an option: "))

    if uinput is 2:
        print("")
        print("1. Dijkstra's Algorithm")
        print("2. Bellman-Ford Algorithm")
        uinput = int(input("Enter '1' or '2' to select an option: "))

        sp = SP(tree)
        if uinput is 1:
            sp.Dijkstra()
        else:
            sp.BellmanFord()

    else:
        print("")
        print("1. Kruskal")
        print("2. Prim")
        uinput = int(input("Enter '1' or '2' to select an option: "))
        mst = MST(tree)
        if uinput is 1:
            mst.Kruskal()
        else:
            mst.Prim()


testTree1 = Tree(5)
testTree1.make_edges([
    Tree.Edge(0, 1, 200),
    Tree.Edge(0, 2, 500),
    Tree.Edge(0, 3, 10),
    Tree.Edge(1, 2, 80),
    Tree.Edge(1, 3, 70),
    Tree.Edge(1, 4, 90),
    Tree.Edge(2, 4, 40),
    Tree.Edge(3, 4, 200)])


if __name__ == "__main__":
    main()
