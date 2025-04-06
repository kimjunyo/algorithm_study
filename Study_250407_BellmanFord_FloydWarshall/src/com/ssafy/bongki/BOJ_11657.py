import sys
input = sys.stdin.read

def bellman_ford(N, edges):
    INF = int(1e9)
    dist = [INF] * (N + 1)
    dist[1] = 0

    for i in range(N - 1):
        for u, v, w in edges:
            if dist[u] != INF and dist[v] > dist[u] + w:
                dist[v] = dist[u] + w

    # 음의 사이클 체크
    for u, v, w in edges:
        if dist[u] != INF and dist[v] > dist[u] + w:
            return [-1]

    return [d if d != INF else -1 for d in dist[2:]]

def main():
    data = input().split()
    N, M = int(data[0]), int(data[1])
    edges = []
    index = 2
    for _ in range(M):
        a, b, c = int(data[index]), int(data[index+1]), int(data[index+2])
        edges.append((a, b, c))
        index += 3

    result = bellman_ford(N, edges)
    for r in result:
        print(r)
############
main()
