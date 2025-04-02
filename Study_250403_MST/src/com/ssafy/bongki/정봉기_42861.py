def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])  # 경로 압축
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

def solution(n, costs):
    # 1. 간선을 비용 기준으로 정렬
    costs.sort(key=lambda x: x[2])
    
    parent = [i for i in range(n)]
    rank = [0] * n
    total_cost = 0
    edge_count = 0
    
    # 2. 크루스칼 알고리즘 적용
    for a, b, cost in costs:
        if union(parent, rank, a, b):  # 연결 성공 시 비용 추가
            total_cost += cost
            edge_count += 1
            if edge_count == n - 1:  # MST 완성
                break
                
    return total_cost
