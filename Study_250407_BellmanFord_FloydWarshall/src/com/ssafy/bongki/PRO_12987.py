INF = 10**9

def solution(N, road, K):
    graph = [[INF] * (N+1) for _ in range(N+1)]

    for i in range(N+1):
        graph[i][i] = 0

    for r in road:
        graph[r[0]][r[1]] = min(graph[r[0]][r[1]], r[2])
        graph[r[1]][r[0]] = min(graph[r[1]][r[0]], r[2])

    for x in range(1,N+1):
        for a in range(1,N+1):
            for b in range(1,N+1):
                graph[a][b] = min(graph[a][x]+graph[b][x], graph[a][b])

    return len([d for d in graph[1] if d <= K])
