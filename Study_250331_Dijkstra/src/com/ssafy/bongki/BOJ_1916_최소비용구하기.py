import sys
import heapq

input = sys.stdin.readline
n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
dist = [float('inf')] * (n + 1)

for _ in range(m):
    u, v, cost = map(int, input().split())
    graph[u].append((v, cost))

start, end = map(int, input().split())

def dijkstra(start):
    q = []
    dist[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        cur_cost, cur_node = heapq.heappop(q)
        if dist[cur_node] < cur_cost:
            continue
        for next_node, cost in graph[cur_node]:
            total = cur_cost + cost
            if total < dist[next_node]:
                dist[next_node] = total
                heapq.heappush(q, (total, next_node))

dijkstra(start)
print(dist[end])
