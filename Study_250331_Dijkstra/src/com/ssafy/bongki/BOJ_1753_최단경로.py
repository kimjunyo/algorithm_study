import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())
start = int(input())

graph = [[] for _ in range(V + 1)]
distance = [float('inf')] * (V + 1)

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for next_node, weight in graph[now]:
            cost = dist + weight
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))

dijkstra(start)

for i in range(1, V + 1):
    print(distance[i] if distance[i] != float('inf') else "INF")
