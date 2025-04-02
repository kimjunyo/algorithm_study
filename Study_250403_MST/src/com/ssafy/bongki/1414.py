import sys

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, rank, a, b):
    rootA = find(parent, a)
    rootB = find(parent, b)
    
    if rootA != rootB:
        if rank[rootA] > rank[rootB]:
            parent[rootB] = rootA
        elif rank[rootA] < rank[rootB]:
            parent[rootA] = rootB
        else:
            parent[rootB] = rootA
            rank[rootA] += 1
        return True
    return False

def cable_length(c):
    if 'a' <= c <= 'z':  
        return ord(c) - ord('a') + 1
    elif 'A' <= c <= 'Z': 
        return ord(c) - ord('A') + 27
    return 0  

def main():
    input = sys.stdin.read
    data = input().split()
    
    n = int(data[0])
    edges = []
    total_cable = 0
    
    index = 1
    for i in range(n):
        for j, c in enumerate(data[index]):
            length = cable_length(c)
            total_cable += length
            if i != j and length > 0:
                edges.append((length, i, j))
        index += 1
    
    edges.sort()
    parent = [i for i in range(n)]
    rank = [0] * n
    
    used_cable = 0
    edge_count = 0
    
    for cost, a, b in edges:
        if union(parent, rank, a, b):
            used_cable += cost
            edge_count += 1
            if edge_count == n - 1: 
                break
    
    if edge_count == n - 1:
        print(total_cable - used_cable)
    else:
        print(-1)

if __name__ == "__main__":
    main()
