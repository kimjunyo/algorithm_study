# 테스트 케이스 처리

# 미생물이 움직일공간
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
dir = {1: 2, 2: 1, 3: 4, 4: 3}
# (상: 1, 하: 2, 좌: 3, 우: 4)
def updateInfo():
    for i in range(k):
        info[i][0] = info[i][0] + dx[info[i][3]-1]
        info[i][1] = info[i][1] + dy[info[i][3]-1]

        # 셀 -1에 부딪힐때 경우처리
        if grid[info[i][0]][info[i][1]] == -1:
            info[i][2] //= 2
            info[i][3] = dir[info[i][3]]
    # 미생물이 -1에서 만날 경우는 없으므로 확인은 마지막에서따로한다

    check()
    # 정리하고 겹쳐진 부분 다시 확인인

def check():
    from collections import defaultdict

    pos_map = defaultdict(list)

    # 각 위치별로 군집 인덱스를 모음
    for i in range(k):
        if info[i][2] == 0:
            continue
        pos = (info[i][0], info[i][1])
        pos_map[pos].append(i)

    # 같은 위치에 군집이 2개 이상 있다면 병합
    for indices in pos_map.values():
        if len(indices) > 1:
            # 가장 큰 군집 찾기 (미생물 수 기준)
            max_count = -1
            main = -1
            for idx in indices:
                if info[idx][2] > max_count:
                    max_count = info[idx][2]
                    main = idx

            # 나머지 군집을 main에 병합
            for idx in indices:
                if idx != main:
                    info[main][2] += info[idx][2]
                    info[idx][2] = 0

T = int(input())
for tc in range(1, T + 1):
    # n은 셀의 개수 , m은 격리 시간 , k는 미생물 군집개수
    n,m,k = map(int,input().split())
    info = [list(map(int, input().split())) for _ in range(k)]
    # 0은 행 1은 열 2는 미생물 수 3은 이동방향.
    grid = [[0]*n for i in range(n)]
    for i in range(n):
        for j in range(n):
            if i==0 or j==0 or i==n-1 or j==n-1:
                grid[i][j] = -1
    # -1 셀과 최초위치 지정 info값에 맞춰지정

    """
    격리시간마다 방향에 따른 이동을 함
    이때, 격자끝에 닿으면 미생물 수를 2로 나누고 진행 방향을 바꿈     
    """
    result = 0
    # 모든 빈 칸을 시작점으로 하여 4가지 방향
    for i in range(m):
        updateInfo()
    # 총 미생물합
    for i in range(k):
        result += info[i][2]

    print(f"#{tc} {result}")







