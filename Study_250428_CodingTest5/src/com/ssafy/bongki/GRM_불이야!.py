import sys
from collections import deque

def bfs(x,y):
	v[x][y] = 1 
	q = deque()
	q.append((x,y))
	while q:
		x,y = q.popleft()
		for i in range(4):
			nx,ny = x+dx[i],y+dy[i]
			if 0<=nx<n and 0<=ny<m and (g[nx][ny] == '.' or g[nx][ny]=='@') and v[nx][ny] == 0:
				v[nx][ny] = v[x][y] + 1
				if g[nx][ny] == '@':
					print(v[nx][ny]-2)
					exit(0)
				q.append((nx,ny))
	return (-1,-1)
n,m = map(int,sys.stdin.readline().split())
g = [sys.stdin.readline().rstrip() for _ in range(n)]
v = [[0 for _ in range(m)] for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
find = []
for i in range(n):
	for j in range(m):
		if g[i][j] == '&':
			bfs(i,j)

print(-1)
