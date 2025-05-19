
import sys
input = sys.stdin.readline

r, c, t = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(r)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 공기청정기 위치 찾기
aircon = []
for i in range(r):
    if grid[i][0] == -1:
        aircon.append(i)

for _ in range(t):
    # 먼지 확산
    tmp = [[0] * c for _ in range(r)]
    for x in range(r):
        for y in range(c):
            if grid[x][y] > 0:
                spread = grid[x][y] // 5
                cnt = 0
                for d in range(4):
                    nx, ny = x + dx[d], y + dy[d]
                    if 0 <= nx < r and 0 <= ny < c and grid[nx][ny] != -1:
                        tmp[nx][ny] += spread
                        cnt += 1
                grid[x][y] -= spread * cnt
    for x in range(r):
        for y in range(c):
            grid[x][y] += tmp[x][y]

    # 공기청정기 작동
    upper = aircon[0]
    lower = aircon[1]

    # 위쪽 (반시계)
    for i in range(upper-1, 0, -1):
        grid[i][0] = grid[i-1][0]
    for i in range(c-1):
        grid[0][i] = grid[0][i+1]
    for i in range(upper):
        grid[i][c-1] = grid[i+1][c-1]
    for i in range(c-1, 1, -1):
        grid[upper][i] = grid[upper][i-1]
    grid[upper][1] = 0

    # 아래쪽 (시계)
    for i in range(lower+1, r-1):
        grid[i][0] = grid[i+1][0]
    for i in range(c-1):
        grid[r-1][i] = grid[r-1][i+1]
    for i in range(r-1, lower, -1):
        grid[i][c-1] = grid[i-1][c-1]
    for i in range(c-1, 1, -1):
        grid[lower][i] = grid[lower][i-1]
    grid[lower][1] = 0

result = 0
for i in range(r):
  for j in range(c):
    if grid[i][j] > 0:
      result += grid[i][j]
print(result)
    
