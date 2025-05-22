from itertools import combinations

n = int(input())
arr = []
teachers = []
students = []
candidates = []
for _ in range(n):
    data = list(input().split())
    arr.append(data)

for i in range(n):
    for j in range(n):
        if arr[i][j] == 'T':
            teachers.append((i, j))
        elif arr[i][j] == 'X':
            candidates.append((i, j))
        else:
            students.append((i, j))


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

monitored_count = 0

def dfs(x, y, d):
    # print(x, y)
    global monitored_count
    if arr[x][y] == 'X' or arr[x][y] == 'S':
        if arr[x][y] == 'S':
            arr[x][y] = 'X'
            monitored_count += 1
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            return
        dfs(nx, ny, d)

obstacles_list = list(combinations(candidates, 3))
for obstacles in obstacles_list:
    # 장애물 설치
    monitored_count = 0

    for obstacle in obstacles:
        ox, oy = obstacle
        arr[ox][oy] = 'O'

    # print(arr)

    for teacher in teachers:
        tx, ty = teacher
        # print('tx, ty', tx, ty)
        for d in range(4):
            nx = tx + dx[d]
            ny= ty + dy[d]
            # print('nx,ny', nx,ny)
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            dfs(nx, ny, d)

    if monitored_count == 0:
        print('YES')
        exit(0)

    # 원상 복구
    for obstacle in obstacles:
        ox, oy = obstacle
        arr[ox][oy] = 'X'
    for student in students:
        sx, sy = student
        arr[sx][sy] = 'S'

print('NO')
