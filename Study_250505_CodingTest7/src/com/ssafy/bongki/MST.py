import sys
from collections import deque

a, b = map(int, sys.stdin.readline().split())

arr = [list(map(int,sys.stdin.readline().split())) for _ in range(b)]
visited  = [False]*(a+1) 

graph = [[] for _ in range(a+1)]
for line in arr:
  graph[li[2]))ne[0]].append((line[1],line

summ = 0

q = deque([(1,0)])
ans_graph = [[] for _ in range(a+1)]
while q:
  x,weight = q.popleft()
  visited[x] = True
  for y,add in graph[x]:
    weight_new = weight+ add
    q.append((y,weight_new))
    ans_graph[y].append(weight_new)
print(min(ans_graph[a]))
