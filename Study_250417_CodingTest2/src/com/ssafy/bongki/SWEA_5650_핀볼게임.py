
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 각 블록(1~5)에서 들어오는 방향에 따른 반사(꺾임) 규칙
# bounce[블록넘버][방향성] = 새로운 방향
bounce = {
    1: {0: 2, 1: 3, 2: 1, 3: 0},
    2: {0: 1, 1: 3, 2: 0, 3: 2},
    3: {0: 3, 1: 2, 2: 0, 3: 1},
    4: {0: 2, 1: 0, 2: 3, 3: 1},
    5: {0: 2, 1: 3, 2: 0, 3: 1}  # 블록5는 어떤 방향에서 오더라도 반대로 튕깁니다.
}


def wormhole(x, y, number):
    """
    현재 좌표 (x, y)가 속한 웜홀 번호 넘버의 pair 좌표를 반환.
    (자기 자신이 아닌 다른 쪽 좌표를 찾아서 반환)
    """
    for i in range(n):
        for j in range(n):
            if grid[i][j] == number and (i != x or j != y):
                return i, j

def simulate(start_x, start_y, direction):
    """
    빈칸인 시작점에서 주어진 방향으로 발사했을 때 얻을 수 있는 점수를 시뮬레이션.
    점수 획득운 벽 또는 블록에 부딪힐 때마다 1점씩 추가.
    시뮬레이션은 시작 위치로 돌아오거나 블랙홀(-1)에 도착하면 종료.
    """
    score = 0
    x, y = start_x, start_y
    cur_dir = direction

    while True:
        nx = x + dx[cur_dir]
        ny = y + dy[cur_dir]

        # 보드 바깥에 나가면 벽에 부딪힌 것으로 처리 (방향 반전)
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            score += 1
            cur_dir = (cur_dir + 2) % 4  # 반대 방향
            x, y = nx, ny  # 현재 위치를 바깥 좌표로 잠깐 옮긴 후, 다음 반복에서 처리됨
            continue

        cell = grid[nx][ny]

        # 시작점으로 돌아오거나 블랙홀(-1)을 만나면 종료
        if (nx, ny) == (start_x, start_y) or cell == -1:
            return score

        # 빈 칸이면 그대로 이동
        if cell == 0:
            x, y = nx, ny
            continue

        # 웜홀 (6~10): 다른 쪽 웜홀 좌표로 이동 (점수는 증가하지 않음)
        if 6 <= cell <= 10:
            x, y = wormhole(nx, ny, cell)
            continue

        # 블록(1~5)을 만난 경우
        if 1 <= cell <= 5:
            score += 1
            cur_dir = bounce[cell][cur_dir]  # 블록에 따른 반사(꺾임)
            x, y = nx, ny
            continue


# 테스트 케이스 처리
T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    grid = [list(map(int, input().split())) for _ in range(n)]

    result = 0
    # 모든 빈 칸을 시작점으로 하여 4가지 방향
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 0:
                for d in range(4):
                    result = max(result, simulate(i, j, d))

    print(f"#{tc} {result}")


