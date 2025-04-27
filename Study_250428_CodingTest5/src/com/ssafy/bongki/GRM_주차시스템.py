from collections import deque

n,m = map(int,input().split())
grid = [list(map(int,input().split())) for _ in range(n)]
visit = [[0]*m for _ in range(n)]
#그리드에 0과 2만 있는 경우만 탐색
#그리고 그거에 따른 점수 list 만들기

def bfs(x,y):
	q= deque()
	dx = [-1,1,0,0]
	dy = [0,0,-1,1]
	q.append((x,y))
	visit[x][y] = 1
	if grid[x][y] == 0:
		counts = 1
	elif grid[x][y] == 2:
		counts = -2
	while q:
		x,y = q.popleft()
		for t in range(4):
			nx,ny = x+dx[t],y+dy[t]
			if 0<=nx<n and 0<=ny<m and visit[nx][ny] == 0:
				if (grid[nx][ny] == 0):
					q.append((nx,ny))
					visit[nx][ny] = 1
					counts += 1
				elif (grid[nx][ny] == 2):
					q.append((nx,ny))
					visit[nx][ny] = 1
					counts -= 2
	return counts
ans = -1000002

for i in range(n):
	for j in range(m):
		if grid[i][j] == 1:
			visit[i][j] = 1

for i in range(n):
	for j in range(m):
		if visit[i][j] !=1:
			ans = max(ans,bfs(i,j))
			
if ans == -1000002:
	print(0)
elif ans>=0:
	print(ans)
else:
	print(0)
