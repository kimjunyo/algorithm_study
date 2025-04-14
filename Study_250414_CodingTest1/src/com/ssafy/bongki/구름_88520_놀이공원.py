from collections import defaultdict, deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    size = 1
    while queue:
        node = queue.popleft()
        for nei in graph[node]:
            if not visited[nei]:
                visited[nei] = True
                queue.append(nei)
                size += 1
    return size

n, m = map(int, input().split())
graph = defaultdict(list)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

max_count = 0
target_node = 0

for removed in range(1, n+1):
    visited = [False] * (n+1)
    visited[removed] = True
    count = 0

    for node in range(1, n+1):
        if not visited[node]:
            bfs(graph, node, visited)
            count += 1

    if count > max_count:
        max_count = count
        target_node = removed

print(target_node)
