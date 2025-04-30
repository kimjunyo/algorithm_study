from collections import deque
dxs =[-1,1,0,0]
dys =[0,0,-1,1]
n = 1000
while n>0:
    n = int(input())
    if n == 0:
        break
    grid = [list(map(int,input().split())) for _ in range(n)]
    visited = [[False]*n for _ in range(n)]
    ans = [[1000]*n for _ in range(n)]

    # 0,0에서 n-1,n-1로 가는 방법론 찾기
    q = deque()
    q.append((0,0))
    ans[0][0] = grid[0][0]

    while q:
        x,y = q.popleft()
        visited[x][y] = True
        for dx,dy in zip(dxs,dys):
            newx = x+dx
            newy = y+dy
            if 0<=newx<n and 0<=newy<n and visited[newx][newy] == False:
                ans[newx][newy] = min(ans[newx][newy] ,ans[x][y] + grid[newx][newy])
                q.append((newx,newy))
    print(ans[n-1][n-1])
