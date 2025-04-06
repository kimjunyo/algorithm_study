import sys
input = sys.stdin.read
## 해당 문제 bfs로 풀어서 와샬로 다시 풀어봄.
def floyd_warshall(n, graph):
    INF = int(1e9)

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

    for i in range(n):
        for j in range(n):
            if graph[i][j] == INF:
                print(0, end=' ')
            else:
                print(graph[i][j], end=' ')
        print()

def main():
    data = input().split()
    n = int(data[0])
    m = int(data[1])
    INF = int(1e9)
    graph = [[INF]*n for _ in range(n)]

    for i in range(n):
        graph[i][i] = 0

    index = 2
    for _ in range(m):
        a, b, c = int(data[index])-1, int(data[index+1])-1, int(data[index+2])
        graph[a][b] = min(graph[a][b], c)  # 중복 간선 최소 처리
        index += 3

    floyd_warshall(n, graph)

main()
