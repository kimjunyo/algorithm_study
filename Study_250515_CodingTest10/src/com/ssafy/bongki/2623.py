import sys
from collections import deque
input = sys.stdin.readline
# N 가수의수 m 보조 pd의 수
n,m = map(int,input().split())
pdArr = []

graph = [[] for _ in range(n+1)]
indegree = [0]*(n+1)

for i in range(m):
  pdArr.append(list(map(int,input().split()))[1:])

for pd in pdArr:
  for i in range(len(pd)):
      for j in range(i+1,len(pd)):
        graph[pd[i]].append(pd[j])
        indegree[pd[j]] += 1 #만약 맨뒤에만 있는 애면 0으로 바로호출해야함

#담은 그래프 내에서 depth 끝까지 다 찾아들어갈 수 있다면 ㄱㄱ n개까지. 없으면 끝
q=deque()
ans = []

visited = [False]*(n+1)
for x in range(1,n+1):
  visited[0] = True
  if indegree[x] == 0:
    q.append(x)
while q:
  y = q.popleft()
  if visited[y] == False:
    visited[y] = True
    ans.append(y)
  for i in graph[y]:
    indegree[i]-=1
    if indegree[i] ==0:
      q.append(i)
      
# 결과 출력 또는 사이클 존재 여부 확인
if len(ans) == n:
    for x in ans:
        print(x)
else:
    print(0)  # 사이클 존재로 정렬 불가
