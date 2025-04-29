from collections import deque

n,k=map(int,input().split())
limit=100001
cnt=[0]*limit
visited=[False]*limit

def bfs(x,end):
    queue=deque()
    queue.append(x)

    while queue:
        x=queue.popleft()
      
        if x==end:
          return cnt[x]
      
        #순간이동은 우선순위를 앞으로 둠
        if -1<x*2<limit and visited[x*2]==0:
            queue.appendleft(x*2)
            cnt[x*2]=cnt[x]
            visited[x*2]=True
        # 이후 위치 기록
        if -1<x-1<limit and visited[x-1]==0:
            queue.append(x-1)
            cnt[x-1] = cnt[x]+1
            visited[x-1]=True
        if -1<x+1<limit and visited[x+1]==0:
            queue.append(x+1)
            cnt[x+1] = cnt[x]+1
            visited[x+1]=True



print(bfs(n,k))
