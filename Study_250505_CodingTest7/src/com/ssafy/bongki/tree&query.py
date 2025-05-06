import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, R, Q = map(int, input().split())
tree = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)

subtree_size = [0] * (N + 1)

def dfs(node, parent):
    subtree_size[node] = 1  # 자기 자신 포함
    for neighbor in tree[node]:
        if neighbor != parent:
            dfs(neighbor, node)
            subtree_size[node] += subtree_size[neighbor]

dfs(R, -1)

for _ in range(Q):
    query_node = int(input())
    print(subtree_size[query_node])
