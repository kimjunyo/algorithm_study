import sys
from collections import deque
input = sys.stdin.readline

T = int(input())  # 테스트케이스 수

for _ in range(T):
    n, k = map(int, input().split())  # 건물 수, 규칙 수
    time = [0] + list(map(int, input().split()))  #건물 시간 인덱스고려
    indegree = [0] * (n + 1) 
    graph = [[] for _ in range(n + 1)]
    # 그래프 방향이 주어진걸로 이용하고 각 노드마다 딸려있는 부모노드가 몇개인지 확인 후 나중에 고려할 수 있게 함
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x].append(y)
        indegree[y] += 1

    target = int(input())  # 목표 건물

    dp = [0] * (n + 1)

    # 위상 정렬 시작
    q = deque()
    for i in range(1, n + 1):
        if indegree[i] == 0:
            q.append(i)
            dp[i] = time[i] #부모노드가 없으면 무조건 루트임 큐에 실어서 처리
  #큐에서 각 타임에 맞게 dp로 계산
    while q:
        now = q.popleft()
        for next in graph[now]:
            indegree[next] -= 1 #부모 모두 처리한 경우를 위해 없애기
            dp[next] = max(dp[next], dp[now] + time[next])
            if indegree[next] == 0:
                q.append(next)

    print(dp[target])
